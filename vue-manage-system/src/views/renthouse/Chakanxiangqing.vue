<template>
	<div>
		<!-- <h4>查看详情</h4>
		<hr>
		<div>
			<el-table :data="tableData">
				<el-table-column prop="customersId" label="编号">
					<template  v-slot:default="v">
						<div style="float: left;">
							<img :src="v.row.rentalhousing.rehoZhutu" style="width:100px;height:100px">
							</div>
							<div style="float:left;margin-left: 5px;">
								<div style="height: 10px;">
								<span style="font-size: 20px;color:#333; float: left;">
									{{v.row.rentalhousing.rehoCommunity}}{{v.row.rentalhousing.rehoBuilding}}{{v.row.rentalhousing.rehoUnit}}{{v.row.rentalhousing.rehoRoomnumber}}</span>
								</div>
								<div style="height: 33px;">
								<br>
								<span style="font-size: 14px;float: left;">
									{{v.row.rentalhousing.rehoHousetype}} {{v.row.rentalhousing.rehoOrientation}} {{v.row.rentalhousing.rehoFitmenttype}} {{v.row.rentalhousing.rehoPayway}}</span>
								</div>
								<br>
								<div>
								<span style="color: #f23036;font-size: 22px;margin-right:5px;float: left;">{{v.row.rentalhousing.rehoRent}}元/月</span>&nbsp;&nbsp;
								<span style="font-size: 17px;float: left;">{{v.row.rentalhousing.rehoCoveredarea}}㎡</span>
								</div>
							</div>
					</template>
				</el-table-column>
			</el-table>
		</div> -->
		<h4  style="margin-top:30px">推荐客源</h4>
		<hr>
		<el-table :data="tableData">
			<el-table-column prop="customersId" label="编号"> </el-table-column>
			<el-table-column prop="customersName" label="经纪人">
			</el-table-column>
			<el-table-column prop="customersPhone" label="经纪人电话">
			</el-table-column>
			<el-table-column prop="customersDate" label="推荐时间">
			</el-table-column>
			<el-table-column prop="customersState" label="跟进状态">
				<template v-slot:default="v">
					{{v.row.customersState == 0 ?"未跟进":v.row.customersState == 1 ? "有效":"无效"}}
				</template>
			</el-table-column>
			<el-table-column prop="" label="操作">
				<template v-slot:default="v">
					<div class="dianji" v-if="v.row.customersState == 0">
						<span @click="wancheng(v.row)" style="margin-right:6px">完成跟进</span>
						<span @click="wuxiao(v.row)">无效</span>
					</div>
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
					console.log(this.tableData[0])
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
