<template>
<div>
	<el-row>
		<el-col :span="12">
			<div style="width: 600px; height: 400px; ">
			<img :src="tableData.houseImg"  width="600" height="400"/>
			</div>
		</el-col>
		<el-col :span="8" :pull="1">
			<span style="font-size: 20px; font-weight: bold; margin-left: 40px;">{{tableData.houseName}}</span>
			<br />
			<span style="font-size: 25px; font-weight: bold; color: red;margin-left: 40px; ">总价：{{tableData.houseTotalPrice}}.万</span>
			<span style="font-size: 25px; margin-left: 40px;">{{tableData.houseState}}</span>
			<span style="font-size: 15px; margin-left: 40px;">建面：{{tableData.houseArea}}㎡</span>
			<br />
			<br />
			<span style="font-size: 20px; margin-left: 40px;">楼盘地址：{{tableData.houseAddress}}</span>
			<br />
			<br />
			<span style="font-size: 20px; margin-left: 40px;">楼盘编号{{tableData.houseNumber}}</span>
		</el-col>
		<br />
		<br />
	</el-row>
	<el-row>
		<div
			style="font-size: 20px; font-weight: bold;; border-bottom:1px solid #777777; width: 1400px; padding: 10px;">
			楼盘户型
		</div>
	</el-row>
	<div>
		<img :src="data.typeImg"  width="300" height="200"/>
		<br />
		<span>{{data.typeName}}</span>
		<br />
		<span>{{data.typeRoom}}室</span>
		<span>{{data.typeOffice}}厅</span>
		<span>{{data.typeGuard}}卫</span>
		<span>|{{data.typeArea}}㎡</span>
	</div>
</div>

</template>

<script>
	import {
		selectByOne,
		selectDetails
	} from '../../api/newhouse.js'
export default{
	data(){
		return{
			tableData:[],
			listData:[],
			data:{},
		}
	},
	methods:{
		thern(){
			console.log(this.$route)
			var routerParams=this.$route.params.id
			this.id=routerParams
			console.log(routerParams)
			selectByOne(routerParams).then(res=>{
				this.tableData=res.data;
				console.log(this.tableData)
			})
		},
		details(){
			console.log(this.$route)
			var routerParams=this.$route.params.id
			this.id=routerParams
			selectDetails(routerParams).then(res=>{
				this.listData=res.data
				this.data = this.listData[0].houseTypes[0];
				console.log(this.listData[0].houseTypes[0])
			})
		}
	},
	created(){
		this.thern()
		this.details()
	}
}
</script>

<style>
</style>
