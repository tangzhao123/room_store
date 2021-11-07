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
		</el-table>
		<div style="margin: 10px 0;">
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
				:page-sizes="[5, 10, 20]" layout="total, sizes, prev, pager, next, jumper" :total="total">
			</el-pagination>
		</div>
	</div>
</template>

<script>
	import {
		getList
	} from '../../api/newhouse.js'
	export default {
		data() {
			return {
				selectParams: {},
				total: 0,
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
			async load() {
				let {
					pageNum,
					pageSize,
					keyword,
					houseName
				} = this.selectParams;
				const {
					data: Listres
				} = await getList({
					pageNum: pageNum,
					pageSize: pageSize,
					keyword: keyword,
					houseName: houseName
				});
				this.tableData = Listres.list
				this.total = Listres.total
			},
			onsumbit() {
				this.load()
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
