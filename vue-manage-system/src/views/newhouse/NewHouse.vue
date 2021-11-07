<template>
	<div style="padding: 10px;">
		<div>
			<el-form :inline="true" v-model="selectParams">
				<el-form-item label="楼盘名称">
					<el-input v-model="selectParams.houseName" placeholder="请输入楼盘名称" style="width: 170px;" clearable></el-input>
				</el-form-item>
				<el-form-item label="楼盘编号">
					<el-input v-model="selectParams.houseNumber" placeholder="请输入楼盘编号" style="width: 170px;" clearable></el-input>
				</el-form-item>
				<el-form-item label="楼盘状态">
					<el-select v-model="value">
						<el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item>
					<el-button type="primary" @click="onsumbit()" icon="el-icon-search" style="margin-left: 20px;">查询</el-button>
				</el-form-item>
			</el-form>
		</div>
		<div>
			<el-button @click="add">新增房源</el-button>
		</div>
		<el-table :data="tableData" style="width: 100%">
			<el-table-column prop="houseName" label="楼盘名称"></el-table-column>
			<el-table-column prop="houseProperty" label="物业类型"></el-table-column>
			<el-table-column prop="" label="户型数"></el-table-column>
			<el-table-column prop="houseIshide" label="前端是否显示"></el-table-column>
			<el-table-column prop="houseState" label="销售状态"></el-table-column>
			<el-table-column prop="houseAddress" label="楼盘地址"></el-table-column>
			<el-table-column prop="houseDeveloper" label="开发商名称"></el-table-column>
			<el-table-column prop="houseNumber" label="楼盘编号"></el-table-column>
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
				<el-form-item label="小区名称" prop="houseName">
					<el-input v-model="form.houseName" placeholder="小区名称" style="width: 240px;"></el-input>
				</el-form-item>
				<el-form-item label="小区位置" prop="housePosition">
					<el-input v-model="form.housePosition" placeholder="小区位置" style="width: 240px;"></el-input>
				</el-form-item>
				<el-form-item label="小区地址" prop="houseAddress">
					<el-input v-model="form.houseAddress" placeholder="小区地址" style="width: 240px;"></el-input>
				</el-form-item>
				<el-form-item label="物业类型" prop="houseProperty">
					<el-radio v-model="form.houseProperty" label="住宅">住宅</el-radio>
					<el-radio v-model="form.houseProperty" label="别墅">别墅</el-radio>
					<el-radio v-model="form.houseProperty" label="写字楼">写字楼</el-radio>
					<el-radio v-model="form.houseProperty" label="商业">商业</el-radio>
					<el-radio v-model="form.houseProperty" label="公寓">公寓</el-radio>
					<el-radio v-model="form.houseProperty" label="loft">loft</el-radio>
					<el-radio v-model="form.houseProperty" label="商铺">商铺</el-radio>
					<el-radio v-model="form.houseProperty" label="其他">其他</el-radio>
				</el-form-item>
				<el-form-item label="建筑面积" prop="houseArea">
					<el-input v-model="form.houseArea" placeholder="建筑面积" style="width: 240px;"></el-input>
				</el-form-item>
				<el-form-item label="小区特色" prop="houseCharacteristic">
					<el-input v-model="form.houseCharacteristic" placeholder="小区特色" style="width: 240px;"></el-input>
				</el-form-item>
				<el-form-item label="参考单价" prop="housePrice">
					<el-input v-model="form.housePrice" placeholder="参考单价" style="width: 240px;"></el-input>
				</el-form-item>
				<el-form-item label="参考总价" prop="houseTotalPrice">
					<el-input v-model="form.houseTotalPrice" placeholder="参考总价" style="width: 240px;"></el-input>
				</el-form-item>
				<el-form-item label="所属开发商" prop="houseDeveloper">
					<el-input v-model="form.houseDeveloper" placeholder="所属开发商" style="width: 240px;"></el-input>
				</el-form-item>
				<el-form-item label="销售证号" prop="houseCertificate">
					<el-input v-model="form.houseCertificate" placeholder="销售证号" style="width: 240px;"></el-input>
				</el-form-item>
				<el-form-item label="发证时间" prop="houseCertificateTime">
					<el-date-picker v-model="form.houseCertificateTime" value-format="yyyy-MM-dd" type="date" placeholder="选择日期" style="width:30%"
					clearable></el-date-picker>
				</el-form-item>
				<el-form-item label="销售状态" prop="houseState">
					<el-radio v-model="form.houseState" label="0">待收</el-radio>
					<el-radio v-model="form.houseState" label="1">在售</el-radio>
					<el-radio v-model="form.houseState" label="2">售罄</el-radio>
				</el-form-item>
				<el-form-item label="楼盘编号" prop="houseNumber">
					<el-input v-model="form.houseNumber" placeholder="楼盘编号" style="width: 240px;"></el-input>
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
		addall,
		enit
	} from '../../api/newhouse.js'
	export default {
		data() {
			return {
				selectParams: {},
				total: 0,
				form: {},
				dialogVisible: false,
				tableData: [],
				options: [{
						value: '全部',
						label: '全部',
					},
					{
						value: '0',
						label: '待收',
					},
					{
						value: '1',
						label: '在售',
					},
					{
						value: '2',
						label: '售罄',
					},
				],
				value: '全部',
			}
		},
		methods: {
			handleEdit(row) {
				this.form = JSON.parse(JSON.stringify(row))
				this.dialogVisible = true
			},
			add() {
				this.dialogVisible = true;
				this.form = {}
			},
			save() {
				if (this.form.houseId) {
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
					houseName,
					houseNumber,
					houseState
				} = this.selectParams;
				const {
					data: Listres
				} = await getList({
					pageNum: pageNum,
					pageSize: pageSize,
					keyword: keyword,
					houseName: houseName,
					houseNumber: houseNumber,
					houseState: houseState
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
		},
		created() {
			this.selectParams.pageNum = 1;
			this.selectParams.pageSize = 10;
			this.load()
		}
	}
</script>

<style>
</style>
