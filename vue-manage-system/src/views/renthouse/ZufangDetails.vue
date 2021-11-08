<template>
	<div>
		<el-row>
			<el-col :span="12">
				<div style="width: 600px; height: 400px; ">
					<img :src="housing.rehoZhutu" width="600" height="400"/>
				</div>
			</el-col>
			<el-col :span="10" :pull="1" style="margin-left:50px">
				<el-row>
					<el-col style="margin-top:40px;margin-bottom:25px;">
						<span style="font-size: 20px; font-weight: bold;">{{housing.rehoRentouttitle}}</span>
					</el-col>
				</el-row>
				<el-row style="margin-bottom:25px">
					<el-col :span="7">
						<span style="font-size: 36px; font-weight: bold; color: red;">{{housing.rehoRent}}<span style="font-size: 16px;color: #999; margin-left: 3px;">元/月</span></span>
					</el-col>
					<el-col :span="7" :offset="1">
						<span style="font-size: 20px; color: #333;line-height:41px; font-weight: bold;">{{housing.rehoPayway}}</span>
					</el-col>
					<el-col :span="7" :offset="1">
						<span style="font-size: 20px; color: #333;line-height:41px; font-weight: bold;">{{housing.rehoShelf == 1 ? "上架":"下架"}}</span>
					</el-col>
				</el-row>
				<el-row style="margin-bottom:25px">
					<el-col :span="7">
						<span style="font-size: 20px; color: #333;"><span style="font-size:14px">户型：</span>{{housing.rehoHousetype}}</span>
					</el-col>
					<el-col :span="7" :offset="1">
						<span style="font-size: 14px">建筑面积：<span style="font-size:20px;color:#333">{{housing.rehoCoveredarea}}</span>㎡</span>
					</el-col>
					<el-col :span="7" :offset="1">
						<span style="font-size: 20px; color:#333;"><span style="font-size:14px">朝向：</span>{{housing.rehoOrientation}}</span>
					</el-col>
				</el-row>
				<el-row style="margin-bottom:25px">
					<el-tag style="font-size: 16px;">{{housing.rehoHouslabel}}</el-tag>
				</el-row>
				<el-row style="font-size:14px;color:#666;">
					房源编码：{{housing.rehoNumber}}
				</el-row>
			</el-col>
		</el-row>
		<div>
			<div style="font-size: 20px; font-weight: bold;; border-bottom:1px solid #777777; width: 1400px; padding: 10px;">
				基本信息
			</div>
			<div style="color:#666;font-size:14px;">
				<br>
				<el-row>
					<el-col :span="4">
						房源属性
					</el-col>
					<el-col :span="10">
						房屋类型：<span style="color:#300;font-weight:500;">{{housing.rehoHousingtypes}}</span><br><br>
						装修情况：<span style="color:#300;font-weight:500">{{housing.rehoFitmenttype}}</span><br><br>
						配备电梯：<span style="color:#300;font-weight:500">{{housing.rehoElevator}}</span><br><br>
						所在城市：<span style="color:#300;font-weight:500">{{shi}}</span><br>
					</el-col>
					<el-col :span="10">
						发布时间：<span style="color:#300;font-weight:500">{{housing.rehoDate}}</span><br><br>
						房屋朝向：<span style="color:#300;font-weight:500">{{housing.rehoLivefewfloor}}/(共{{housing.rehoFloornumber}})</span><br><br>
						所在楼层：<span style="color:#300;font-weight:500">{{housing.rehoOrientation}}</span><br><br>
						小区名称：<span style="color:#300;font-weight:500">{{housing.rehoCommunity}}</span><br>
					</el-col>
				</el-row>
			</div>
		</div>
		<div>
			<div style="font-size: 20px; font-weight: bold;; border-bottom:1px solid #777777; width: 1400px; padding: 10px;">
				房源介绍
			</div>
			<div style="line-height: 30px; font-size: 14px ;    color: #606266;">
				{{housing.rehoHousremark}}
			</div>
		</div>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				id: '', //房屋编号
				housing: {},//房源对象
				rehoHouslabel:[],
				shi:""
			}
		},
		methods: {
			getParams() {
				// 取到路由带过来的参数
				let routerParams = JSON.parse(this.$route.query.params)
				// 将数据放在当前组件的数据内
				this.id = routerParams.no
				
				this.axios({
					url: 'Renthouse/findRentalhousingByNumber',
					params: {
						param: this.id
					}
				}).then((v) => {
					this.housing = v.data[0];
					var aa = this.housing.rehoSite.split("省")[1].split("市");
					this.shi = aa[0].substr(1)+"市";
					console.log(v.data)
					this.rehoHouslabel = this.housing.rehoHouslabel.split(",");
					console.log(this.rehoHouslabel)
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
