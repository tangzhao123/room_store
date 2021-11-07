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
		<div style="height: 300px; width: 1250px; border: 1px solid #D9D9D9; margin-left: 5px; margin: 10px;">
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
					<el-form-item label="房屋用途">
						<el-col span="2">
							<el-checkbox v-model="value" label="办公"></el-checkbox>
							<el-checkbox v-model="value" label="土地"></el-checkbox>
							<el-checkbox v-model="value" label="住宅"></el-checkbox>
							<el-checkbox v-model="value" label="商业"></el-checkbox>
							<el-checkbox v-model="value" label="工业"></el-checkbox>
						</el-col>
					</el-form-item>
				</el-form>
			</el-row>
			<el-row>
				<el-form label-width="80px">
					<el-form-item label="房型">
						<el-col span="2">
							<el-checkbox v-model="value" label="一室"></el-checkbox>
							<el-checkbox v-model="value" label="二室"></el-checkbox>
							<el-checkbox v-model="value" label="三室"></el-checkbox>
							<el-checkbox v-model="value" label="四室"></el-checkbox>
							<el-checkbox v-model="value" label="五室及以上"></el-checkbox>
						</el-col>
					</el-form-item>
				</el-form>
			</el-row>
			<el-row>
				<el-form label-width="80px">
					<el-form-item label="朝向">
						<el-col span="2">
							<el-checkbox v-model="value" label="朝东"></el-checkbox>
							<el-checkbox v-model="value" label="朝南"></el-checkbox>
							<el-checkbox v-model="value" label="朝西"></el-checkbox>
							<el-checkbox v-model="value" label="朝北"></el-checkbox>
							<el-checkbox v-model="value" label="南北"></el-checkbox>
							<el-checkbox v-model="value" label="其他"></el-checkbox>
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
				pageNo:1,//页码
				size:5,//页大小
				total:0,//总记录数
				options: [],
				secondary: { //二手房对象
					secondaryId: '', //序号
					secondaryNumber: '', //房源编号
					secondaryCity: '', //城市/区域
					secondaryVillage: '', //小区名称
					secondaryFloor: '', //总楼层
					secondaryLayer: '', //所在层
					secondaryUnit: '', //单元
					secondaryBuilding: '', //楼栋
					secondaryRoom: '', //房号
					secondaryArea: '', //建筑面积
					secondaryWithin: '', //套内面积
					secondaryModel: '', //户型
					secondaryToward: '', //朝向
					secondaryYear: '', //建筑年代
					secondaryUse: '', //房屋用途
					secondaryLadder: '', //梯户比例
					secondaryElevator: '', //有无电梯
					secondaryCover: '', //封面照片
					secondaryBack: '', //封底照片
					secondaryPage: '', //权属页照片
					secondaryFamily: '', //户型页照片
					secondaryTitle: '', //出售标题
					secondaryPrice: '', //价格
					secondaryType: '', //装修类型
					secondaryAccess: '', //房源获取渠道
					secondaryLable: '', //房屋标签
					secondaryPower: '', //权力性质
					secondaryRights: '', //产权年限
					secondaryBuy: '', //购买年限
					secondaryOnly: '', //是否唯一
					secondaryHousing: '', //房屋介绍
					secondaryCommunity: '', //小区介绍
					secondarySchool: '', //附近学校
					secondaryAdvantage: '', //房源优势
					secondaryOwner: '', //业主心态
					secondaryState: '', //上下架状态
					secondaryPoolsAccess: '', //公房池状态
					secondaryAvailability: '', //房源发布时间
					goodRoom: '', //好房外键
					userId: '' //用户外键
				},
				value: '',
			}
		},
		methods: {
			//跳转到新增房源的界面
			intoHousing() {
				this.$router.push("/into_housing");
			},
		},
		created() {

		}
	}
</script>

<style>
</style>
