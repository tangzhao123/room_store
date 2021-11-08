<template>
	<div>
		<div class="user-info" style="width: 100%;margin-top: 10px;">
			<div class="user-info-cont">
				我的信息
			</div>
		</div>
		<el-form :model="param" :rules="rules2" ref="param" label-width="10px" style="margin-top: 20px;">
			<el-form-item>
				<el-input style="width:280px;" disabled v-model="param.userPhone" placeholder="手机号">
					<template #prepend>
						<el-button icon="el-icon-user"></el-button>
					</template>
				</el-input>
			</el-form-item>
			<el-form-item prop="userPass">
				<el-input type="password" style="width:280px;" placeholder="请输入密码" v-model="param.userPass"
					@keyup.enter="submitForm()">
					<template #prepend>
						<el-button icon="el-icon-lock"></el-button>
					</template>
				</el-input>
			</el-form-item>
			<el-form-item prop="userPass2">
				<el-input type="password" style="width:280px;" placeholder="请输入新密码" v-model="param.userPass2"
					@keyup.enter="submitForm()">
					<template #prepend>
						<el-button icon="el-icon-lock"></el-button>
					</template>
				</el-input>
			</el-form-item>
			<el-form-item prop="userPass3">
				<el-input type="password" style="width:280px;" placeholder="请再次输入新密码" v-model="param.userPass3"
					@keyup.enter="submitForm()">
					<template #prepend>
						<el-button icon="el-icon-lock"></el-button>
					</template>
				</el-input>
			</el-form-item>
			<div class="login-btn" style="margin-top: 10px;">
				<el-button type="primary" style="margin-right: 50px;margin-top: 20px;" @click="submitForm()">
					确定
				</el-button>
			</div>
		</el-form>
	</div>
</template>

<script>
	export default {
		data() {
			const passWords = (rule, value, callback) => {
				if (!(/^(?=.*\d)(?=.*[a-zA-Z])[a-z0-9]{8,12}$/.test(value))) {
					callback(new Error('密码格式字母和数字的组合,八至十二位'))
				} else {
					callback()
				}
			}
			return {
				param: {
					userPhone: this.$store.state.token.userPhone,
					userName: this.$store.state.token.userName,
					userPass: "",
					userPass2: "",
					userPass3: ""
				},
				rules2: {
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
					userPass2: [{
							required: true,
							message: "请输入密码",
							trigger: "blur"
						},
						{
							validator: passWords,
							trigger: 'blur'
						},
					],
					userPass3: [{
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
			}
		},
		methods: {
			submitForm() {
				this.$refs.param.validate(valid => {
					if (valid) {
						if(this.param.userPass != this.param.userPass2){
							this.axios.post('edituserpass', this.param).then(response => {
								if (response.data == null || response.data == '') {
									this.$message.warning("密码错误");
								} else if (response.data == 'ok') {
									this.$message.success("修改成功,请重新登录");
									localStorage.removeItem("token");
									this.$router.push("/login");
								} else {
									this.$message.error("修改失败");
								}
								console.log(this.$store.state.token.userName)
							})
						}else{
							this.$message.warning("新旧密码请勿一样");
						}
					} else {
						this.$message.error("请输入账号和密码");
						return false;
					}
				});
			},
		}
	}
</script>

<style>
	.user-info {
		display: flex;
		align-items: center;
		padding-bottom: 20px;
		border-bottom: 2px solid #ccc;
		margin-bottom: 20px;
	}

	.user-info-cont {
		padding-left: 50px;
		flex: 1;
		font-size: 14px;
		color: #999;
	}

	.user-info-cont div:first-child {
		font-size: 30px;
		color: #222;
	}
</style>
