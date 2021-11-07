<template>
	<div>
		<el-row>
			<el-form label-width="80px">
				<el-form-item label="房源名称">
					<el-input placeholder="请输入房源名称" clearable></el-input>
				</el-form-item>
			</el-form>
			<el-col :span="6">
				<el-form label-width="80px">
					<el-form-item label="业主">
						<el-input placeholder="姓名或电话" clearable></el-input>
					</el-form-item>
				</el-form>
			</el-col>
			<el-col :span="4" :push="1">
				<el-form label-width="80px">
					<el-form-item label="房源状态">
						<el-select v-model="value" placeholder="房源状态">
							<el-option v-for="item in options" :key="item.value" :label="item.label"
								:value="item.value">
							</el-option>
						</el-select>
					</el-form-item>
				</el-form>
			</el-col>
			<el-col :span="2" :push="2">
				<el-button type="primary" size="medium" @click="getData()">查询</el-button>
			</el-col>
		</el-row>
		<el-row style="margin: 10px;">
			<el-button type="primary" size="medium" @click="intoHousing">录入房源</el-button>
		</el-row>
		<div style="height: 430px; width: 1250px; border: 1px solid #D9D9D9; margin-left: 5px; margin: 10px;">
			<el-row>
				<el-form label-width="80px">
					<el-form-item label="位置">
						<el-radio label="1">株洲市</el-radio>
					</el-form-item>
				</el-form>
			</el-row>
			<el-row>
				<el-form label-width="80px">
					<el-form-item label="区域">
						<el-col span="2">
							<el-checkbox v-model="value" label="天元区"></el-checkbox>
							<el-checkbox v-model="value" label="荷塘区"></el-checkbox>
							<el-checkbox v-model="value" label="株洲县"></el-checkbox>
						</el-col>
					</el-form-item>
				</el-form>
			</el-row>
			<el-row>
				<el-form label-width="80px">
					<el-form-item label="租金">
						<el-col span="2">
							<el-checkbox v-model="value" label="1500元以下"></el-checkbox>
							<el-checkbox v-model="value" label="1500-2000元"></el-checkbox>
							<el-checkbox v-model="value" label="2000-3000元"></el-checkbox>
							<el-checkbox v-model="value" label="3000-5000元"></el-checkbox>
							<el-checkbox v-model="value" label="5000-8000元"></el-checkbox>
							<el-checkbox v-model="value" label="8000元以上"></el-checkbox>
						</el-col>
					</el-form-item>
				</el-form>
			</el-row>
			<el-row>
				
				<el-col :span="4">
					<el-form label-width="80px">
						<el-form-item label="">
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
							<el-button>确定</el-button>
						</el-form-item>
					</el-form>
				</el-col>
			</el-row>
			<el-row>
				<el-form label-width="80px">
					<el-form-item label="房屋类型">
						<el-col span="2">
							<el-checkbox v-model="value" label="住宅"></el-checkbox>
							<el-checkbox v-model="value" label="复式"></el-checkbox>
							<el-checkbox v-model="value" label="公寓"></el-checkbox>
							<el-checkbox v-model="value" label="商铺"></el-checkbox>
						</el-col>
					</el-form-item>
				</el-form>
			</el-row>
			<el-row>
				<el-form label-width="80px">
					<el-form-item label="标签">
						<el-col span="2">
							<el-checkbox v-model="value" label="临近地铁"></el-checkbox>
							<el-checkbox v-model="value" label="停车场"></el-checkbox>
							<el-checkbox v-model="value" label="南北通透"></el-checkbox>
							<el-checkbox v-model="value" label="出行方便"></el-checkbox>
							<el-checkbox v-model="value" label="家电齐全"></el-checkbox>
							<el-checkbox v-model="value" label="拎包入住"></el-checkbox>
							<el-checkbox v-model="value" label="随时起租"></el-checkbox>
							<el-checkbox v-model="value" label="采光十足"></el-checkbox>
						</el-col>
					</el-form-item>
				</el-form>
			</el-row>
			<el-row>
				<el-form label-width="80px">
					<el-form-item label="支付方式">
						<el-col span="2">
							<el-checkbox v-model="value" label="押一付一"></el-checkbox>
							<el-checkbox v-model="value" label="押一付二"></el-checkbox>
							<el-checkbox v-model="value" label="押一付三"></el-checkbox>
							<el-checkbox v-model="value" label="押二付一"></el-checkbox>
							<el-checkbox v-model="value" label="半年付"></el-checkbox>
							<el-checkbox v-model="value" label="年付"></el-checkbox>
							<el-checkbox v-model="value" label="面谈"></el-checkbox>
						</el-col>
					</el-form-item>
				</el-form>
			</el-row>
		</div>
		<div style="width: 1250px; margin-left: 5px;">
			<el-row style="margin: 10px;">
				<el-table :data="tableData" style="width: 100%">
					<el-table-column prop="date" label="序号"> </el-table-column>
					<el-table-column prop="address" label="房源编号"> </el-table-column>
					<el-table-column prop="name" label="出售标题"> </el-table-column>
					<el-table-column prop="address" label="房源状态"> </el-table-column>
					<el-table-column prop="address" label="公房池状态"> </el-table-column>
					<el-table-column prop="address" label="房屋用途"> </el-table-column>
					<el-table-column prop="address" label="发布时间"> </el-table-column>
					<el-table-column prop="address" label="操作"> </el-table-column>
				</el-table>
				<el-pagination :current-page="pageNo" @current-change="getData" background
					layout="total,prev, pager, next,jumper" :page-size="size" :total="total">>
				</el-pagination>
			</el-row>
		</div>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				options: [{
						value: '选项1',
						label: '黄金糕',
					},
					{
						value: '选项2',
						label: '双皮奶',
					},
					{
						value: '选项3',
						label: '蚵仔煎',
					},
					{
						value: '选项4',
						label: '龙须面',
					},
					{
						value: '选项5',
						label: '北京烤鸭',
					},
				],
				value: '',
			}
		},
		methods: {
			//跳转到新增房源的界面
			intoHousing(){
				this.$router.push("/add-rentalhous");
			},
		},
		created() {

		}
	}
</script>

<style>
</style>
