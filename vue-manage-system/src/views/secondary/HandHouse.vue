<template>
	<div>
		<el-row>
			<el-form label-width="80px">
				<el-form-item label="小区名称">
					<el-input placeholder="请输入小区名称" clearable v-model="name"></el-input>
				</el-form-item>
			</el-form>
			<el-col :span="2" :push="2">
				<el-button type="primary" size="medium" @click="findByHandHouse()()">查询</el-button>
			</el-col>
		</el-row>
		<div style="height: 250px; width: 1400px; border: 1px solid #D9D9D9; margin-left: 5px; margin: 10px;">
			<el-row>
				<el-form label-width="80px">
					<el-form-item label="房型">
						<el-checkbox-group v-model="modelList">
							<el-checkbox label="一室"></el-checkbox>
							<el-checkbox label="二室"></el-checkbox>
							<el-checkbox label="三室"></el-checkbox>
							<el-checkbox label="四室"></el-checkbox>
							<el-checkbox label="五室及以上"></el-checkbox>
						</el-checkbox-group>
					</el-form-item>
				</el-form>
			</el-row>
			<el-row>
				<el-form label-width="80px">
					<el-form-item label="朝向">
						<el-checkbox-group v-model="towardList">
							<el-checkbox label="东"></el-checkbox>
							<el-checkbox label="南"></el-checkbox>
							<el-checkbox label="西"></el-checkbox>
							<el-checkbox label="北"></el-checkbox>
							<el-checkbox label="西南"></el-checkbox>
							<el-checkbox label="其他"></el-checkbox>
						</el-checkbox-group>
					</el-form-item>
				</el-form>
			</el-row>
			<el-row>
				<el-form label-width="80px">
					<el-form-item label="楼层">
						<el-checkbox-group v-model="floorList">
							<el-checkbox label="低层"></el-checkbox>
							<el-checkbox label="中层"></el-checkbox>
							<el-checkbox label="高层"></el-checkbox>
						</el-checkbox-group>
					</el-form-item>
				</el-form>
			</el-row>
			<el-row>
				<el-form label-width="80px">
					<el-form-item label="装修">
						<el-checkbox-group v-model="decorateList">
							<el-checkbox label="毛胚"></el-checkbox>
							<el-checkbox label="普通装修"></el-checkbox>
							<el-checkbox label="精装修"></el-checkbox>
						</el-checkbox-group>
					</el-form-item>
				</el-form>
			</el-row>
		</div>
		<el-row style="padding: 10px;">
			<el-table :data="handHouseData" style="width: 100%">
				<el-table-column type="selection"></el-table-column>
				<el-table-column prop="date" label="房源信息" width="450">
					<template v-slot:default="r">
						<el-row>
							<el-col :span="12">
								<img :src="r.row.secondaryPicture" width="200" height="100" />
							</el-col>
							<el-col :span="10">
								<span
									style="font-size:18px; font-weight: bold;">{{r.row.secondaryVillage+r.row.secondaryBuilding+r.row.secondaryUnit}}</span>
								<br />
								<span>{{r.row.secondaryModel+' '+r.row.secondaryToward+' '+r.row.secondaryType}}</span>
								<br />
								<span style="font-size:25px; color: red;">{{r.row.secondaryPrice}}万</span>
							</el-col>
						</el-row>
					</template>
				</el-table-column>
				<el-table-column prop="secondaryUse" label="房屋用途"> </el-table-column>
				<el-table-column label="成交奖励" width="200">
					<template v-slot:default="r">
						客源提供奖励：{{r.row.housePrice}}元
					</template>
				</el-table-column>
				<el-table-column prop="houseDate" label="进入公房池时间" width="200"> </el-table-column>
				<el-table-column prop="secondaryNumber" label="房源编号" width="200"> </el-table-column>
				<el-table-column label="操作" width="300">
					<template v-slot:default="r">
						<el-button type="primary" size="medium" @click="findDetails(r.row)"
							v-if=" r.row.userId==userId">
							查看详情</el-button>
						<el-button type="danger" size="medium" @click="removeHandHouse(r.row)" v-if="r.row.userId == userId">
							移出公房池</el-button>
						<el-button type="primary" size="medium" @click="addCustomers(r.row)"
							v-if="r.row.userId != userId">提供客源</el-button>

						<el-button type="primary" size="medium" v-if="r.row.userId != userId" @click="findAllCustomers(r.row)">查看推荐
						</el-button>
					</template>
				</el-table-column>
			</el-table>
			<el-pagination :current-page="pageNo" @current-change="findByHandHouse" background
				layout="total,prev, pager, next,jumper" :page-size="size" :total="total">>
			</el-pagination>
		</el-row>
		<el-dialog title="查看详情" v-model="dialogTableVisible1" width="80%">
			<div style="border-top: 2px solid #CCCCCC; width: 1100px; padding: 10px;">
				<el-row>
					<el-col :span="12">
						<img :src="handHouse.secondaryPicture" width="200" height="100" />
					</el-col>
					<el-col :span="10" :pull="6">
						<span
							style="font-size:18px; font-weight: bold;">{{handHouse.secondaryVillage+handHouse.secondaryBuilding+handHouse.secondaryUnit}}</span>
						<br />
						<span>{{handHouse.secondaryModel+' '+handHouse.secondaryToward+' '+handHouse.secondaryType}}</span>
						<br />
						<span style="font-size:25px; color: red;">{{handHouse.secondaryPrice}}万</span>
					</el-col>
				</el-row>
			</div>
			<div style="border-top: 2px solid #CCCCCC; width: 1100px; padding: 10px; margin: 10px; font-size: 20px;">
				推荐客源
			</div>
			<el-table :data="customersData" style="width: 100%">
				<el-table-column type="selection"></el-table-column>
				<el-table-column prop="customersName" label="经纪人姓名" width="180"> </el-table-column>
				<el-table-column prop="customersPhone" label="经纪人电话" width="180"> </el-table-column>
				<el-table-column prop="customersDate" label="推荐时间"> </el-table-column>
				<el-table-column prop="customersState" label="跟进状态" width="180">
					<template v-slot:default="r">
						{{r.row.customersState==0?'未跟进':r.row.customersState==1?'已跟进':'无效'}}
					</template>
				</el-table-column>
				<el-table-column prop="address" label="操作">
					<template v-slot:default="r">
						<span v-if="r.row.customersState==0">
							<el-button type="primary" size="medium" @click="follow(r.row)">
								跟进</el-button>
							<el-button type="danger" size="medium" @click="invalid(r.row)">
								无效</el-button>
						</span>
					</template>
				</el-table-column>
			</el-table>
			<el-pagination :current-page="pageNo1" @current-change="findDetails" background
				layout="total,prev, pager, next,jumper" :page-size="size1" :total="total1">>
			</el-pagination>
			<template #footer>
				<span class="dialog-footer">
					<el-button @click="dialogTableVisible1 = false">取 消</el-button>
				</span>
			</template>
		</el-dialog>
		
		<el-dialog title="查看详情" v-model="dialogTableVisible2" width="80%">
			<div style="border-top: 2px solid #CCCCCC; width: 1100px; padding: 10px;">
				<el-row>
					<el-col :span="12">
						<img :src="handHouse.secondaryPicture" width="200" height="100" />
					</el-col>
					<el-col :span="10" :pull="6">
						<span
							style="font-size:18px; font-weight: bold;">{{handHouse.secondaryVillage+handHouse.secondaryBuilding+handHouse.secondaryUnit}}</span>
						<br />
						<span>{{handHouse.secondaryModel+' '+handHouse.secondaryToward+' '+handHouse.secondaryType}}</span>
						<br />
						<span style="font-size:25px; color: red;">{{handHouse.secondaryPrice}}万</span>
					</el-col>
				</el-row>
			</div>
			<div style="border-top: 2px solid #CCCCCC; width: 1100px; padding: 10px; margin: 10px; font-size: 20px;">
				推荐客源
			</div>
			<el-table :data="customersData" style="width: 100%">
				<el-table-column type="selection"></el-table-column>
				<el-table-column prop="customersDate" label="推荐时间"> </el-table-column>
				<el-table-column prop="customersPhone" label="跟进状态" > </el-table-column>
			</el-table>
			<el-pagination :current-page="pageNo2" @current-change="findAllCustomers" background
				layout="total,prev, pager, next,jumper" :page-size="size2" :total="total2">>
			</el-pagination>
			<template #footer>
				<span class="dialog-footer">
					<el-button @click="dialogTableVisible1 = false">取 消</el-button>
				</span>
			</template>
		</el-dialog>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				pageNo: 1, //页码
				size: 5, //页大小
				total: 0, //总记录数
				pageNo1: 1, //页码
				size1: 5, //页大小
				total1: 0, //总记录数
				pageNo2: 1, //页码
				size2: 5, //页大小
				total2: 0, //总记录数
				modelList: [], //户型
				towardList: [], //朝向
				floorList: [], //楼层
				decorateList: [], //装修
				handHouseData: [], //公房池查询
				name: '', //小区名称
				userId: '', //当前登录的用户编号
				customers:{
					customersName:'',
					customersPhone:'',
					secondaryNumber:'',
				},
				dialogTableVisible1: false, //公房池详情
				dialogTableVisible2: false, //公房池详情
				handHouse: {}, //房源对象
				customersData:[],//推荐客源表格
			}
		},
		methods: {
			//公房池查询
			findByHandHouse(no) {
				this.userId = this.$store.state.token.userID;
				if (no == undefined) {
					no = this.pageNo
				}
				this.axios({
					url: '/Secondary/handHouse-list',
					params: {
						pageNo: no,
						size: this.size,
						name: this.name,
					},
				}).then((v) => {
					console.log(v.data)
					this.handHouseData = v.data.list;
					this.total = v.data.total;
				}).catch(function() {

				});
			},
			//查看详情
			findDetails(row,no) {
				this.dialogTableVisible1 = true;
				this.handHouse = row;
				if (no == undefined) {
					no = this.pageNo1
				}
				this.axios({
					url: '/Secondary/customers-list',
					params: {
						pageNo: no,
						size: this.size1,
						secondaryNumber: this.handHouse.secondaryNumber,
					},
				}).then((v) => {
					console.log(v.data)
					this.customersData = v.data.list;
					this.total1 = v.data.total;
				}).catch(function() {
				
				});
				console.log(row);
			},
			//新增客源推荐
			addCustomers(row){
				this.customers.customersName = this.$store.state.token.userName;
				this.customers.customersPhone = this.$store.state.token.userPhone;
				this.customers.secondaryNumber = row.secondaryNumber;
				console.log(this.customers);
				this.$confirm('您确定提供客源么?', '提示', {
						confirmButtonText: '确定',
						cancelButtonText: '取消',
						type: 'warning',
					})
					.then(() => {
						this.axios.post("Secondary/add-customers", this.customers).then((res) => {
							if (res.data == 'ok') {
								this.$message.success("推荐成功！");
								this.findByHandHouse();
							} else {
								this.$message.error("推荐失败！")
							}
						}).catch(() => {
							this.$message.error("推荐失败！")
						})
					})
					.catch(() => {
						this.$message.error("取消操作！")
					})
				
			},
			//查询客源推荐表格
			findAllCustomers(row,no){
				this.dialogTableVisible2 = true;
				this.handHouse = row;
				if (no == undefined) {
					no = this.pageNo2
				}
				this.axios({
					url: '/Secondary/customers-list',
					params: {
						pageNo: no,
						size: this.size2,
						secondaryNumber: this.handHouse.secondaryNumber,
					},
				}).then((v) => {
					console.log(v.data)
					this.customersData = v.data.list;
					this.total2 = v.data.total;
				}).catch(function() {
				
				});
			},
			//修改状态(无效)
			invalid(row){
				this.$confirm('您确定无效么?', '提示', {
						confirmButtonText: '确定',
						cancelButtonText: '取消',
						type: 'warning',
					})
					.then(() => {
						this.axios({url:"Secondary/invalid", params:{customersId:row.customersId}}).then((res) => {
							if (res.data == 'ok') {
								console.log(res.data);
								this.$message.success("无效成功！");
								this.dialogTableVisible1 = false;
							} else {
								this.$message.error("无效失败！")
							}
						}).catch(() => {
							this.$message.error("无效失败！")
						})
					})
					.catch(() => {
						this.$message.error("取消操作！")
					})
			},
			//修改状态(跟进)
			follow(row){
				console.log(row);
				this.$confirm('您确定完成跟进么?', '提示', {
						confirmButtonText: '确定',
						cancelButtonText: '取消',
						type: 'warning',
					})
					.then(() => {
						this.axios({url:"Secondary/follow", params:{customersId:row.customersId}}).then((res) => {
							if (res.data == 'ok') {
								console.log(res.data);
								this.$message.success("跟进成功！");
								this.dialogTableVisible1 = false;
							} else {
								this.$message.error("跟进失败！")
							}
						}).catch(() => {
							this.$message.error("跟进失败！")
						})
					})
					.catch(() => {
						this.$message.error("取消操作！")
					})
			},
			//移出公房池
			removeHandHouse(row) {
				this.$confirm('您确定移除公房池么?', '提示', {
						confirmButtonText: '确定',
						cancelButtonText: '取消',
						type: 'warning',
					})
					.then(() => {
						this.axios({
							url: 'Secondary/remove-handHouse',
							params: {
								secondaryNumber: row.secondaryNumber
							}
						}).then((v) => {
							if (v.data == 'ok') {
								this.$message.success("移出成功！");
								this.findByHandHouse();
							} else {
								this.$message.error("移出失败！")
							}
						}).catch(function() {
			
						})
					})
					.catch(() => {
						this.$message.error("取消操作！")
					})
			
			},
		},
		created() {
			this.findByHandHouse(this.pageNo);
		}
	}
</script>

<style>
</style>
