<template>
	<div>
		<!-- 筛选开始   -->
		<el-row style="margin-left:30px;margin-top:20px;">
			<el-col :span="6">
				<div class="grid-content bg-purple">
					<label>意向区域</label>
					<el-input v-model="s" placeholder="例如: 北京" clearable style="width:220px;margin-left: 10px;" />
				</div>
			</el-col>
			<el-col :span="6">
				<div class="grid-content bg-purple-light">
					<label>小区名称</label>
					<el-input v-model="s" clearable style="width:220px;margin-left: 10px;" />
				</div>
			</el-col>
			<el-col :span="6">
				<div class="grid-content bg-purple">
					<label>客源状态</label>
					<el-select placeholder="请选择状态" v-model="s" value-key="" style="margin-left: 10px;">
						<!-- <el-option v-for="item in titles" :key="item.titId" :label="item.titName" :value="item">
    </el-option> -->
					</el-select>
				</div>
			</el-col>
			<el-col :span="6">
				<div class="grid-content bg-purple-light">
					<el-button type="primary">搜索</el-button>
				</div>
			</el-col>
		</el-row>
		<div style="margin-top: 20px;box-shadow:grey 10px 10px 30px 5px;border-radius:5px;padding: 20px;">
			<el-row>
				<h4>求购类型</h4>
				<el-checkbox-group v-model="p" style="margin-left: 40px;">
					<el-checkbox label="Option A" />
					<el-checkbox label="Option B" />
					<el-checkbox label="Option C" />
					<el-checkbox label="disabled" />
					<el-checkbox label="selected and disabled" />
				</el-checkbox-group>
			</el-row>
			<el-row style="margin-top: 20px;">
				<h4>户型</h4>
				<el-checkbox-group v-model="p" style="margin-left: 40px;">
					<el-checkbox label="Option A" />
					<el-checkbox label="Option B" />
					<el-checkbox label="Option C" />
					<el-checkbox label="disabled" />
					<el-checkbox label="selected and disabled" />
				</el-checkbox-group>
			</el-row>
			<el-row style="margin-top: 20px;">
				<h4>房屋用途</h4>
				<el-checkbox-group v-model="p" style="margin-left: 40px;">
					<el-checkbox label="Option A" />
					<el-checkbox label="Option B" />
					<el-checkbox label="Option C" />
					<el-checkbox label="disabled" />
					<el-checkbox label="selected and disabled" />
				</el-checkbox-group>
			</el-row>
			<el-row style="margin-top: 20px;">
				<h4>装修</h4>
				<el-checkbox-group v-model="p" style="margin-left: 40px;">
					<el-checkbox label="Option A" />
					<el-checkbox label="Option B" />
					<el-checkbox label="Option C" />
					<el-checkbox label="disabled" />
					<el-checkbox label="selected and disabled" />
				</el-checkbox-group>
			</el-row>
			<el-row style="margin-top: 20px;">
				<el-col :span="2">
					<div class="grid-content bg-purple">
						<h4 style="margin-top: 6px;">价格区间</h4>
					</div>
				</el-col>
				<el-col :span="8">
					<div class="grid-content bg-purple-light">
						<el-input v-model="s" placeholder="最低售价" clearable style="width:120px;" />
						-
						<el-input v-model="s" placeholder="最高售价" clearable style="width:120px;" />
						万
						<el-button type="primary">确定</el-button>
					</div>
				</el-col>
				<el-col :span="2">
					<div class="grid-content bg-purple">
						<h4 style="margin-top: 6px;">面积区间</h4>
					</div>
				</el-col>
				<el-col :span="8">
					<div class="grid-content bg-purple-light">
						<el-input v-model="s" placeholder="最小面积" clearable style="width:120px;" />
						-
						<el-input v-model="s" placeholder="最大面积" clearable style="width:120px;" />
						m²
						<el-button type="primary">确定</el-button>
					</div>
				</el-col>
			</el-row>
		</div>
		<!-- 筛选结束   -->

		<!--  表格开始    -->
		<el-table :data="demandForm.slice((pageNo-1)*size,pageNo*size)" border style="width: 100%;margin-top: 30px;">
			<el-table-column prop="demandIntention.demandArea" label="意向区域" min-width="100">
			</el-table-column>
			<el-table-column prop="demandIntention.villageName" label="意向小区" min-width="100">
			</el-table-column>
			<el-table-column prop="level.levelName" label="客户等级" min-width="100">
			</el-table-column>
			<el-table-column prop="rentalIntention.rentalName" label="客户需求" min-width="120">
			</el-table-column>
			<el-table-column prop="demandIntention.minPrice" label="最低价格" min-width="160">
			</el-table-column>
			<el-table-column prop="demandIntention.maxPrice" label="最高价格" min-width="160">
			</el-table-column>
			<el-table-column prop="demandIntention.minArea" label="最低面积" min-width="160">
			</el-table-column>
			<el-table-column prop="demandIntention.maxArea" label="最大面积" min-width="160">
			</el-table-column>
			<el-table-column label="操作" fixed="right" width="300">
				<template v-slot:default="r">
					<el-button @click="fangDialog = true,po(r.row)">提供二手房房源</el-button>
					<el-button @click="xinDog=true,po(r.row)">提供新房房源</el-button>
					<el-button @click="all(r.row)">查看详情</el-button>
				</template>
			</el-table-column>
		</el-table>
		<!--  表格结束  -->

		<!-- 分页开始   -->
		<div style="text-align: center;margin-top: 10px;">
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageNo"
				:page-sizes="[5, 10, 15, 20]" :page-size="size" layout="total, sizes, prev, pager, next, jumper"
				:total="demandForm.length">
			</el-pagination>
		</div>
		<!--  分页结束  -->


		<el-dialog v-model="fangDialog" title="选择房源">
			<el-table :data="ershoufan.slice((pageNo2-1)*size2,pageNo2*size2)" border @selection-change="xuan"
				style="width: 100%">
				<el-table-column fixed="left" type="selection" width="55">
				</el-table-column>
				<el-table-column prop="secondaryId" label="序号"> </el-table-column>
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
								<span style="font-size:25px; color: #59ff00;">{{r.row.secondaryPrice}}万</span>
							</el-col>
						</el-row>
					</template>
				</el-table-column>
			</el-table>
			<!-- 分页开始   -->
			<div style="text-align: center;margin-top: 10px;">
				<el-pagination @size-change="handleSizeChange2" @current-change="handleCurrentChange2"
					:current-page="pageNo2" :page-sizes="[5, 10, 15, 20]" :page-size="size2"
					layout="total, sizes, prev, pager, next, jumper" :total="ershoufan.length">
				</el-pagination>
			</div>
			<el-button @click="addhou()">保存</el-button>
		</el-dialog>

		<el-dialog v-model="selectIs" title="查看详情" width="700px">
			<label>查看详情</label>
			<hr />
			公客池需求
			<p>求购意向:{{customers.rentalIntention.rentalName}},意向区域:{{customers.demandIntention.demandArea}},户型:<template
					v-for="item in customers.demandIntention.demandModelKeys"
					:key="item.modelId"><label>{{item.modelName}}</label></template></p>
			<p>价格区间:{{customers.demandIntention.minPrice}}--{{customers.demandIntention.maxPrice}}万,面积区间{{customers.demandIntention.minArea}}--{{customers.demandIntention.maxArea}}m²
			</p>
			<p>客户信息</p>
			<p>客户称呼:{{customers.cusName}},性别:{{customers.cusSex}},电话:{{customers.cusPhone}}</p>
			<label>推荐房源</label>
			<hr />
			<el-tabs v-model="activeName">
				<el-tab-pane label="新房" name="first" :key="'first'">
          <el-table :data="recommended.slice((pageNo3-1)*size3,pageNo3*size3)" border style="width: 100%">
            <el-table-column label="楼盘名称" width="450px">
              <template v-slot:default="r">
                <el-row>
                  <el-col :span="12">
                    <img :src="r.row.newHouse.houseImg" width="200" height="100" />
                  </el-col>
                  <el-col :span="10">
                    <span style="font-size: 25px;">{{r.row.newHouse.houseName}}</span>
                    <br />
                    <span>建面:{{r.row.newHouse.houseArea}}㎡</span>
                    <br />
                    <span>{{r.row.newHouse.houseCharacteristic}}</span>
                  </el-col>
                </el-row>
              </template>
            </el-table-column>
            <el-table-column prop="newHouse.houseProperty" label="物业类型"></el-table-column>
            <el-table-column prop="newHouse.houseIshide" label="前端是否显示"></el-table-column>
            <el-table-column prop="newHouse.houseState" label="销售状态"></el-table-column>
            <el-table-column prop="newHouse.houseAddress" label="楼盘地址"></el-table-column>
            <el-table-column prop="newHouse.houseDeveloper" label="开发商名称"></el-table-column>
            <el-table-column prop="newHouse.houseNumber" label="楼盘编号"></el-table-column>
          </el-table>
          <!-- 分页开始   -->
          <div style="text-align: center;margin-top: 10px;">
            <el-pagination @size-change="handleSizeChange3" @current-change="handleCurrentChange3"
                           :current-page="pageNo3" :page-sizes="[5, 10, 15, 20]" :page-size="size3"
                           layout="total, sizes, prev, pager, next, jumper" :total="recommended.length">
            </el-pagination>
          </div>
				</el-tab-pane>

				<el-tab-pane label="二手房" name="second" :key="'second'">
          <el-table :data="recommendeder.slice((pageNo5-1)*size5,pageNo5*size5)" border style="width: 100%">
            <el-table-column prop="secondary.secondaryId" label="序号"> </el-table-column>
            <el-table-column prop="secondary.secondaryTitle" label="出售标题" width="120"> </el-table-column>
            <el-table-column label="房源信息" width="450">
              <template v-slot:default="r">
                <el-row>
                  <el-col :span="12">
                    <img :src="r.row.secondary.secondaryPicture" width="200" height="100" />
                  </el-col>
                  <el-col :span="10">
								<span
                    style="font-size:18px; font-weight: bold;">{{r.row.secondary.secondaryVillage+r.row.secondary.secondaryBuilding+r.row.secondaryUnit}}</span>
                    <br />
                    <span>{{r.row.secondary.secondaryModel+' '+r.row.secondary.secondaryToward+' '+r.row.secondary.secondaryType}}</span>
                    <br />
                    <span style="font-size:25px; color: #59ff00;">{{r.row.secondary.secondaryPrice}}万</span>
                  </el-col>
                </el-row>
              </template>
            </el-table-column>
          </el-table>
          <!-- 分页开始   -->
          <div style="text-align: center;margin-top: 10px;">
            <el-pagination @size-change="handleSizeChange5" @current-change="handleCurrentChange5"
                           :current-page="pageNo5" :page-sizes="[5, 10, 15, 20]" :page-size="size5"
                           layout="total, sizes, prev, pager, next, jumper" :total="recommendeder.length">
            </el-pagination>
          </div>
				</el-tab-pane>
			</el-tabs>

		</el-dialog>

		<el-dialog v-model="xinDog" title="选择房源">
			<el-table :data="chamber.slice((pageNo4-1)*size4,pageNo4*size4)" border @selection-change="xuan2"
				style="width: 100%">
				<el-table-column fixed="left" type="selection" width="55">
				</el-table-column>
				<el-table-column label="楼盘名称" width="450px">
					<template v-slot:default="r">
						<el-row>
							<el-col :span="12">
								<img :src="r.row.houseImg" width="200" height="100" />
							</el-col>
							<el-col :span="10">
								<span style="font-size: 25px;">{{r.row.houseName}}</span>
								<br />
								<span>建面:{{r.row.houseArea}}㎡</span>
								<br />
								<span>{{r.row.houseCharacteristic}}</span>
							</el-col>
						</el-row>
					</template>
				</el-table-column>
				<el-table-column prop="houseProperty" label="物业类型"></el-table-column>
				<el-table-column prop="houseIshide" label="前端是否显示"></el-table-column>
				<el-table-column prop="houseState" label="销售状态"></el-table-column>
				<el-table-column prop="houseAddress" label="楼盘地址"></el-table-column>
				<el-table-column prop="houseDeveloper" label="开发商名称"></el-table-column>
				<el-table-column prop="houseNumber" label="楼盘编号"></el-table-column>
			</el-table>
			<!-- 分页开始   -->
			<div style="text-align: center;margin-top: 10px;">
				<el-pagination @size-change="handleSizeChange4" @current-change="handleCurrentChange4"
					:current-page="pageNo4" :page-sizes="[5, 10, 15, 20]" :page-size="size4"
					layout="total, sizes, prev, pager, next, jumper" :total="chamber.length">
				</el-pagination>
			</div>
			<el-button @click="addhou2()">保存</el-button>
		</el-dialog>

	</div>
</template>

<script>
	import qs from 'qs'
	import {
		ElMessage
	} from 'element-plus'
	export default {
		data() {
			return {
				//筛选
				s: '', //意向区域
				p: [], //求购类型
				demandForm: [], //需求表格
				//分页
				pageNo: 1, //当前页数
				size: 5, //当前页显示的条数
				total: 0, //总记录数
				fangDialog: false,
				xinfan: [], //新房
				ershoufan: [], //二手房
				chamber: [], //新房
				pageNo2: 1, //当前页数
				size2: 5, //当前页显示的条数
				total2: 0, //总记录数
				choose: [],
				housingRecommended: {
					recId: '',
					recCus: '',
					recHou: '',
					recSec: '',
				},
				cusId: '',
				selectIs: false,
				customers: {},
				recommended: [],//推荐新房
        recommendeder:[],//推荐二手房
				pageNo3: 1, //当前页数
				size3: 5, //当前页显示的条数
				total3: 0, //总记录数
				pageNo4: 1, //当前页数
				size4: 5, //当前页显示的条数
				total4: 0, //总记录数
        pageNo5: 1, //当前页数
        size5: 5, //当前页显示的条数
        total5: 0, //总记录数
				xinDog: false,
			}
		},
		methods: {
			/*分页*/
			handleSizeChange(val) {
				console.log(`每页 ${val} 条`);
				this.pageNo = 1;
				this.size = val;
			},
			handleCurrentChange(val) {
				console.log(`当前页: ${val}`);
				this.pageNo = val;
			},
			/*分页*/
			handleSizeChange2(val) {
				console.log(`每页 ${val} 条`);
				this.pageNo2 = 1;
				this.size2 = val;
			},
			handleCurrentChange2(val) {
				console.log(`当前页: ${val}`);
				this.pageNo2 = val;
			},
			/*分页*/
			handleSizeChange3(val) {
				console.log(`每页 ${val} 条`);
				this.pageNo3 = 1;
				this.size3 = val;
			},
			handleCurrentChange3(val) {
				console.log(`当前页: ${val}`);
				this.pageNo3 = val;
			},
			/*分页*/
			handleSizeChange4(val) {
				console.log(`每页 ${val} 条`);
				this.pageNo4 = 1;
				this.size4 = val;
			},
			handleCurrentChange4(val) {
				console.log(`当前页: ${val}`);
				this.pageNo4 = val;
			},
      /*分页*/
      handleSizeChange5(val) {
        console.log(`每页 ${val} 条`);
        this.pageNo5 = 1;
        this.size5 = val;
      },
      handleCurrentChange5(val) {
        console.log(`当前页: ${val}`);
        this.pageNo5 = val;
      },
			allCustomersBymaleState() {
				this.axios.get("Customerss/AllCustomersBymaleState").then((v) => {
					this.demandForm = v.data;
				});
			},
			/*HousSelectAll() {
				this.axios.get("Hous/selectAll").then((v) => {
					this.xinfan = v.data;
				});
			},*/
			SeconSelectAll() {
				var userId = this.$store.state.token.userID;
				this.axios.get("Secondary/selectAll", {
					params: {
						userId: userId
					}
				}).then((v) => {
					this.ershoufan = v.data;
				});
			},
			HouSelectAll() {
				var userId = this.$store.state.token.userID;
				this.axios.get("house/selectAll", {
					params: {
						userId: userId
					}
				}).then((v) => {
					this.chamber = v.data;
				});
			},
			xuan(row) {
				this.choose = [];
				row.forEach(r => {
					this.choose.push(r.secondaryId);
				})
			},
			xuan2(row) {
				this.choose = [];
				row.forEach(r => {
					this.choose.push(r.houseId);
				})
			},
			addhou() {
				var hou = JSON.stringify({
					cusId: this.cusId,
					choose: this.choose
				})
				this.axios.post("sing/batchAdd", qs.stringify({
					hou: hou
				})).then((v) => {
					ElMessage(v.data);
					this.fangDialog = false;
				});
			},
			addhou2() {
				var hou = JSON.stringify({
					cusId: this.cusId,
					choose: this.choose
				})
				this.axios.post("sing/batchAdd2", qs.stringify({
					hou: hou
				})).then((v) => {
					ElMessage(v.data);
					this.xinDog = false;
				});
			},
			po(row) {
				this.cusId = row.cusId;
			},
			all(row) {
				this.selectIs = true;
				this.customers = row;
				this.axios.get("sing/selectBycusId", {
					params: {
						cusId: row.cusId
					}
				}).then((v) => {
					this.recommended = v.data.hou;
					this.recommendeder=v.data.sec;
				});
			}
		},
		created() {
			this.allCustomersBymaleState();
			this.SeconSelectAll();
			this.HouSelectAll();
		}
	}
</script>

<style scoped>
	h4 {
		width: 70px;
	}
</style>
