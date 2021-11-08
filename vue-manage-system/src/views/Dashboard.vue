<template>
	<div>
		<div class="user-info" style="width: 100%;margin-top: 10px;">
			<div class="user-info-cont">
				本月统计
			</div>
			<span>{{beginDate}} - {{nowDate}}</span>
		</div>
		<div class="div1">
			<div class="div2" style="background: linear-gradient(1turn, #8ed3ff, #55a8fd)">
				<div>
					<span class="span1">{{house}}</span>
				</div>
				<span class="span2">新增房源 (套）</span>
				<div class="div3">
					<div class="div4" style="width: 30%;">
						<span class="span3">{{statistics1[0].number}}</span>
						<span class="span3">{{statistics1[0].type}}</span>
					</div>
					<div class="div4" style="width: 30%;">
						<span class="span3">{{statistics1[1].number}}</span>
						<span class="span3">{{statistics1[1].type}}</span>
					</div>
					<div class="div4" style="width: 30%;">
						<span class="span3">{{statistics1[2].number}}</span>
						<span class="span3">{{statistics1[2].type}}</span>
					</div>
				</div>
			</div>
			<div class="div2" style="background: linear-gradient(1turn,#ffe06f,#febd3c)">
				<div>
					<span class="span1">{{statistics2}}</span>
				</div>
				<span class="span2">新增客源 (人）</span>
				<div class="div3">
					<div class="div4" style="width: 100%;">
						<span class="span3">{{statistics2}}</span>
						<span class="span3">全部客源</span>
					</div>
				</div>
			</div>
			<div class="div2" style="background: linear-gradient(1turn,#c2b5f4,#8f7ee5)">
				<div>
					<span class="span1">{{house}}</span>
				</div>
				<span class="span2"> 新增带看 (次）</span>
				<div class="div3">
					<div class="div4" style="width: 30%;">
						<span class="span3">{{statistics1[0].number}}</span>
						<span class="span3">{{statistics1[0].type}}</span>
					</div>
					<div class="div4" style="width: 30%;">
						<span class="span3">{{statistics1[1].number}}</span>
						<span class="span3">{{statistics1[1].type}}</span>
					</div>
					<div class="div4" style="width: 30%;">
						<span class="span3">{{statistics1[1].number}}</span>
						<span class="span3">{{statistics1[1].type}}</span>
					</div>
				</div>
			</div>
			<div class="div2" style="background: linear-gradient(1turn,#83eeb2,#4cd87a)">
				<div>
					<span class="span1">{{house}}</span>
				</div>
				<span class="span2"> 新增跟进 (次）</span>
				<div class="div3">
					<div class="div4" style="width: 50%;">
						<span class="span3">{{statistics1[0].number}}</span>
						<span class="span3">{{statistics1[0].type}}</span>
					</div>
					<div class="div4" style="width: 50%;">
						<span class="span3">{{statistics1[1].number}}</span>
						<span class="span3">{{statistics1[1].type}}</span>
					</div>
				</div>
			</div>
		</div>
		<!-- <el-row :gutter="20">
			<el-col :span="12">
				<el-card shadow="hover">
					<schart ref="bar" class="schart" canvasId="bar" :options="options"></schart>
				</el-card>
			</el-col>
			<el-col :span="12">
				<el-card shadow="hover">
					<schart ref="line" class="schart" canvasId="line" :options="options2"></schart>
				</el-card>
			</el-col>
		</el-row> -->
	</div>
</template>

<script>
	//import Schart from "vue-schart";
	import echarts from 'echarts';
	export default {
		name: "dashboard",
		data() {
			return {
				house: 0,
				test1: "",
				beginDate: '', //开始日期
				nowDate: '', //现在日期
				name: this.$store.state.token.userName,
				statistics1: [0, 1, 2],
				statistics2: 0,
				options: {
					type: "bar",
					title: {
						text: "最近一周各品类销售图"
					},

					xRorate: 25,
					labels: ["周一", "周二", "周三", "周四", "周五"],
					datasets: [{
							label: "家电",
							data: [234, 278, 270, 190, 230]
						},
						{
							label: "百货",
							data: [164, 178, 190, 135, 160]
						},
						{
							label: "食品",
							data: [144, 198, 150, 235, 120]
						}
					]
				},
				options2: {
					type: "line",
					title: {
						text: "最近几个月各品类销售趋势图"
					},
					labels: ["6月", "7月", "8月", "9月", "10月"],
					datasets: [{
							label: "家电",
							data: [234, 278, 270, 190, 230]
						},
						{
							label: "百货",
							data: [164, 178, 150, 135, 160]
						},
						{
							label: "食品",
							data: [74, 118, 200, 235, 90]
						}
					]
				}
			};
		},
		components: {

			//Schart
		},
		computed: {
			role() {
				return this.name === "admin" ? "超级管理员" : "普通用户";
			}
		},

		methods: {
			times() {
				var aData = new Date();
				this.nowDate = aData.getFullYear() + "-" + (aData.getMonth() + 1) + "-" + aData
					.getDate();
				this.beginDate = aData.getFullYear() + "-" + (aData.getMonth() + 1) + "-1";
			},
			statistics() {
				let broken = echarts.init(document.getElementById('broken'));
				broken.setOption({
					//too
				})
			},
			getDate() {
				this.axios.get("statistics1").then((res) => {
					this.statistics1 = res.data;
					this.house = this.statistics1[0].number + this.statistics1[1].number + this
						.statistics1[2].number
				}).catch()
				this.axios.get("statistics2").then((res) => {
					this.statistics2 = res.data;
				}).catch()
			},
		},
		created() {
			this.getDate();
			this.times();
		},
	};
</script>

<style scoped>
	.div1 {
		width: 100%;
		height: 200px;
	}

	.div2 {
		margin-right: 20px;
		display: inline-block;
		positiom: absolute;
		width: 20%;
		height: 200px;

	}

	.div3 {
		bottom: 0;
		width: 100%;
		height: 100px;
		background: #f5faff
	}

	.div4 {
		display: inline-block;
		height: 50px;
		font-size: 14px;
	}

	.span1 {
		font-size: 36px;
		font-weight: 500;
		display: block;
		color: #fff;
		line-height: 50px;
		text-align: center;
	}

	.num {
		-webkit-box-flex: 1;
		-ms-flex: 1;
		flex: 1;
		font-size: 14px;
		font-weight: 400;
		color: #333;
		line-height: 20px;
		padding-bottom: 15 px;
	}

	.span2 {
		font-size: 16px;
		display: block;
		color: #fff;
		line-height: 50px;
		text-align: center;
	}

	.span3 {
		display: block;
		text-align: center;
		line-height: 50px;
		font-size: 16px;
	}

	.div-inline {
		display: inline
	}

	.el-row {
		margin-bottom: 20px;
	}

	.grid-content {
		display: flex;
		align-items: center;
		height: 100px;
	}

	.grid-cont-right {
		flex: 1;
		text-align: center;
		font-size: 14px;
		color: #999;
	}

	.grid-num {
		font-size: 30px;
		font-weight: bold;
	}

	.grid-con-icon {
		font-size: 50px;
		width: 100px;
		height: 100px;
		text-align: center;
		line-height: 100px;
		color: #fff;
	}

	.grid-con-1 .grid-con-icon {
		background: rgb(45, 140, 240);
	}

	.grid-con-1 .grid-num {
		color: rgb(45, 140, 240);
	}

	.grid-con-2 .grid-con-icon {
		background: rgb(100, 213, 114);
	}

	.grid-con-2 .grid-num {
		color: rgb(45, 140, 240);
	}

	.grid-con-3 .grid-con-icon {
		background: rgb(242, 94, 67);
	}

	.grid-con-3 .grid-num {
		color: rgb(242, 94, 67);
	}

	.user-info {
		display: flex;
		align-items: center;
		padding-bottom: 20px;
		border-bottom: 2px solid #ccc;
		margin-bottom: 20px;
	}

	.user-avator {
		width: 120px;
		height: 120px;
		border-radius: 50%;
	}

	.user-info-cont {
		padding-left: 50px;
		flex: 1;
		font-size: 14px;
		color: #999;
	}

	.user-info-cont div:first-child {
		font-size: 30px;
		color: #222;
	}

	.user-info-list {
		font-size: 14px;
		color: #999;
		line-height: 25px;
	}

	.user-info-list span {
		margin-left: 70px;
	}

	.mgb20 {
		margin-bottom: 20px;
	}

	.todo-item {
		font-size: 14px;
	}

	.todo-item-del {
		text-decoration: line-through;
		color: #999;
	}

	.schart {
		width: 100%;
		height: 300px;
	}
</style>
