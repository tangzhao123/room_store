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
				<!--      <template v-slot:default="r">
        <el-tag>{{r.row.empName}}</el-tag>
      </template>-->
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
			<el-table-column label="操作" fixed="right" width="120">
				<!--        <template>
          <el-link type="primary" @click="tigong()">提供新房房源</el-link>
        </template>-->
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
			<el-table :data="tableData.slice((pageNo-1)*size,pageNo*size)" border @selection-change="xuan"
				style="width: 100%">
				<el-table-column fixed="left" type="selection" width="55">
				</el-table-column>
				<el-table-column prop="deptId" label="编号" width="180">
				</el-table-column>
				<el-table-column prop="deptName" label="部门" width="180">
				</el-table-column>
				<el-table-column prop="deptCreate" label="创建时间">
				</el-table-column>
			</el-table>
		</el-dialog>

	</div>
</template>

<script>
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
				fangDialog: true,
				xinfan: [], //新房
				ershoufan: [], //二手房
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
			allCustomersBymaleState() {
				this.axios.get("Customerss/AllCustomersBymaleState").then((v) => {
					this.demandForm = v.data;
				});
			},
			HousSelectAll() {
				this.axios.get("Hous/selectAll").then((v) => {
					this.xinfan = v.data;
				});
			},
			SeconSelectAll() {
				this.axios.get("Secon/selectAll").then((v) => {
					this.ershoufan = v.data;
				});
			},
		},
		created() {
			this.allCustomersBymaleState();
		}
	}
</script>

<style scoped>
	h4 {
		width: 70px;
	}
</style>
