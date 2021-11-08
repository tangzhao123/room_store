<template>
	<div>
		<el-row>
			<el-col :span="8">
				<el-form label-width="80px">
					<el-form-item label="城市名称">
						<el-input placeholder="请输入城市名称" clearable></el-input>
					</el-form-item>
				</el-form>
			</el-col>
			<el-col :span="8">
				<el-form label-width="80px">
					<el-form-item label="小区名称">
						<el-input placeholder="请输入小区名称" clearable></el-input>
					</el-form-item>
				</el-form>
			</el-col>
			<el-col :span="2" :push="1">
				<el-button type="primary" size="medium" @click="getData()">查询</el-button>
			</el-col>
		</el-row>
		<div style="height: 180px; width: 1250px; border: 1px solid #D9D9D9; margin-left: 5px; margin: 10px;">
			<el-row>
				<el-form label-width="80px">
					<el-form-item label="装修">
						<el-col span="2">
							<el-checkbox v-model="value" label="毛坯房"></el-checkbox>
							<el-checkbox v-model="value" label="普通装修"></el-checkbox>
							<el-checkbox v-model="value" label="精装修"></el-checkbox>
						</el-col>
					</el-form-item>
				</el-form>
			</el-row>
			<el-row>
				<el-col :span="4">
					<el-form label-width="80px">
						<el-form-item label="租金">
							<el-input v-model="input" placeholder="最低资金" />
						</el-form-item>
					</el-form>
				</el-col>
				<el-col :span="3">
					<el-form label-width="30px">
						<el-form-item label="-">
							<el-input v-model="input" placeholder="最高资金" />
						</el-form-item>
					</el-form>
				</el-col>
				<el-col :span="3">
					<el-form label-width="50px">
						<el-form-item label="元/月">
							<el-button type="primary" size="medium" >确定</el-button>
						</el-form-item>
					</el-form>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="4">
					<el-form label-width="80px">
						<el-form-item label="建筑面积">
							<el-input v-model="input" placeholder="最小面积" />
						</el-form-item>
					</el-form>
				</el-col>
				<el-col :span="3">
					<el-form label-width="30px">
						<el-form-item label="-">
							<el-input v-model="input" placeholder="最大面积" />
						</el-form-item>
					</el-form>
				</el-col>
				<el-col :span="3">
					<el-form label-width="50px">
						<el-form-item label="m²">
							<el-button type="primary" size="medium" >确定</el-button>
						</el-form-item>
					</el-form>
				</el-col>
			</el-row>
		</div>

		<div style="width: 1250px; margin-left: 5px;">
			<el-row style="margin: 10px;">
				<el-table :data="tableData1.slice((queryParams.pageNum-1)*queryParams.pageSize,queryParams.pageNum*queryParams.pageSize)" :cell-style="{'text-align':'center'}" :header-cell-style="{'text-align':'center'}">
					<el-table-column prop="rentalhousing.rehoNumber" label="房源编号"> </el-table-column>
					<el-table-column prop="rehoCommunity" label="房源信息" width="480px">
						<template v-slot:default="v">
							<div>
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
							</div>
						</template>
					</el-table-column>
					<el-table-column prop="reppMoney" label="成交奖励">
						
					</el-table-column>
					<el-table-column prop="reppDate" label="进入公房池时间"> </el-table-column>
					<el-table-column prop="" label="操作" fixed="right" width="220px">
						<template v-slot:default="v">
							<div v-if="v.row.rentalhousing.rehoUsersNo == this.$store.state.token.userID" class="dianji" style="margin-bottom:8px">
								<span style="margin-left:10px;margin-right:28px" @click="chakanxiangqing(v.row)">查看详情</span>
								<span @click="chugongfangchi(v.row)">移出公房池</span>
							</div>
							<div v-if="v.row.rentalhousing.rehoUsersNo != this.$store.state.token.userID" class="dianji" style="margin-bottom:8px">
								<span style="margin-right:15px;" @click="addkeyuan(v.row)">提供意向客源</span>
								<span @click="chakantuijian(v.row)">查看推荐</span>
							</div>
						</template>
					</el-table-column>
				</el-table>
				<!-- 分页组件开始 -->
				<div class="block" align="center">
				<el-pagination
					@size-change="handleSizeChange"
					@current-change="handleCurrentChange"
					:page-sizes="[3,6,12,20]"
					:current-page="queryParams.pageNum"
					:page-size="queryParams.pageSize"
					layout="total,sizes, prev, pager, next, jumper"
					:total="tableData1.length">
				</el-pagination>
				</div>
			</el-row>
		</div>

		<el-dialog
			v-model="dialogVisible1"
			title="提示"
			width="30%"
			:before-close="handleClose">
			<span>确定要移出公房池吗？</span>
			<template #footer>
			<span class="dialog-footer">
				<el-button @click="dialogVisible1 = false">取消</el-button>
				<el-button type="primary" @click="qdyichu()">确定</el-button>
			</span>
			</template>
		</el-dialog>
	</div>
</template>

<script>
import { ElMessage } from 'element-plus'
import { ElMessageBox } from 'element-plus'
export default {
		data() {
			return {
				// 分页参数
				queryParams: {
					//初始页
					pageNum: 1,
					//每页数据
					pageSize: 3
				},
				dialogVisible1:false,
				// 分页数据总条数
				total: 0,
				tableData1:[],
			}
		},
		methods: {
			// 初始页currentPage、初始每页数据数pagesize和数据data
			handleSizeChange(size) {
			this.queryParams.pageSize = size;
			// console.log(this.pagesize) //每页下拉显示数据
			},
			handleCurrentChange(currentPage) {
			this.queryParams.pageNum = currentPage;
			// console.log(this.currentPage) //点击第几页
			},
			chugongfangchi(row){
				this.xjrehoNumber = row.rentalhousing.rehoNumber;
				this.dialogVisible1 = true;
			},
			chakanxiangqing(row){
				console.log(row)
				this.$router.push({
					path:"/chakanxiangqing",
					query: {
						params: JSON.stringify({no:row.rentalhousing.rehoNumber}) 
					}
				});
			},
			chakantuijian(row){
				console.log(row);
				this.$router.push({
					path:"/chakantuijian",
					query: {
						params: JSON.stringify({no:row.rentalhousing.rehoNumber}) 
					}
				});
			},
			addkeyuan(row){
				console.log(row);
				ElMessageBox.confirm('您确定提供客源么?')
				.then(() => {
					var customers = {
						secondaryNumber:row.rentalhousing.rehoNumber,
						customersName:this.$store.state.token.userName,
						customersPhone:this.$store.state.token.userPhone
					}
					this.axios.post("Renthouse/insertRentalpublicpoolsKy",customers).then((res) => {
						console.log(res)
						ElMessage({
							message: '操作成功！',
							type: 'success',
						})
					}).catch(() => {
					})
				})
				.catch(() => {
				})
			},
			qdyichu(){
				this.axios({
					url: 'Renthouse/deleteRentalpublicpoolsByReppRehoNo',
					params:{	
						reppRehoNo:this.xjrehoNumber
					}
				}).then((v) => {
					this.getData1();
					this.$message.success("移出成功！");
					this.dialogVisible1 = false;
					console.log(v)
				}).catch()
			},
			getData1(){
				this.axios.post("Renthouse/findAllRentalpublicpools").then((res) => {
					this.tableData1 = res.data;
					console.log(this.tableData1);
				}).catch(() => {
				});
			}
		},
		created() {
			this.getData1();
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
