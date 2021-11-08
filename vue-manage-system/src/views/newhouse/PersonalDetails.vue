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
	<div v-for="item in dataHuXing" :key="item.typeId">
		<img :src="item.typeImg"  width="300" height="200"/>
		<br />
		<span>{{item.typeName}}</span>
		<br />
		<span>{{item.typeRoom}}室</span>
		<span>{{item.typeOffice}}厅</span>
		<span>{{item.typeGuard}}卫</span>
		<span>|{{item.typeArea}}㎡</span>
	</div>
</div>

</template>

<script>
	import {
		selectByOne,
		// selectDetails,
		// selecttwo
	} from '../../api/newhouse.js'
export default{
	data(){
		return{
			tableData:[],
			listData:[],
			data:{},
			dataHuXing:[]
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
				// console.log(this.tableData)
			})
		},
		// details(){
		// 	console.log(this.$route)
		// 	var routerParams=this.$route.params.id
		// 	this.id=routerParams
		// 	selectDetails(routerParams).then(res=>{
		// 		this.listData=res.data
		// 		this.data = this.listData[0].houseTypes[0];
		// 		console.log(this.listData[0].houseTypes[0])
		// 	})
		// },
		selectTwo(){
			var routerParams=this.$route.params.id
			this.id=routerParams
			// selecttwo(routerParams:newHouseId).then(res=>{
			// 	this.dataHuXing=res.data
			// 	console.log(res.data)
			// })
			this.axios({
				url: 'house/selecttwo',
				params:{
					newHouseId:this.id
				}
			}).then((v) => {
				this.dataHuXing=v.data.data
				console.log(this.dataHuXing)
			}).catch()
		}
	},
	created(){
		this.thern()
		// this.details()
		this.selectTwo()
	}
}
</script>

<style>
</style>
