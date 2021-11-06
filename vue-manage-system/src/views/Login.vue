<template>
	<div class="login-wrap">
		<div class="ms-login">
			<div class="ms-title">后台管理系统</div>
			<el-form :model="param" :rules="rules" ref="login" label-width="0px" class="ms-content">
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
				<div class="login-btn">
					<el-button type="primary" :loading="loading" @click="submitForm()">登录</el-button>
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
			return {
				loading: false,
				param: {
					username: "17673977795",
					password: "hjm123456789"
				},
				rules: {
					username: [{
							required: true,
							message: "请输入用户名",
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
			}
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
