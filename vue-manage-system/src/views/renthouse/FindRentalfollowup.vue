<template>
	<div style="margin-top:30px">
		<el-row>
			<el-col :span="8">
				<el-form label-width="150px">
					<el-form-item label="跟进方式"> 
						{{rentalfollowup.refoWay}}
					</el-form-item>
				</el-form>
			</el-col>
		</el-row>
		<el-row>
			<el-col :span="24">
				<el-form label-width="150px">
					<el-form-item label="跟进内容分类">
						{{rentalfollowup.refoType}}
					</el-form-item>
				</el-form>
			</el-col>
		</el-row>
		<el-row>
			<el-col :span="15">
				<el-form label-width="150px">
					<el-form-item label="跟进内容">
						{{rentalfollowup.refoNeirong}}	
					</el-form-item>
				</el-form>
			</el-col>
		</el-row>
		<el-row>
			<el-form label-width="150px">
				<el-form-item label="">
					<img :src="rentalfollowup.refoImg" style="width:250px;height:250px">
				</el-form-item>
			</el-form>
		</el-row>
		<el-row>
			<el-col :span="5">
			</el-col>
			<el-col :span="5">
				<el-button @click="quxiao()">返回</el-button>
			</el-col>
		</el-row>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				rentalfollowup:{
					refoRehoNo:"",
					refoImg:"",
					refoWay:"",
					refoType:"",
					refoNeirong:""
				},
				no:"",
			}
		},
		methods: {
			quxiao(){
				// this.clear();
				this.$router.go(-1);
			},
			getData(){
				let params = JSON.parse( this.$route.query.params);
				this.no = params.no;

				this.axios({
					url: 'Renthouse/findRentalfollowupByNo',
					params:{
						param:this.no
					}
				}).then((v) => {
					this.rentalfollowup = v.data
				}).catch()
			}
		},
		created() {
			this.getData();
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
