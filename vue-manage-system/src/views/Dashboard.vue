<template>
	<div>
		<!-- <div class="user-info" style="width: 100%;margin-top: 10px;">
			<div class="user-info-cont">
				本月统计
			</div>
			<span>{{beginDate}} - {{nowDate}}</span>
		</div> -->
		<div class="div1">
			<div class="div2" style="background: linear-gradient(1turn, #8ed3ff, #55a8fd)">
				<div>
					<span class="span1">{{house}}</span>
				</div>
				<span class="span2">精选好房 (套）</span>
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
					<span class="span1">{{statistics3}}</span>
				</div>
				<span class="span2"> 新增跟进 (次）</span>
				<div class="div3">
					<div class="div4" style="width: 100%;">
						<span class="span3">{{statistics3}}</span>
						<span class="span3">全部跟进</span>
					</div>
				</div>
			</div>
			<div class="div2" style="background: linear-gradient(1turn,#83eeb2,#4cd87a)">
				<div>
					<span class="span1">{{statistics4}}</span>
				</div>
				<span class="span2"> 新增带看 (次） </span>
				<div class="div3">
					<div class="div4" style="width: 100%;">
						<span class="span3">{{statistics4}}</span>
						<span class="span3">全部带看</span>
					</div>
				</div>
			</div>
		</div>
		<div>
			<span style="color: #DF3A01;">   租房房源   </span>
			<span style="color: #0174DF;">   客源   </span>
			<span style="color: #298A08;">   租房跟进   </span>
			<div id="broken" style="width: 100%;height: 300px;float: left"></div>
		</div>
	</div>
</template>

<script>
	import echarts from 'echarts';
	export default {
		name: "dashboard",
		data() {
			return {
				/* statistics2: [{
					"number": 1,
					"type": "二手房"
				}, {
					"number": 1,
					"type": "出租房"
				}, {
					"number": 3,
					"type": "新房"
				}], */
				house: 0,
				test1: "",
				name: this.$store.state.token.userName,
				statistics1: [0, 1, 2],
				statistics2: 0,
				statistics3: 0,
				statistics4: 0,
				data1: [],
				data2: [],
				data3: [],
				data4: [],
			};
		},
		mounted() {
			this.ss();
		},
		methods: {
			ss: async function() {
				await this.getDate4();
				// 基于准备好的dom，初始化echarts实例
				let broken = echarts.init(document.getElementById('broken'));
				// 绘制图表
				/**
				 * 折线图
				 */
				broken.setOption({
					xAxis: {
						type: 'category',
						data: this.data3
					},
					yAxis: {
						type: 'value'
					},

					series: [{
							data: this.data2,
							type: 'bar',
							color: '#DF3A01',
						},
						{
							type: 'bar',
							data: this.data1,
							color: '#0174DF',
						},
						{
							type: 'bar',
							data: this.data4,
							color: '#298A08',
						}
					]
				})
			},
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
				this.axios.get("statistics6").then((res) => {
					this.statistics3 = res.data;
				}).catch()
				this.axios.get("statistics7").then((res) => {
					this.statistics4 = res.data;
				}).catch()
			},
			getDate4: async function() {
				await this.axios.get("statistics8").then((res) => {
					res.data.forEach(d => {
						this.data3.push(d.click_date)
						if (d.count == null || d.count == '') {
							this.data2.push(0)
						} else {
							this.data2.push(d.count);
						}
					})
				}).catch()
				await this.axios.get("statistics9").then((res) => {
					res.data.forEach(d => {
						if (d.count == null || d.count == '') {
							this.data1.push(0)
						} else {
							this.data1.push(d.count);
						}
					})
				}).catch()
				await this.axios.get("statistics10").then((res) => {
					res.data.forEach(d => {
						if (d.count == null || d.count == '') {
							this.data4.push(0)
						} else {
							this.data4.push(d.count);
						}
					})
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
