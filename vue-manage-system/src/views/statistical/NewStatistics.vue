<template>
	<div class="div1">
		<div class="div2" style="background: linear-gradient(1turn, #8ed3ff, #55a8fd)">
			<div>
				<span class="span1">{{sum1}}</span>
			</div>
			<span class="span2">新房楼盘总数（个）</span>
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
				<span class="span1">{{sum2}}</span>
			</div>
			<span class="span2">二手房房源总数（套）</span>
			<div class="div3">
				<div class="div4" style="width: 40%;">
					<span class="span3">{{statistics2[0].number}}</span>
					<span class="span3">{{statistics2[0].type == 1 ? "上架":"下架"}}</span>
				</div>
				<div class="div4" style="width: 40%;">
					<span class="span3">{{statistics2[1].number}}</span>
					<span class="span3">{{statistics2[1].type == 1 ? "上架":"下架"}}</span>
				</div>
			</div>
		</div>
		<div class="div2" style="background: linear-gradient(1turn,#c2b5f4,#8f7ee5)">
			<div>
				<span class="span1">{{sum3}}</span>
			</div>
			<span class="span2"> 租房房源总数（套）</span>
			<div class="div3">
				<div class="div4" style="width: 40%;">
					<span class="span3">{{statistics3[0].number}}</span>
					<span class="span3">{{statistics3[0].type == 1 ? "上架":"下架"}}</span>
				</div>
				<div class="div4" style="width: 40%;">
					<span class="span3">{{statistics3[1].number}}</span>
					<span class="span3">{{statistics3[1].type == 2 ? "上架":"下架"}}</span>
				</div>
			</div>
		</div>
		<div>最近一周新增</div>
		<div id="broken" style="width: 100%;height: 300px;float: left"></div>
	</div>
</template>

<script>
	import echarts from 'echarts';
	export default {
		data() {
			return {
				statistics1: [{
					"number": 0,
					"type": "待售"
				}, {
					"number": 0,
					"type": "在售"
				}, {
					"number": 0,
					"type": "售罄"
				}],
				statistics2: [{
					"number": 0,
					"type": 0
				}, {
					"number": 0,
					"type": 1
				}],
				statistics3: [{
					"number": 0,
					"type": 1
				}, {
					"number": 0,
					"type": 2
				}],
				data1: [],
				sum1: 0,
				sum2: 0,
				sum3: 0,
				activeName: 'first',
				data2: [],
				data3: [],
			}
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
						type: 'bar'
					}]
				})
			},
			getDate1() {
				this.axios.get("statistics5").then((res) => {
					res.data.forEach(d => {
						this.sum1 = this.sum1 + d.number
						this.statistics1.forEach(s => {
							if (d.type == s.type) {
								s.number = d.number
							}
						})
					})
				}).catch()
			},
			getDate2() {
				this.axios.get("statistics4").then((res) => {
					res.data.forEach(d => {
						this.sum2 = this.sum2 + d.number
						this.statistics2.forEach(s => {
							if (d.type == s.type) {
								s.number = d.number
							}
						})
					})
				}).catch()
			},
			getDate3() {
				this.axios.get("statistics3").then((res) => {
					res.data.forEach(d => {
						this.sum3 = this.sum3 + d.number
						this.statistics3.forEach(s => {
							if (d.type == s.type) {
								s.number = d.number
							}
						})
					})
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
					console.log(this.data2)
				}).catch()
			},
		},
		created() {
			this.getDate1();
			this.getDate2();
			this.getDate3();
			//this.getDate4();
		}
	}
</script>

<style>
	.div1 {
		width: 100%;
		height: 400px;
	}

	.div2 {
		margin-right: 20px;
		display: inline-block;
		positiom: absolute;
		width: 30%;
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
</style>
