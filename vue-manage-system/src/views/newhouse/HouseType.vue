<template>
	<div style="padding: 10px;">
		<div>
			<el-button @click="add()">新增采集</el-button>
		</div>
		<div style="margin-top: 10px;">
			<el-form :inline="true" v-model="selectParams">
				<el-form-item label="小区名称">
					<el-input v-model="selectParams.typeName" placeholder="请输入小区名称" style="width: 170px;" clearable></el-input>
				</el-form-item>
				<el-form-item>
					<el-button type="primary" @click="onsumbit()" icon="el-icon-search" style="margin-left: 20px;">查询</el-button>
				</el-form-item>
			</el-form>
		</div>
		<el-table :data="tableData" style="width: 100%">
			<el-table-column prop="typeName" label="户型名称"></el-table-column>
			<el-table-column prop="typeArea" label="户型面积"></el-table-column>
			<el-table-column prop="sourceProperty" label="户型编号"></el-table-column>
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
				<el-form-item label="户型名称" prop="typeName">
					<el-input v-model="form.typeName" placeholder="小区名称" style="width: 240px;"></el-input>
				</el-form-item>
				<el-row>
					<el-col :span="6">
						<el-form-item label="室" prop="typeRoom">
							<el-input v-model="form.typeRoom" placeholder="室" style="width: 120px;"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="6">
						<el-form-item label="厅" prop="typeOffice">
							<el-input v-model="form.typeOffice" placeholder="室" style="width: 120px;"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="6">
						<el-form-item label="厨" prop="typeKitchen">
							<el-input v-model="form.typeKitchen" placeholder="室" style="width: 120px;"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="6">
						<el-form-item label="卫" prop="typeGuard">
							<el-input v-model="form.typeGuard" placeholder="室" style="width: 120px;"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-form-item label="面积" prop="typeArea">
					<el-input v-model="form.typeArea" placeholder="面积" style="width: 240px;"></el-input>
				</el-form-item>
				<el-form-item label="户型标签" prop="typeLabel">
					<el-radio v-model="form.typeLabel" label="全南格局">全南格局</el-radio>
					<el-radio v-model="form.typeLabel" label="南北通透">南北通透</el-radio>
					<el-radio v-model="form.typeLabel" label="全明户型">全明户型</el-radio>
					<el-radio v-model="form.typeLabel" label="带阳台">带阳台</el-radio>
					<el-radio v-model="form.typeLabel" label="大落地窗">大落地窗</el-radio>
					<el-radio v-model="form.typeLabel" label="主卧带卫">主卧带卫</el-radio>
					<el-radio v-model="form.typeLabel" label="采光好">采光好</el-radio>
					<el-radio v-model="form.typeLabel" label="户型放纵">户型放纵</el-radio>
				</el-form-item>
				<el-form-item label="户型图" prop="typeImg">
					<el-input v-model="form.typeImg" placeholder="户型图" style="width: 240px;"></el-input>
				</el-form-item>
				<el-form-item label="户型描述" prop="typeDescribe">
					<el-input :rows="10" type="textarea" v-model="form.typeDescribe" placeholder="户型描述" style="width: 600px;"></el-input>
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
		addall
	} from '../../api/housetype.js'
	export default {
		data() {
			return {
				selectParams: {},
				tableData: [],
				form: {},
				dialogVisible: false,
				total: 0,
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
				if (this.form.typeId) {
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
					typeName,
				} = this.selectParams;
				const {
					data: Listres
				} = await getList({
					pageNum: pageNum,
					pageSize: pageSize,
					keyword: keyword,
					typeName: typeName,
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
