<template>
	<el-tabs v-model="activeName">
		<el-tab-pane label="图表" name="first">
			<div class="div1">
				<div class="div2" style="background:linear-gradient(90deg, rgb(198, 119, 232), rgb(108, 133, 233)">

				</div>
				<div class="div2" style="background:linear-gradient(90deg, rgb(247, 202, 108), rgb(254, 150, 62))">

				</div>
				<div class="div2" style="background:linear-gradient(90deg, rgb(70, 193, 242), rgb(99, 151, 210))">

				</div>
			</div>
		</el-tab-pane>
		<el-tab-pane label="统计" name="second"></el-tab-pane>
	</el-tabs>
</template>

<script>
	import Schart from "vue-schart";
	import echarts from 'echarts';
	export default {
		data() {
			return {
				activeName: 'second',
			}
		},
		methods: {

		},
		created() {

		}
	}
</script>

<style>
	.div1 {
		width: 100%;
		height: 200px;
	}

	.div2 {
		margin-right: 20px;
		display: inline-block;
		positiom: absolute;
		width: 33%;
		height: 200px;
	}
</style>
