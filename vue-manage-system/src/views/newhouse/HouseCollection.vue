<template>
	<div style="padding: 10px;">
		<div>
			<el-form :inline="true" v-model="selectParams">
				<el-form-item label="小区名称">
					<el-input v-model="selectParams.sourceName" placeholder="请输入小区名称" style="width: 170px;" clearable></el-input>
				</el-form-item>
				<el-form-item>
					<el-button type="primary" @click="onsumbit()" icon="el-icon-search" style="margin-left: 20px;">查询</el-button>
				</el-form-item>
			</el-form>
		</div>
		<div>
			<el-button @click="add()">新增采集</el-button>
		</div>
		<el-table :data="tableData" style="width: 100%">
			<el-table-column prop="sourceName" label="小区名称"></el-table-column>
			<el-table-column prop="sourcePosition" label="小区位置"></el-table-column>
			<el-table-column prop="sourceAddress" label="小区地址"></el-table-column>
			<el-table-column prop="sourceProperty" label="物业类型"></el-table-column>
			<el-table-column prop="sourcePrice" label="单价(元/平方米)"></el-table-column>
			<el-table-column prop="sourceTotalPrice" label="总价(万元)"></el-table-column>
			<el-table-column prop="sourceDeveloper" label="开发商名称"></el-table-column>
			<el-table-column prop="sourceTime" label="采集时间"></el-table-column>
			<el-table-column label="操作">
				<template #default="scope">
					<el-row :gutter="20">
						<el-col :span="12" :offset="0">
							<el-button size="mini" @click="handleEdit(scope.row)">编辑</el-button>
						</el-col>
					</el-row>
				</template>
			</el-table-column>
		</el-table>
		<div style="margin: 10px 0;">
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :page-sizes="[5, 10, 20]"
			layout="total, sizes, prev, pager, next, jumper" :total="total">
			</el-pagination>
		</div>
		<el-dialog title="提示" v-model="dialogVisible" width="1200px" :before-close="handleClose">
			<el-form :model="form" label-width="100px" :rules="rules" ref="form">
				<el-form-item label="小区名称" prop="sourceName">
					<el-input v-model="form.sourceName" placeholder="小区名称" style="width: 240px;"></el-input>
				</el-form-item>
						<el-form-item label="小区位置">
							<el-col style="padding-left: 5px;">
								<el-select v-model="form.sourcePosition" placeholder="请选择区">
									<el-option v-for="item in qu" :key="item.countyId" :label="item.countyName"
										:value="item.countyName">
									</el-option>
								</el-select>
							</el-col>
						</el-form-item>
				<el-form-item label="小区地址" prop="sourceAddress">
					<el-input v-model="form.sourceAddress" placeholder="小区地址" style="width: 240px;"></el-input>
				</el-form-item>
				<el-form-item label="物业类型" prop="sourceProperty">
					<el-radio v-model="form.sourceProperty" label="住宅">住宅</el-radio>
					<el-radio v-model="form.sourceProperty" label="别墅">别墅</el-radio>
					<el-radio v-model="form.sourceProperty" label="写字楼">写字楼</el-radio>
					<el-radio v-model="form.sourceProperty" label="商业">商业</el-radio>
					<el-radio v-model="form.sourceProperty" label="公寓">公寓</el-radio>
					<el-radio v-model="form.sourceProperty" label="loft">loft</el-radio>
					<el-radio v-model="form.sourceProperty" label="商铺">商铺</el-radio>
					<el-radio v-model="form.sourceProperty" label="其他">其他</el-radio>
				</el-form-item>
				<el-form-item label="建筑面积" prop="sourceArea">
					<el-input v-model="form.sourceArea" placeholder="建筑面积" style="width: 240px;"></el-input>
				</el-form-item>
				<el-form-item label="小区特色" prop="sourceCharacteristic">
					<el-select v-model="form.sourceCharacteristic">
						<el-option v-for="item in lists" :key="item.charaId" :label="item.charaName" :value="item.charaName"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="参考单价" prop="sourcePrice">
					<el-input v-model="form.sourcePrice" placeholder="参考单价" style="width: 240px;"></el-input>
				</el-form-item>
				<el-form-item label="参考总价" prop="sourceTotalPrice">
					<el-input v-model="form.sourceTotalPrice" placeholder="参考总价" style="width: 240px;"></el-input>
				</el-form-item>
				<el-form-item label="所属开发商" prop="sourceDeveloper">
					<el-input v-model="form.sourceDeveloper" placeholder="所属开发商" style="width: 240px;"></el-input>
				</el-form-item>
				<el-form-item label="创建时间" prop="sourceTime">
					<el-date-picker v-model="form.sourceTime" value-format="yyyy-MM-dd" type="date" placeholder="选择日期" disabled style="width:30%"
					clearable></el-date-picker>
				</el-form-item>
			</el-form>
			<span class="dialog-footer">
				<el-button @click="dialogVisible = false">取 消</el-button>
				<el-button type="primary" @click="save()">确 定</el-button>
			</span>
		</el-dialog>
	</div>
</template>

<script>
	import {
		getList,
		enit,
		addall,
		selectList
	} from '../../api/housecollection.js'
	export default {
		data() {
			return {
				selectParams: {},
				tableData: [],
				form:{},
				values:'1',
				quid:"",//区
				quname:"",
				qu:[],
				lists:[],
				xqu:[],//xiao区数据
				xquid:"",//区
				dialogVisible:false,
				total: 0,
			}
		},
		methods: {
			getCounty(){
				this.axios({
					url: 'Renthouse/findAllCountyByCountyBelong',
					params:{
						countyBelong:2
					}
				}).then((v) => {
					this.qu = v.data
					console.log(this.qu);
				}).catch()
			},
			handleEdit(row) {
				this.form = JSON.parse(JSON.stringify(row))
				this.dialogVisible = true
			},
			add() {
				this.dialogVisible = true;
				this.form = {}
			},
			save() {
				if (this.form.sourceId) {
					enit(this.form).then(res => {
						if (res.code == 0) {
							this.$message({
								message: '修改成功',
								type: 'success'
							})
						} else {
							this.$message({
								message: res.message,
								type: 'error'
							})
						}
						this.dialogVisible = false
						this.load()
					})
				} else {
					this.$refs['form'].validate((valid) => {
						if (valid) {
							addall(this.form).then(res => {
								if (res.code == 0) {
									this.$message({
										message: '新增成功',
										type: 'success'
									})
								} else {
									this.$message({
										message: res.message,
										type: 'error'
									})
								}
								this.dialogVisible = false
								this.load()
							})
						}
					})

				}

			},
			async load() {
				let {
					pageNum,
					pageSize,
					keyword,
					sourceName,
				} = this.selectParams;
				const {
					data: Listres
				} = await getList({
					pageNum: pageNum,
					pageSize: pageSize,
					keyword: keyword,
					sourceName: sourceName,
				});
				this.tableData = Listres.list
				this.total = Listres.total
			},
			onsumbit() {
				this.load()
			},
			handleSizeChange(pageSize) {
				this.selectParams.pageSize = pageSize;
				this.load();
			},
			handleCurrentChange(pageNum) {
				this.selectParams.pageNum = pageNum;
				this.load();
			},
			find(){
				selectList().then(res=>{
					this.lists=res.data
					console.log(this.lists)
					console.log(res.data)
				})
			},
		},
		created() {
			this.selectParams.pageNum = 1;
			this.selectParams.pageSize = 10;
			this.load()
			this.getCounty();
			this.find();
		}
	}
</script>

<style>
</style>
