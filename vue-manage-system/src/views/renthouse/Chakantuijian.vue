<template>
	<div>
		<h4>查看详情</h4>
		<hr>
		<div style="margin:30px">
			<div style="float: left;">
				<img :src="housing.rehoZhutu" style="width:100px;height:100px">
			</div>
			<div style="float:left;margin-left: 5px;">
				<div style="height: 10px;">
				<span style="font-size: 20px;color:#333; float: left;">
					{{housing.rehoCommunity}}{{housing.rehoBuilding}}{{housing.rehoUnit}}{{housing.rehoRoomnumber}}</span>
				</div>
				<div style="height: 33px;">
				<br>
				<span style="font-size: 14px;float: left;">
					{{housing.rehoHousetype}} {{housing.rehoOrientation}} {{housing.rehoFitmenttype}} {{housing.rehoPayway}}</span>
				</div>
				<br>
				<div>
				<span style="color: #f23036;font-size: 22px;margin-right:5px;float: left;">{{housing.rehoRent}}元/月</span>&nbsp;&nbsp;
				<span style="font-size: 17px;float: left;">{{housing.rehoCoveredarea}}㎡</span>
				</div>
			</div>
			<div>
				<span style="font-size: 18px;color:#333; margin-left:300px">经纪人：{{users.userName}}</span><br><br><br>
				<span style="font-size: 18px;color:#333; margin-left:300px">经纪人电话：{{users.userPhone}}</span>
			</div>
		</div>
		<h4  style="margin-top:30px">推荐客源</h4>
		<hr>
		<el-table :data="tableData">
			<el-table-column prop="customersDate" label="时间">
			</el-table-column>
			<el-table-column prop="customersState" label="跟进状态">
				<template v-slot:default="v">
					{{v.row.customersState == 0 ?"未跟进":v.row.customersState == 1 ? "有效":"无效"}}
				</template>
			</el-table-column>
		</el-table>
	</div>
</template>

<script>
import { ElMessageBox } from 'element-plus'
export default {
		data() {
			return {
				tableData:[],
				no:"",
				tableData1:[],
				housing:{},
				users:{}
			}
		},
		methods: {
			wancheng(row){
				ElMessageBox.confirm('您确定完成跟进么?')
				.then(() => {
					this.axios({
					url: 'Renthouse/updateRentalpublicpoolsKYCZ',
					params:{	
						customersState: 1,
						secondaryNumber:row.customersId
					}
				}).then((v) => {
					this.getDate();
					this.$message.success("成功！");
					console.log(v)
				}).catch()
				})
				.catch(() => {
				})
			},
			wuxiao(row){
				ElMessageBox.confirm('您确定无效么?')
				.then(() => {
					this.axios({
					url: 'Renthouse/updateRentalpublicpoolsKYCZ',
					params:{	
						customersState: 2,
						secondaryNumber:row.customersId
					}
				}).then((v) => {
					this.getDate();
					this.$message.success("成功！");
					console.log(v)
				}).catch()
				})
				.catch(() => {
				})
			},
			getDate(){
				let params = JSON.parse( this.$route.query.params);
				this.no = params.no;

				this.axios({
					url: 'Renthouse/findRentalpublicpoolsAndCustomers',
					params:{
						param:this.no
					}
				}).then((v) => {
					this.tableData = v.data
					console.log(this.tableData)
				}).catch()
				this.axios({
					url: 'Renthouse/findRentalhousingByNumber',
					params:{
						param:this.no
					}
				}).then((v) => {
					this.tableData1 = v.data
					this.housing = this.tableData1[0]
					this.users = this.housing.users
					console.log(this.housing);
				}).catch()
			},
			chakan(row){
				this.$router.push({
					path:"/find-rentalfollowup",
					query: {
						params: JSON.stringify({no:row.refoNo}) 
					}
				});
			},
		},
		created() {
			this.getDate();
		}
	}
</script>

<style>
.dianji span{
	color: #2a75ec;
	cursor:pointer;
	filter: alpha(Opacity=100);
	opacity: 1;
}
.dianji :hover{
	filter: alpha(Opacity=100);
	opacity: 1;
}
</style>
