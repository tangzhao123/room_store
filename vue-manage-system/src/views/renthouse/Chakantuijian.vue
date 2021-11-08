<template>
	<div>
		<el-button type="primary" @click="addgenjin()">新增跟进</el-button>
		<el-table :data="tableData" style="margin-top:30px">
			<el-table-column prop="refoNo" label="编号"> </el-table-column>
			<el-table-column prop="refoName" label="跟进人姓名">
			</el-table-column>
			<el-table-column prop="refoPhone" label="跟进人电话">
			</el-table-column>
			<el-table-column prop="refoWay" label="跟进方式">
			</el-table-column>
			<el-table-column prop="refoType" label="跟进分类">
			</el-table-column>
			<el-table-column prop="refoDate" label="跟进时间">
			</el-table-column>
			<el-table-column prop="" label="操作">
				<template v-slot:default="v">
					<div class="dianji">
						<span @click="chakan(v.row)">查看跟进记录</span>
					</div>
				</template>
			</el-table-column>
		</el-table>
	</div>
</template>

<script>
export default {
		data() {
			return {
				tableData:[],
				no:"",
			}
		},
		methods: {
			addgenjin(){
				this.$router.push({
					path:"/add-rentalfollowup",
					query: {
						params: JSON.stringify({no:this.no}) 
					}
				});
			},
			getDate(){
				let params = JSON.parse( this.$route.query.params);
				this.no = params.no;

				this.axios({
					url: 'Renthouse/findAllRentalfollowup',
					params:{
						param:this.no
					}
				}).then((v) => {
					this.tableData = v.data
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
