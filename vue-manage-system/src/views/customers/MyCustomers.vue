<template>
	<div>
		<!-- 筛选开始 -->
		<el-form :model="screening" status-icon>
			<el-row style="margin-left:30px;margin-top:20px;">
				<el-col :span="6">
					<div class="grid-content bg-purple">
						<el-form-item label="客户电话" :label-width="formLabelWidth">
							<el-input v-model="screening.cusPhone" placeholder="客户电话" clearable style="width:220px;">
							</el-input>
						</el-form-item>
					</div>
				</el-col>
				<el-col :span="9">
					<div class="grid-content bg-purple-light">
						<el-form-item label="录入时间" :label-width="formLabelWidth">
							<el-date-picker v-model="riqi" type="daterange" align="right" unlink-panels
								range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期"
								:shortcuts="shortcuts">
							</el-date-picker>
						</el-form-item>
					</div>
				</el-col>
				<el-col :span="8">
					<div class="grid-content bg-purple">
						<el-form-item label="客户意向" :label-width="formLabelWidth">
							<el-select placeholder="客户意向" v-model="screening.rentalId">
                <el-option v-for="item in RentalIntentionList" :key="item.rentalId" :label="item.rentalName"
                           :value="item.rentalId">
                </el-option>
							</el-select>
						</el-form-item>
					</div>
				</el-col>
			</el-row>

			<el-row style="margin-left:30px;">
				<el-col :span="6">
					<div class="grid-content bg-purple">
						<el-form-item label="客户来源" :label-width="formLabelWidth">
							<el-select placeholder="客户来源" v-model="screening.souId">
                <el-option v-for="item in SourceList" :key="item.souId" :label="item.souName"
                           :value="item.souId">
                </el-option>
							</el-select>
						</el-form-item>
					</div>
				</el-col>
				<el-col :span="9">
					<div class="grid-content bg-purple-light">
						<el-form-item label="客户状态" :label-width="formLabelWidth">
							<el-select placeholder="客户状态" v-model="screening.stateId">
                <el-option v-for="item in StateList" :key="item.stateId" :label="item.stateName"
                           :value="item.stateId">
                </el-option>
							</el-select>
						</el-form-item>
					</div>
				</el-col>
			</el-row>

			<el-row style="margin-left:30px;">
				<el-col :span="6">
					<div class="grid-content bg-purple">
						<el-form-item label="客户等级" :label-width="formLabelWidth">
							<el-select placeholder="客户等级" v-model="screening.levelId">
                <el-option v-for="item in LevelList" :key="item.levelId" :label="item.levelName"
                           :value="item.levelId">
                </el-option>
							</el-select>
						</el-form-item>
					</div>
				</el-col>
				<el-col :span="6">
					<div class="grid-content bg-purple-light">
						<el-form-item>
							<el-button type="primary" @click="allCustomers()">搜索</el-button>
						</el-form-item>
					</div>
				</el-col>
			</el-row>
		</el-form>
		<router-link :to="{path:'/addcustomers'}">
			<el-button type="primary"> 客源录入</el-button>
		</router-link>
		<!--   筛选结束   -->

		<!--  表格开始    -->
		<el-table :data="customersForm.slice((pageNo-1)*size,pageNo*size)" border style="width: 100%">
			<el-table-column prop="cusId" label="客户编号" min-width="100">
			</el-table-column>
			<el-table-column prop="cusName" label="客户称呼" min-width="100">
			</el-table-column>
			<el-table-column prop="cusSex" label="性别" min-width="100">
			</el-table-column>
			<el-table-column prop="cusPhone" label="手机号" min-width="120">
			</el-table-column>
			<el-table-column prop="level.levelName" label="等级" min-width="170">
			</el-table-column>
			<el-table-column prop="rentalIntention.rentalName" label="意向" min-width="160">
			</el-table-column>
			<el-table-column prop="source.souName" label="来源" min-width="160">
			</el-table-column>
			<el-table-column prop="state.stateName" label="用户状态" min-width="120">
			</el-table-column>
			<el-table-column prop="cusEntry" label="录入日期" min-width="120">
			</el-table-column>
			<el-table-column prop="maleState" label="公客池状态" min-width="120">
			</el-table-column>
			<el-table-column label="操作" fixed="right" width="120">
				<template v-slot:default="r">
					<router-link :to="{path: '/addcustomers',query:{cusId:r.row.cusId}}">
						<el-link type="primary">编辑</el-link>
					</router-link>
					<template v-if="r.row.maleState=='不在公客池'">
						<el-link type="primary" @click="update(r.row)">移入公客池</el-link>
					</template>
					<template v-else>
						<el-link type="primary" @click="update(r.row)">移出公客池</el-link>
					</template>
				</template>
			</el-table-column>
		</el-table>
		<!--  表格结束  -->

		<!-- 分页开始   -->
		<div style="text-align: center;margin-top: 10px;">
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageNo"
				:page-sizes="[5, 10, 15, 20]" :page-size="size" layout="total, sizes, prev, pager, next, jumper"
				:total="customersForm.length">
			</el-pagination>
		</div>
		<!--  分页结束  -->
	</div>
</template>

<script>
	import {
		ElMessage
	} from 'element-plus'
	export default {
		data() {
			return {
				formLabelWidth: '75px', //label宽度
				shortcuts: [{
					text: '最近一周',
					value: (() => {
						const end = new Date()
						const start = new Date()
						start.setTime(start.getTime() - 3600 * 1000 * 24 * 7)
						return [start, end]
					})(),
				}, {
					text: '最近一个月',
					value: (() => {
						const end = new Date()
						const start = new Date()
						start.setTime(start.getTime() - 3600 * 1000 * 24 * 30)
						return [start, end]
					})(),
				}, {
					text: '最近三个月',
					value: (() => {
						const end = new Date()
						const start = new Date()
						start.setTime(start.getTime() - 3600 * 1000 * 24 * 90)
						return [start, end]
					})(),
				}], //日期选择器格式
				screening: {
					levelId: '', //客户等级
					rentalId: '', //客户意向
					souId: '', //客户来源
					stateId: '', //客户状态
					cusPhone: '', //联系电话
				}, //筛选信息
				riqi: [], //录入时间筛选
				customersForm: [], //客源表格显示
				//分页
				pageNo: 1, //当前页数
				size: 5, //当前页显示的条数
				total: 0, //总记录数
        LevelList: [], //所有客户等级
        RentalIntentionList: [], //所有客户意向
        SourceList: [], //所有客户来源
        StateList: [], //所有客户状态
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
			allCustomers() {
				var userId = this.$store.state.token.userID;
				this.axios.get("Customerss/allCustomers", {
					params: {
						userId: userId,
						cusPhone: this.screening.cusPhone,
						rentalId: this.screening.rentalId,
            souId:this.screening.souId,
            stateId:this.screening.stateId,
            levelId:this.screening.levelId
					}
				}).then((v) => {
					this.customersForm = v.data;
				});
			},
			update(row) {
				if (row.maleState == "已在公客池") {
					row.maleState = "不在公客池"
				} else {
					row.maleState = "已在公客池"
				}
				this.axios.post("Customerss/update", row).then((v) => {
					this.allCustomers();
					ElMessage(v.data);
				});
			},
      /**
       * 查询所有客户等级
       */
      LevelSelectAll() {
        this.axios.get("Level/selectAll").then((v) => {
          this.LevelList = v.data;
        });
      },
      /**
       * 查询所有客户意向
       */
      RentalIntentionSelectAll() {
        this.axios.get("RentalIntention/selectAll").then((v) => {
          this.RentalIntentionList = v.data;
        });
      },
      /**
       * 查询所有客户来源
       */
      SourceSelectAll() {
        this.axios.get("Source/selectAll").then((v) => {
          this.SourceList = v.data;
        });
      },
      /**
       * 查询所有客户状态
       */
      StateSelectAll() {
        this.axios.get("State/selectAll").then((v) => {
          this.StateList = v.data;
        });
      },
		},
		created() {
			this.allCustomers();
      this.LevelSelectAll();
      this.RentalIntentionSelectAll();
      this.SourceSelectAll();
      this.StateSelectAll();
		}
	}
</script>

<style scoped>
</style>
