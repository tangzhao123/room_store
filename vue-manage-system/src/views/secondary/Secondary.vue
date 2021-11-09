<template>
	<div>
		<el-row>
			<el-form label-width="80px">
				<el-form-item label="房源名称">
					<el-input placeholder="请输入房源名称" clearable v-model="secondary.secondaryVillage"></el-input>
				</el-form-item>
			</el-form>
			<el-col :span="2" :push="2">
				<el-button type="primary" size="medium" @click="findByUser()">查询</el-button>
			</el-col>
		</el-row>
		<el-row style="margin: 10px;">
			<el-button type="primary" size="medium" @click="intoHousing">录入房源</el-button>
		</el-row>
		<div style="height: 300px; width: 98%; border: 1px solid #D9D9D9; margin-left: 5px; margin: 10px;">
			<el-row>
				<el-form label-width="80px">
					<el-form-item label="位置">
						<el-radio label="1" v-model="value">长沙市</el-radio>
					</el-form-item>
				</el-form>
			</el-row>
			<el-row>
				<el-form label-width="80px">
					<el-form-item label="区域">
						<el-checkbox-group v-model="checkList" @change="changeCheckbox">
							<el-checkbox label="雨花区"></el-checkbox>
							<el-checkbox label="岳麓区"></el-checkbox>
							<el-checkbox label="开福区"></el-checkbox>
							<el-checkbox label="长沙县"></el-checkbox>
							<el-checkbox label="天心区"></el-checkbox>
							<el-checkbox label="荷塘区"></el-checkbox>
							<el-checkbox label="天元区"></el-checkbox>
						</el-checkbox-group>
					</el-form-item>
				</el-form>
			</el-row>
			<el-row>
				<el-form label-width="80px">
					<el-form-item label="房屋用途">
						<el-checkbox-group v-model="roomList" @change="changeRoomCheckbox">
							<el-checkbox label="办公"></el-checkbox>
							<el-checkbox label="土地"></el-checkbox>
							<el-checkbox label="住宅"></el-checkbox>
							<el-checkbox label="商业"></el-checkbox>
							<el-checkbox label="工业"></el-checkbox>
						</el-checkbox-group>
					</el-form-item>
				</el-form>
			</el-row>
			<el-row>
				<el-form label-width="80px">
					<el-form-item label="房型">
						<el-checkbox-group v-model="modelList" @change="changeModelCheckbox">
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
						<el-checkbox-group v-model="towardList" @change="changeTowardCheckbox">
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
		</div>
		<div style="width: 100%; margin-left: 5px;">
			<el-row style="margin: 10px;">
				<el-table :data="secondaryData" style="width: 100%">
					<el-table-column type="selection"></el-table-column>
					<el-table-column prop="secondaryId" label="序号"> </el-table-column>
					<el-table-column prop="secondaryNumber" label="房源编号" width="140"> </el-table-column>
					<el-table-column prop="secondaryTitle" label="出售标题" width="120"> </el-table-column>
					<el-table-column label="房源信息" width="450">
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
					<el-table-column prop="secondaryState" label="房源状态">
						<template v-slot:default="r">
							<el-tag type="success" v-if="r.row.secondaryState==0">上架</el-tag>
							<el-tag type="danger" v-if="r.row.secondaryState==1">下架</el-tag>
						</template>
					</el-table-column>
					<el-table-column prop="secondaryPoolsAccess" label="公房池状态" width="140">
						<template v-slot:default="r">
							<el-tag type="success" v-if="r.row.secondaryPoolsAccess==0">不在公房池</el-tag>
							<el-tag type="danger" v-if="r.row.secondaryPoolsAccess==1">在公房池</el-tag>
						</template>
					</el-table-column>
					<el-table-column prop="secondaryUse" label="房屋用途"> </el-table-column>
					<el-table-column prop="secondaryAvailability" label="发布时间" width="150"> </el-table-column>
					<el-table-column label="操作" fixed="right" width="220">
						<template v-slot:default="r">
							<el-button type="text" size="medium" @click="details(r.row)">查看详情</el-button>
							<el-button type="text" size="medium" @click="shelves(r.row)"
								v-if="r.row.secondaryState == 0">下架</el-button>
							<el-button type="text" size="medium" @click="theShelves(r.row)"
								v-if="r.row.secondaryState == 1">上架</el-button>

							<el-button type="text" size="medium" v-if="r.row.secondaryPoolsAccess==0"
								@click='dialogFormVisible= true,showHouse(r.row)'>移入公房池
							</el-button>
							<el-button type="text" size="medium" v-if="r.row.secondaryPoolsAccess==1"
								@click="removeHandHouse(r.row)">移出公房池
							</el-button>

						</template>
					</el-table-column>
				</el-table>
				<el-pagination :current-page="pageNo" @current-change="findByUser" background
					layout="total,prev, pager, next,jumper" :page-size="size" :total="total">>
				</el-pagination>
			</el-row>
		</div>
		<el-dialog title="移入公房池设置" v-model="dialogFormVisible">
			<el-form>
				<el-form-item label="房源编号">
					{{handHouse.secondaryNumber}}
				</el-form-item>
				<el-form-item label="房源标题">
					{{name}}
				</el-form-item>
				<el-form-item label="客源提供方奖励:">
					<el-input placeholder="请输入奖励金额" style="width: 200px;" v-model="handHouse.housePrice"></el-input>
				</el-form-item>
			</el-form>
			<template #footer>
				<span class="dialog-footer">
					<el-button @click="dialogFormVisible = false">取 消</el-button>
					<el-button type="primary" @click="dialogFormVisible = false,addHandHouse()">确 定</el-button>
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
				secondaryData: [], //二手房源表格
				secondary: { //二手房对象
					secondaryId: '', //序号
					secondaryNumber: '', //房源编号
					secondaryCity: '', //城市/区域
					secondaryVillage: '', //小区名称
					secondaryFloor: '', //总楼层
					secondaryLayer: '', //所在层
					secondaryUnit: '', //单元
					secondaryBuilding: '', //楼栋
					secondaryRoom: '', //房号
					secondaryArea: '', //建筑面积
					secondaryWithin: '', //套内面积
					secondaryModel: '', //户型
					secondaryToward: '', //朝向
					secondaryYear: '', //建筑年代
					secondaryUse: '', //房屋用途
					secondaryLadder: '', //梯户比例
					secondaryElevator: '', //有无电梯
					secondaryCover: '', //封面照片
					secondaryBack: '', //封底照片
					secondaryPage: '', //权属页照片
					secondaryFamily: '', //户型页照片
					secondaryTitle: '', //出售标题
					secondaryPrice: '', //价格
					secondaryType: '', //装修类型
					secondaryAccess: '', //房源获取渠道
					secondaryLable: '', //房屋标签
					secondaryPower: '', //权力性质
					secondaryRights: '', //产权年限
					secondaryBuy: '', //购买年限
					secondaryOnly: '', //是否唯一
					secondaryHousing: '', //房屋介绍
					secondaryCommunity: '', //小区介绍
					secondarySchool: '', //附近学校
					secondaryAdvantage: '', //房源优势
					secondaryOwner: '', //业主心态
					secondaryState: '', //上下架状态
					secondaryPoolsAccess: '', //公房池状态
					secondaryAvailability: '', //房源发布时间
					goodRoom: '', //好房外键
					userId: '', //用户外键
					pageNo: 0,
					size: 0,
				},
				value: '1',
				checkList: [], //区域
				roomList: [], //房屋用途
				modelList: [], //户型
				towardList: [], //朝向
				dialogVisible: false, //详情的弹框
				dialogFormVisible: false, //移入公房池弹框
				name: '', //房源标题
				handHouse: {
					secondaryNumber: '', //房源编号
					housePrice: '' //客源奖励
				}
			}
		},
		methods: {
			//获取区域标签
			changeCheckbox(val) {
				var str = "";
				for (var i = 0; i < val.length; i++) {
					str += val[i] + ",";
				}
				//去掉最后一个逗号(如果不需要去掉，就不用写)
				if (str.length > 0) {
					str = str.substr(0, str.length - 1);
				}
				this.secondary.secondaryCity = str;
				this.findByUser();
				console.log(this.secondary.secondaryCity)
			},
			//获取房屋用途
			changeRoomCheckbox(val) {
				var str = "";
				for (var i = 0; i < val.length; i++) {
					str += val[i] + ",";
				}
				//去掉最后一个逗号(如果不需要去掉，就不用写)
				if (str.length > 0) {
					str = str.substr(0, str.length - 1);
				}
				this.secondary.secondaryUse = str;
				this.findByUser();
				console.log(this.secondary.secondaryUse)
			},
			//获取房型
			changeModelCheckbox(val) {
				var str = "";
				for (var i = 0; i < val.length; i++) {
					str += val[i] + ",";
				}
				//去掉最后一个逗号(如果不需要去掉，就不用写)
				if (str.length > 0) {
					str = str.substr(0, str.length - 1);
				}
				this.secondary.secondaryModel = str;
				this.findByUser();
				console.log(this.secondary.secondaryModel)
			},
			//获取朝向
			changeTowardCheckbox(val) {
				var str = "";
				for (var i = 0; i < val.length; i++) {
					str += val[i] + ",";
				}
				//去掉最后一个逗号(如果不需要去掉，就不用写)
				if (str.length > 0) {
					str = str.substr(0, str.length - 1);
				}
				this.secondary.secondaryToward = str;
				this.findByUser();
				console.log(this.secondary.secondaryToward)
			},
			//跳转到新增房源的界面
			intoHousing() {
				this.$router.push("/into_housing");
			},
			//跳转到房源详情的界面
			details(row) {
				this.$router.push({
					path: '/details',
					name: 'details',
					params: {
						id: row.secondaryNumber
					}
				});
			},
			//根据用户查询房源
			findByUser(no) {
				this.secondary.userId = this.$store.state.token.userID;
				console.log(this.$store.state.token.userID)
				if (no == undefined) {
					no = this.pageNo
				}
				this.secondary.pageNo = no;
				this.secondary.size = this.size;
				console.log(this.secondary);
				this.axios.post('/Secondary/secondary-list', this.secondary).then((v) => {
					console.log(v.data.list)
					this.secondaryData = v.data.list;
					this.total = v.data.total;
				}).catch(function() {

				});
			},
			//下架
			shelves(row) {
				this.axios({
					url: 'Secondary/shelves',
					params: {
						secondaryNumber: row.secondaryNumber
					}
				}).then((v) => {
					if (v.data == 'ok') {
						this.$message.success("下架成功！");
						this.findByUser();
					} else {
						this.$message.error("下架失败！")
					}
				}).catch(function() {

				})
			},
			//下架
			theShelves(row) {
				this.axios({
					url: 'Secondary/the-shelves',
					params: {
						secondaryNumber: row.secondaryNumber
					}
				}).then((v) => {
					if (v.data == 'ok') {
						this.$message.success("上架成功！");
						this.findByUser();
					} else {
						this.$message.error("上架失败！")
					}
				}).catch(function() {

				})
			},
			//移入公房池弹框显示信息
			showHouse(row) {
				this.handHouse.secondaryNumber = row.secondaryNumber;
				this.name = row.secondaryTitle;
			},
			//移入公房池
			addHandHouse() {
				//执行新增
				this.axios.post("Secondary/add-handHouse", this.handHouse).then((res) => {
					if (res.data == 'ok') {
						this.$message.success("移入成功！");
						this.findByUser();
					} else {
						this.$message.error("移入失败！")
					}
				}).catch(() => {
					this.$message.error("移入失败！")
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
								this.findByUser();
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
			this.findByUser(this.pageNo);
		}
	}
</script>

<style>
</style>
