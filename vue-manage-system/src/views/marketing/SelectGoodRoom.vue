<template>
	<div>
		<!-- 筛选开始   -->
		<el-row style="margin-left:30px;margin-top:20px;">
			<el-col :span="6">
				<div class="grid-content bg-purple">
					<label>标题</label>
					<el-input v-model="s" placeholder="例如: 北京" clearable style="width:220px;margin-left: 10px;" />
				</div>
			</el-col>
			<el-col :span="6">
				<div class="grid-content bg-purple-light">
					<label>类型</label>
					<el-select placeholder="请选择类型" v-model="s" value-key="" style="margin-left: 10px;">
						<!-- <el-option v-for="item in titles" :key="item.titId" :label="item.titName" :value="item">
            </el-option> -->
					</el-select>
				</div>
			</el-col>
			<el-col :span="6">
				<div class="grid-content bg-purple" style="margin-top: 10px;">
					<label>客源状态</label>
					<el-radio-group v-model="s" style="margin-left: 10px;">
						<el-radio label="全部">全部</el-radio>
						<el-radio label="有效">有效</el-radio>
						<el-radio label="失效">失效</el-radio>
					</el-radio-group>
				</div>
			</el-col>
			<el-col :span="6">
				<div class="grid-content bg-purple-light">
					<el-button type="primary">搜索</el-button>
				</div>
			</el-col>
		</el-row>
		<!-- 筛选结束   -->
		<el-button type="primary" style="margin-top: 20px;margin-left: 30px;">新增精选好房</el-button>

		<!--  表格开始    -->
		<el-table :data="selectForm.slice((pageNo-1)*size,pageNo*size)" border style="width: 100%;margin-top: 30px;">
			<el-table-column prop="empId" label="编号" min-width="100">
			</el-table-column>
			<el-table-column prop="empName" label="标题" min-width="100">
				<!--      <template v-slot:default="r">
        <el-tag>{{r.row.empName}}</el-tag>
      </template>-->
			</el-table-column>
			<el-table-column prop="useres.userAccount" label="类型" min-width="100">
			</el-table-column>
			<el-table-column prop="empPhone" label="创建时间" min-width="120">
			</el-table-column>
			<el-table-column prop="empCard" label="关联房源数" min-width="170">
			</el-table-column>
			<el-table-column prop="empInduction" label="有效/失效" min-width="160">
			</el-table-column>
		</el-table>
		<!--  表格结束  -->

		<!-- 分页开始   -->
		<div style="text-align: center;margin-top: 10px;">
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageNo"
				:page-sizes="[5, 10, 15, 20]" :page-size="size" layout="total, sizes, prev, pager, next, jumper"
				:total="selectForm.length">
			</el-pagination>
		</div>
		<!--  分页结束  -->
	</div>
</template>

<script>
	export default {
		data() {
			return {
				//筛选
				s: '', //标题
				selectForm: [], //需求表格
				//分页
				pageNo: 1, //当前页数
				size: 5, //当前页显示的条数
				total: 0, //总记录数
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
		}
	}
</script>

<style>
</style>
