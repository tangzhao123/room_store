<template>
	<div class="login-wrap">
		<div class="ms-login">
			<div class="ms-title">后台管理系统</div>
			<el-form :model="param" v-if="conceal" :rules="rules1" ref="login" label-width="0px" class="ms-content">
				<el-form-item prop="username">
					<el-input v-model="param.username" placeholder="手机号">
						<template #prepend>
							<el-button icon="el-icon-user"></el-button>
						</template>
					</el-input>
				</el-form-item>
				<el-form-item prop="password">
					<el-input type="password" placeholder="密码" v-model="param.password" @keyup.enter="submitForm()">
						<template #prepend>
							<el-button icon="el-icon-lock"></el-button>
						</template>
					</el-input>
				</el-form-item>
				<span style="font-size:12px;text-align:center;display:block;">没有账号?
					<el-button @click="conceal=!conceal" type="text" size="small">点击注册</el-button>
				</span>
				<div class="login-btn" style="margin-top: 10px;">
					<el-button type="primary" :loading="loading" @click="submitForm()">登录</el-button>
				</div>
			</el-form>
			<el-form :model="register" v-if="!conceal" :rules="rules2" ref="register" label-width="0px"
				class="ms-content">
				<el-form-item prop="userName">
					<el-input v-model="register.userName" placeholder="用户名">
						<template #prepend>
							<el-button icon="el-icon-user"></el-button>
						</template>
					</el-input>
				</el-form-item>
				<el-form-item prop="userPhone">
					<el-input v-model="register.userPhone" placeholder="手机号">
						<template #prepend>
							<el-button icon="el-icon-user"></el-button>
						</template>
					</el-input>
				</el-form-item>
				<el-form-item prop="userPass">
					<el-input type="password" placeholder="请输入密码" v-model="register.userPass"
						@keyup.enter="submitForm()">
						<template #prepend>
							<el-button icon="el-icon-lock"></el-button>
						</template>
					</el-input>
				</el-form-item>
				<el-form-item prop="password2">
					<el-input type="password" placeholder="请再次输入密码" v-model="register.password2"
						@keyup.enter="submitForm()">
						<template #prepend>
							<el-button icon="el-icon-lock"></el-button>
						</template>
					</el-input>
				</el-form-item>
				<el-input disabled=false v-model="dizhi" placeholder="用户所在地">
					<template #prepend>
						<el-button icon="el-icon-user"></el-button>
					</template>
				</el-input>
				<span style="font-size:12px;text-align:center;display:block;">已有账号?
					<el-button @click="conceal=!conceal" type="text" size="small">点击登录</el-button>
				</span>
				<div class="login-btn" style="margin-top: 10px;">
					<el-button type="primary" :loading="loading" @click="registers()">注册</el-button>
				</div>
			</el-form>
		</div>
	</div>
</template>

<script>
	export default {
		data() {
			const validatePhone = (rule, value, callback) => {
				if (!(/^1[34578]\d{9}$/.test(value))) {
					callback(new Error('请输入正确的手机号'))
				} else {
					callback()
				}
			}
			const passWords = (rule, value, callback) => {
				if (!(/^(?=.*\d)(?=.*[a-zA-Z])[a-z0-9]{8,12}$/.test(value))) {
					callback(new Error('密码格式字母和数字的组合,八至十二位'))
				} else {
					callback()
				}
			}
			return {
				conceal: true,
				loading: false,
				param: {
					username: "17673977795",
					password: "1234.a.0"
				},
				register: {
					userName: "",
					userPhone: "",
					userPass: "",
					password2: "",
					userProvince: "湖南省",
					userCity: "长沙市",
				},
				dizhi: "湖南省长沙市",
				rules1: {
					username: [{
							required: true,
							message: "请输入电话号码",
							trigger: "blur"
						},
						{
							validator: validatePhone,
							trigger: 'blur'
						}
					],
					password: [{
						required: true,
						message: "请输入密码",
						trigger: "blur"
					}]
				},
				rules2: {
					userName: [{
						required: true,
						message: "请输入名字",
						trigger: "blur"
					}],
					userPhone: [{
							required: true,
							message: "请输入电话号码",
							trigger: "blur"
						},
						{
							validator: validatePhone,
							trigger: 'blur'
						}
					],
					userPass: [{
							required: true,
							message: "请输入密码",
							trigger: "blur"
						},
						{
							validator: passWords,
							trigger: 'blur'
						},
					],
					password2: [{
							required: true,
							message: "请输入密码",
							trigger: "blur"
						},
						{
							validator: passWords,
							trigger: 'blur'
						},
					]
				}
			};
		},
		created() {
			this.$store.commit("clearTags");
		},
		methods: {
			submitForm() {
				this.$refs.login.validate(valid => {
					if (valid) {
						this.loading = true;
						this.axios.post('login', {
							phone: this.param.username,
							pass: this.param.password
						}).then(response => {
							console.log(response.data)
							if (response.data == null || response.data == '') {
								this.$message.warning("账户不存在");
							} else {
								this.$message.success("登录成功");
								this.$store.state.token = response.data;
								const users = JSON.stringify(response.data)
								localStorage.setItem("token", users);
								this.$router.push("/dashboard");
							}
							this.loading = false
							console.log(this.$store.state.token.userName)
						})
					} else {
						this.$message.error("请输入账号和密码");
						return false;
					}
				});
			},
			rest() {
				this.register = {
					userName: "",
					userPhone: "",
					userPass: "",
					password2: "",
					userProvince: "湖南省",
					userCity: "长沙市",
				}
			},
			registers() {
				this.$refs.register.validate(valid => {
					if (valid) {
						if (this.register.password1 == this.register.password1) {
							this.loading = true;
							this.axios.post('addusers', this.register).then(response => {
								if (response.data == 'ok') {
									this.$message.success("注册成功!请登录");
									this.rest();
								} else if (response.data == null || response.data == '') {
									this.$message.warning("账户已存在");
								} else {
									this.$message.error("注册失败");
								}
								this.loading = false
							})
						} else {
							this.$message.warning("请保证两次输入的密码一致");
						}
					} else {
						this.$message.error("请输入账号和密码");
						return false;
					}
				});
			},
		}
	};
</script>

<style scoped>
	.login-wrap {
		position: relative;
		width: 100%;
		height: 100%;
		background-image: url(../assets/img/login-bg.jpg);
		background-size: 100%;
	}

	.ms-title {
		width: 100%;
		line-height: 50px;
		text-align: center;
		font-size: 20px;
		color: #fff;
		border-bottom: 1px solid #ddd;
	}

	.ms-login {
		position: absolute;
		left: 50%;
		top: 50%;
		width: 350px;
		margin: -190px 0 0 -175px;
		border-radius: 5px;
		background: rgba(255, 255, 255, 0.3);
		overflow: hidden;
	}

	.ms-content {
		padding: 30px 30px;
	}

	.login-btn {
		text-align: center;
	}

	.login-btn button {
		width: 100%;
		height: 36px;
		margin-bottom: 10px;
	}

	.login-tips {
		font-size: 12px;
		line-height: 30px;
		color: #fff;
	}
</style>
