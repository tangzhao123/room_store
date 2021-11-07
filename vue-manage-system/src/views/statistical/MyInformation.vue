sss<template>
	<div>
		<div class="user-info" style="width: 100%;margin-top: 10px;">
			<div class="user-info-cont">
				我的信息
			</div>
		</div>
		<div>
			<el-form ref="form" :model="message" label-width="80px" :rules="rules">
				<div style="display: inline-block;">
					<el-form-item label="手机号" :label-width="formLabelWidth">
						<el-input disabled v-model="message.userPhone" clearable
							style="width:180px;margin-right: 20px;" />
					</el-form-item>
				</div>
				<div style="display: inline-block;">
					<el-form-item label="姓名" :label-width="formLabelWidth">
						<el-input v-model="message.userName" clearable style="width:180px;margin-right: 20px;" />
					</el-form-item>
				</div>
				<el-form-item label="上传头像">
						<el-upload class="upload-demo" ref="upload" action="" :auto-upload="false"
							:on-change="headPortrait">
							<!-- <i class="el-icon-upload"></i> -->
							<div class="el-upload__text">
							<img :src="message.userPortait" style="width:100%;height:100%">
							</div>
						</el-upload>
				</el-form-item>
			</el-form>
			<el-button type="primary" style="margin-right: 50px;margin-top: 20px;" @click="editmassage()">
				添加药品
			</el-button>
		</div>
	</div>

</template>

<script>
	export default {
		data() {
			return {
				message: {
					userName: this.$store.state.token.userName,
					userPortait: this.$store.state.token.userPortait,
					userCard: this.$store.state.token.userCard,
					userPhone: this.$store.state.token.userPhone
				},
				portait: '',
			}
		},
		methods: {
			editmassage(){
				this.axios.post('editmassage',this.message).then((v)=>{
					if(v.data == 'ok'){
						this.$message.success("修改成功");
					}
				})
			},
			//委托协议照片
			headPortrait(file) {
				const self = this
				let reader = new FileReader()
				reader.readAsDataURL(file.raw)
				reader.onload = function() {
					let img_base64 = this.result
					self.message.userPortait = img_base64;
				}
			},
			//图片转码
			Base64(file) {
				return new Promise(function(resolve, reject) {
					let reader = new FileReader();
					let imgResult = "";
					reader.readAsDataURL(file);
					reader.onload = function() {
						imgResult = reader.result;
					};
					reader.onerror = function(error) {
						reject(error);
					};
					reader.onloadend = function() {
						resolve(imgResult)
					}
				})
			},
		},
		created() {
			this.portait
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
