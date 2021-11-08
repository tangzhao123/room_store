<template>
	<div style="margin-top:50px">
		<el-row>
			<el-col :span="8">
				<el-form label-width="150px">
					<el-form-item label="跟进方式"> 
						<el-select v-model="rentalfollowup.refoWay" placeholder="请选择">
							<el-option value="电话">电话</el-option>
							<el-option value="微信">微信</el-option>
							<el-option value="面访">面访</el-option>
							<el-option value="短信">短信</el-option>
							<el-option value="其他">其他</el-option>
						</el-select>
					</el-form-item>
				</el-form>
			</el-col>
		</el-row>
		<el-row>
			<el-col :span="24">
				<el-form label-width="150px">
					<el-form-item label="跟进内容分类">
						<el-checkbox-group v-model="refoType">
							<el-checkbox label="已租"></el-checkbox>
							<el-checkbox label="不租"></el-checkbox>
							<el-checkbox label="钥匙托管"></el-checkbox>
							<el-checkbox label="价格"></el-checkbox>
							<el-checkbox label="看房方式"></el-checkbox>
							<el-checkbox label="其他"></el-checkbox>
						</el-checkbox-group>
					</el-form-item>
				</el-form>
			</el-col>
		</el-row>
		<el-row>
			<el-col :span="15">
				<el-form label-width="150px">
					<el-form-item label="跟进内容">
						<el-input :rows="4" v-model="rentalfollowup.refoNeirong" placeholder="请输入房源优势详细信息"  type="textarea"/>
					</el-form-item>
				</el-form>
			</el-col>
		</el-row>
		<el-row>
			<el-form label-width="150px">
				<el-form-item label="">
					<el-col :span="6" class="fangyuantupian">
						<el-upload class="upload-demo" ref="upload" action="" drag multiple :auto-upload="false"
							:on-change="handleFileUploaderEntrust">
							<i class="el-icon-upload"></i>
							<div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
						</el-upload>
					</el-col>
				</el-form-item>
			</el-form>
		</el-row>
		<el-row>
			<el-col :span="5">
				<el-form label-width="150px">
					<el-form-item label="">
						<el-button type="primary" @click="queding()">确定</el-button>
					</el-form-item>
				</el-form>
			</el-col>
			<el-col :span="5">
				<el-button @click="quxiao()">取消</el-button>
			</el-col>
		</el-row>
	</div>
</template>

<script>
import { ElMessage } from 'element-plus'
	export default {
		data() {
			return {
				rentalfollowup:{
					refoNo:"",
					refoImg:"",
					refoName:"",
					refoPhone:"",
					refoWay:"",
					refoType:"",
					refoDate:"",
					refoRehoNo:"",
					refoNeirong:""
				},
				refoType:[],
				no:"",
			}
		},
		methods: {
			quxiao(){
				this.clear();
				this.$router.go(-1);
				
			},
			queding(){
				var fl = true;
				if(this.rentalfollowup.refoWay == ""){
					ElMessage({
						message: '请选择跟进方式',
						type: 'warning',
					})
				}else if(this.refoType == ""){
					ElMessage({
						message: '请选择跟进内容分类',
						type: 'warning',
					})
				}else if(this.rentalfollowup.refoNeirong == ""){
					ElMessage({
						message: '请输入跟进内容',
						type: 'warning',
					})
				}
				
				if(fl){
					let params = JSON.parse( this.$route.query.params);
					this.no = params.no;
					this.rentalfollowup.refoRehoNo = this.no;

					var a = ""
					this.refoType.forEach((v)=>{
						a += v+",";
					});
					if(a.length > 0){
						a = a.substr(0,a.length-1)
						this.rentalfollowup.refoType = a;
					}
					var use = this.$store.state.token;
					this.rentalfollowup.refoName = use.userName;
					this.rentalfollowup.refoPhone = use.userPhone;
					//获取当前时间并打印
					let yy = new Date().getFullYear();
					let mm = new Date().getMonth()+1;
					let dd = new Date().getDate();
					let hh = new Date().getHours();
					let mf = new Date().getMinutes()<10 ? '0'+new Date().getMinutes() : new Date().getMinutes();
					let ss = new Date().getSeconds()<10 ? '0'+new Date().getSeconds() : new Date().getSeconds();
					this.rentalfollowup.refoDate = yy+'-'+mm+'-'+dd+' '+hh+':'+mf+':'+ss

					console.log(this.rentalfollowup);

					this.axios.post("Renthouse/insertRentalfollowup", this.rentalfollowup).then((res) => {
						console.log(res)
						ElMessage({
							message: '新增成功！',
							type: 'success',
						})
						this.clear();
						this.$router.go(-1);
					}).catch(() => {
						this.$message.error("新增失败！")
					})
				}
			},
			clear(){
				this.rentalfollowup={
					refoNo:"",
					refoImg:"",
					refoName:"",
					refoPhone:"",
					refoWay:"",
					refoType:"",
					refoDate:"",
					refoRehoNo:"",
					refoNeirong:""
				}
				this.refoType=[]
				this.no=""
			},
			
			//照片
			handleFileUploaderEntrust(file) {
				const self = this
				let reader = new FileReader()
				reader.readAsDataURL(file.raw)
				reader.onload = function() {
					let img_base64 = this.result
					self.rentalfollowup.refoImg  = img_base64;
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
		}
	}
</script>

<style>
.fangyuantupian .upload-demo,
.fangyuantupian .el-upload {
	width: 362px !important;
	height: 182px !important;
}
</style>
