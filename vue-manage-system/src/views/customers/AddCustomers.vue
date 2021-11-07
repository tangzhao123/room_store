<template>
	<div style="margin-top: 10px;margin-left: 20px;">
		<el-form :model="customers">
			客户录入
			<hr />
			<div style="margin-left: 30px;margin-top: 20px">
				<input type="hidden" v-model="customers.cusId" />
				<el-form-item label="客户等级" :label-width="formLabelWidth">
					<el-select placeholder="客户等级" v-model="customers.levelId">
						<el-option v-for="item in LevelList" :key="item.levelId" :label="item.levelName"
							:value="item.levelId">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="租售意向" :label-width="formLabelWidth">
					<el-select placeholder="客户意向" v-model="customers.rentalId">
						<el-option v-for="item in RentalIntentionList" :key="item.rentalId" :label="item.rentalName"
							:value="item.rentalId">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="客户来源" :label-width="formLabelWidth">
					<el-select placeholder="客户来源" v-model="customers.souId">
						<el-option v-for="item in SourceList" :key="item.souId" :label="item.souName"
							:value="item.souId">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="客户状态" :label-width="formLabelWidth">
					<el-select placeholder="客户状态" v-model="customers.stateId">
						<el-option v-for="item in StateList" :key="item.stateId" :label="item.stateName"
							:value="item.stateId">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="客户称呼" :label-width="formLabelWidth">
					<el-input v-model="customers.cusName" placeholder="请输入客户称呼" clearable style="width:220px;" />
				</el-form-item>
				<el-form-item label="性别" :label-width="formLabelWidth">
					<el-radio-group v-model="customers.cusSex">
						<el-radio label="男">男</el-radio>
						<el-radio label="女">女</el-radio>
						<el-radio label="未知">未知</el-radio>
					</el-radio-group>
				</el-form-item>
				<el-form-item label="联系电话" :label-width="formLabelWidth">
					<el-input v-model="customers.cusPhone" placeholder="请输入联系电话" clearable style="width:220px;" />
				</el-form-item>
				<el-form-item label="备用电话" :label-width="formLabelWidth">
					<el-input v-model="customers.cusStandby" placeholder="请输入备用电话" clearable style="width:220px;" />
				</el-form-item>
				<el-form-item label="备注" :label-width="formLabelWidth">
					<el-input v-model="customers.cusNote" placeholder="请输入备注" :rows="3" type="textarea" clearable
						style="width:520px;" />
				</el-form-item>
			</div>
			需求意向
			<hr />
			<div style="margin-left: 30px;margin-top: 20px">
				<input type="hidden" v-model="demand.demandId" />
				<el-form-item label="意向区域" :label-width="formLabelWidth">
					<el-input v-model="demand.demandArea" placeholder="请输入意向区域" clearable style="width:220px;" />
				</el-form-item>
				<el-form-item label="小区名称" :label-width="formLabelWidth">
					<el-input v-model="demand.villageName" placeholder="请输入小区名称" clearable style="width:220px;" />
				</el-form-item>
				<el-form-item label="户型" :label-width="formLabelWidth">
					<el-checkbox-group v-model="SelectedModelIntentionList" style="margin-left: 40px;">
						<el-checkbox v-for="item in ModelIntentionList" :label="item.modelId" :key="item.modelId">
							{{item.modelName}}
						</el-checkbox>
					</el-checkbox-group>
				</el-form-item>
				<el-form-item label="价格" :label-width="formLabelWidth">
					<el-input v-model="demand.minPrice" placeholder="请输入金额" clearable style="width:220px;" />
					-
					<el-input v-model="demand.maxPrice" placeholder="请输入金额" clearable style="width:220px;" />
					万
				</el-form-item>
				<el-form-item label="面积" :label-width="formLabelWidth">
					<el-input v-model="demand.minArea" placeholder="请输入面积" clearable style="width:220px;" />
					-
					<el-input v-model="demand.maxArea" placeholder="请输入面积" clearable style="width:220px;" />
					m²
				</el-form-item>
				<el-form-item label="房屋用途" :label-width="formLabelWidth">
					<el-checkbox-group v-model="SelectedUseIntentionList" style="margin-left: 40px;">
						<el-checkbox v-for="item in UseIntentionList" :label="item.useId" :key="item.useId">
							{{item.useName}}
						</el-checkbox>
					</el-checkbox-group>
				</el-form-item>
				<el-form-item label="装修类型" :label-width="formLabelWidth">
					<el-checkbox-group v-model="SelectedDecorateIntentionList" style="margin-left: 40px;">
						<el-checkbox v-for="item in DecorateIntentionList" :label="item.decorId" :key="item.decorId">
							{{item.decorName}}
						</el-checkbox>
					</el-checkbox-group>
				</el-form-item>
				<el-form-item label="楼层" :label-width="formLabelWidth">
					<el-checkbox-group v-model="SelectedFloorIntentionList" style="margin-left: 40px;">
						<el-checkbox v-for="item in FloorIntentionList" :label="item.floorId" :key="item.floorId">
							{{item.floorName}}
						</el-checkbox>
					</el-checkbox-group>
				</el-form-item>
				<el-form-item>
					<el-button type="primary" @click="AddCustomers()">确定</el-button>
					<el-button>取消</el-button>
				</el-form-item>
			</div>
		</el-form>
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
				formLabelWidth: '75px', //label宽度
				LevelList: [], //所有客户等级
				RentalIntentionList: [], //所有客户意向
				SourceList: [], //所有客户来源
				StateList: [], //所有客户状态
				customers: {
					cusId: '', //编号
					levelId: '', //客户等级
					rentalId: '', //客户意向
					souId: '', //客户来源
					stateId: '', //客户状态
					cusName: '', //客户名称
					cusSex: '', //客户性别
					cusPhone: '', //联系电话
					cusStandby: '', //备用电话
					cusNote: '', //备注
					maleState: '', //公客池状态
					cusEntry: '', //录入日期
					userId: '', //用户
					demanId: '', //需求意向
				},
				ModelIntentionList: [], //所有户型意向
				UseIntentionList: [], //所有用途意向
				DecorateIntentionList: [], //所有装修类型意向
				FloorIntentionList: [], //所有楼层意向
				//需求录入
				demand: {
					demandId: '', //编号
					demandArea: '', //意向区域
					villageName: '', //小区名称
					minPrice: '', //最低价格
					maxPrice: '', //最高价格
					minArea: '', //最小面积
					maxArea: '', //最大面积
				},
				SelectedModelIntentionList: [], //选中的户型意向
				SelectedUseIntentionList: [], //选中的用途意向
				SelectedDecorateIntentionList: [], //选中的装修类型意向
				SelectedFloorIntentionList: [], //选中楼层意向
			}
		},
		methods: {
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
			/**
			 * 查询所有户型意向
			 */
			ModelIntentionSelectAll() {
				this.axios.get("ModelIntention/selectAll").then((v) => {
					this.ModelIntentionList = v.data;
				});
			},
			/**
			 * 查询所有用途意向
			 */
			UseIntentionSelectAll() {
				this.axios.get("UseIntention/selectAll").then((v) => {
					this.UseIntentionList = v.data;
				});
			},
			/**
			 * 查询所有装修类型意向
			 */
			DecorateIntentionSelectAll() {
				this.axios.get("DecorateIntention/selectAll").then((v) => {
					this.DecorateIntentionList = v.data;
				});
			},
			/**
			 * 查询所有楼层意向
			 */
			FloorIntentionSelectAll() {
				this.axios.get("FloorIntention/selectAll").then((v) => {
					this.FloorIntentionList = v.data;
				});
			},
			AddCustomers() {
				this.customers.userId = 1;
				var customer = JSON.stringify({
					customers: this.customers,
					demand: this.demand,
					SelectedModelIntentionList: this.SelectedModelIntentionList,
					SelectedUseIntentionList: this.SelectedUseIntentionList,
					SelectedDecorateIntentionList: this.SelectedDecorateIntentionList,
					SelectedFloorIntentionList: this.SelectedFloorIntentionList
				})
				this.axios.post("Customerss/addCustomerss", qs.stringify({
					customer: customer
				})).then((v) => {
					ElMessage(v.data);
					this.resetForm();
					this.$router.push('/mycustomers')
				});
			},
			/**
			 * 清除表单数据
			 */
			resetForm() {
				this.customers = {
					cusId: '', //编号
					levelId: '', //客户等级
					rentalId: '', //客户意向
					souId: '', //客户来源
					stateId: '', //客户状态
					cusName: '', //客户名称
					cusSex: '', //客户性别
					cusPhone: '', //联系电话
					cusStandby: '', //备用电话
					cusNote: '', //备注
					maleState: '', //公客池状态
					cusEntry: '', //录入日期
					userId: '', //用户
					demanId: '', //需求意向
				}
				//需求录入
				this.demand = {
					demandId: '', //编号
					demandArea: '', //意向区域
					villageName: '', //小区名称
					minPrice: '', //最低价格
					maxPrice: '', //最高价格
					minArea: '', //最小面积
					maxArea: '', //最大面积
				}
				this.SelectedModelIntentionList = [] //选中的户型意向
				this.SelectedUseIntentionList = [] //选中的用途意向
				this.SelectedDecorateIntentionList = [] //选中的装修类型意向
          this.SelectedFloorIntentionList = [] //选中楼层意向
			},
			chuan(cusId) {
        this.axios.get('Customerss/getallCustomers',{params: {cusId: cusId}}).then((v)=>{
          this.customers=v.data.customers;
          this.demand=v.data.demand;
          this.SelectedModelIntentionList=v.data.SelectedModelIntentionList;
          this.SelectedUseIntentionList=v.data.SelectedUseIntentionList;
          this.SelectedDecorateIntentionList=v.data.SelectedDecorateIntentionList;
          this.SelectedFloorIntentionList=v.data.SelectedFloorIntentionList;
        });
        this.axios.get().then();
			},
		},
		created() {
			var cusId = this.$route.query.cusId;
			if (cusId != undefined) {
				this.chuan(cusId);
			}
			this.LevelSelectAll();
			this.RentalIntentionSelectAll();
			this.SourceSelectAll();
			this.StateSelectAll();
			this.ModelIntentionSelectAll();
			this.UseIntentionSelectAll();
			this.DecorateIntentionSelectAll();
			this.FloorIntentionSelectAll();
		}
	}
</script>

<style scoped>
</style>
