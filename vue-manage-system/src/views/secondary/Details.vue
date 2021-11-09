<template>
	<div>
		<el-row>
			<el-col :span="12">
				<div style="width: 600px; height: 400px; ">
					<img :src="secondary.secondaryPicture" width="600" height="400"/>
				</div>
			</el-col>
			<el-col :span="8" :pull="1" :offset="2">
				<span style="font-size: 20px; font-weight: bold;">{{secondary.secondaryTitle}}</span>
				<br />
				<br />
				<span style="font-size: 25px; font-weight: bold; color: red;">{{secondary.secondaryPrice}}.00万</span>
				<br />
				<br />
				<span>户型：{{secondary.secondaryModel}}</span>
				<br />
				<br />
				<span>建筑面积：{{secondary.secondaryArea}}.00㎡ &nbsp;&nbsp;&nbsp;{{secondary.secondaryState == 0?'上架':'下架'}}</span>
				<br />
				<br />
				
				<el-row style="margin-bottom:25px" v-if="secondary.secondaryLable != ''">
					<el-tag style="font-size: 16px; margin-right:4px;" v-for="(item,index) in rehoHouslabel" :key="rehoHouslabel[index]">{{rehoHouslabel[index]}}</el-tag>
				</el-row>
				<!-- <span v-if="secondary.secondaryLable != ''>
					<el-tag style="font-size: 16px;" v-for="(item,index) in rehoHouslabel" :key="rehoHouslabel[index]">{{rehoHouslabel[index]}}</el-tag>
				</span> -->
				<br />
				<br />
				<span>
					房源编码：{{secondary.secondaryNumber}}
				</span>
			</el-col>
		</el-row>
		<el-row>
			<div
				style="font-size: 20px; font-weight: bold;; border-bottom:1px solid #777777; width: 1400px; padding: 10px;">
				基本信息
			</div>
		</el-row>
		<div>
			<span>
				房屋用途：{{secondary.secondaryUse}}&nbsp;&nbsp;&nbsp;&nbsp;发布时间：{{secondary.secondaryAvailability}}
			</span>
			<br />
			<br />
			<span>装修情况：{{secondary.secondaryType}}&nbsp;&nbsp;&nbsp;&nbsp;房屋朝向：{{secondary.secondaryToward}}</span>
			<br />
			<br />
			<span>配备电梯：{{secondary.secondaryElevator}}&nbsp;&nbsp;&nbsp;&nbsp;所在楼层： {{secondary.secondaryLayer}}</span>
			<br />
			<br />
			<span>所在城市：{{secondary.secondaryCity}}&nbsp;&nbsp;&nbsp;&nbsp;建筑年代： {{secondary.secondaryYear}}</span>
			<br />
			<br />
			<span>小区名称：{{secondary.secondaryVillage}}&nbsp;&nbsp;&nbsp;&nbsp;房源来源： {{secondary.secondaryAccess}}</span>
			<br />
			<br />
			<span>产权年限：70年&nbsp;&nbsp;&nbsp;&nbsp;购房年限：满2年</span>
		</div>
		<el-row>
			<div
				style="font-size: 20px; font-weight: bold;; border-bottom:1px solid #777777; width: 1400px; padding: 10px;">
				房源介绍
			</div>
		</el-row>
		<span>
			房屋介绍：{{secondary.secondaryHousing}}
		</span>
		<br />
		<br />
		<span>小区介绍：{{secondary.secondaryCommunity}}</span>
		<br />
		<br />
		<span>附近学校：{{secondary.secondarySchool}}</span>
		<br />
		<br />
		<span>房源优势：{{secondary.secondaryAdvantage}}</span>
		<br />
		<br />
		<span>业主心态：{{secondary.secondaryOwner}}</span>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				id: '', //房屋编号
				secondary: {},//房源对象
				rehoHouslabel:[]
			}
		},
		methods: {
			getParams() {
				// 取到路由带过来的参数
				var routerParams = this.$route.params.id
				// 将数据放在当前组件的数据内
				this.id = routerParams
				
				this.axios({
					url: 'Secondary/secondary-list-user',
					params: {
						secondaryNumber: this.id
					}
				}).then((v) => {
					this.secondary = v.data;
					this.rehoHouslabel = this.secondary.secondaryLable.split(",");
					console.log(v)
				}).catch(function() {
				
				})
				
			},
			
		},
		created() {
			this.getParams()
		}
	}
</script>

<style>
</style>
