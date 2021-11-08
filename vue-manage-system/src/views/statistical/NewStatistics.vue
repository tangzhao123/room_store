<template>
	<el-tabs v-model="activeName">
		<el-tab-pane label="图表" name="first">
			<div class="div1">
				<div class="div2">
					
				</div>
				<div class="div2">

				</div>
				<div class="div2">

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
		width: 30%;
		height: 200px;
	}
</style>
