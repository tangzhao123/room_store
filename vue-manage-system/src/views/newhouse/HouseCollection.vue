<template>
	<div style="padding: 10px;">
		<div>
			<el-form v-model="selectParams">
				<el-form-item label="小区名称">
					<el-input v-model="selectParams.sourceName" placeholder="请输入小区名称" style="width: 170px;" clearable></el-input>
				</el-form-item>
			</el-form>
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
	</div>
</template>

<script>
	import {
		getList,
		enit,
		addall
	} from '../../api/housecollection.js'
	export default {
		data() {
			return {
				selectParams: {},
				tableData: [],
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
				if (this.form.id) {
					enit(this.form).then(res => {
						if (res.code == 200) {
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
								if (res.code == 200) {
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
		},
	}
</script>

<style>
</style>
