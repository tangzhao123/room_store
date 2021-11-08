<template>
	<div>
		<el-row>
			<el-col :span="8">
				<el-form label-width="80px">
					<el-form-item label="城市名称">
						<el-input placeholder="请输入城市名称" clearable></el-input>
					</el-form-item>
				</el-form>
			</el-col>
			<el-col :span="8">
				<el-form label-width="80px">
					<el-form-item label="小区名称">
						<el-input placeholder="请输入小区名称" clearable></el-input>
					</el-form-item>
				</el-form>
			</el-col>
			<el-col :span="2" :push="1">
				<el-button type="primary" size="medium" @click="getData()">查询</el-button>
			</el-col>
		</el-row>
		<div style="height: 240px; width: 1250px; border: 1px solid #D9D9D9; margin-left: 5px; margin: 10px;">
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
					<el-form-item label="装修">
						<el-col span="2">
							<el-checkbox v-model="value" label="毛坯房"></el-checkbox>
							<el-checkbox v-model="value" label="普通装修"></el-checkbox>
							<el-checkbox v-model="value" label="精装修"></el-checkbox>
						</el-col>
					</el-form-item>
				</el-form>
			</el-row>
			<el-row>
				<el-col :span="4">
					<el-form label-width="80px">
						<el-form-item label="租金">
							<el-input v-model="input" placeholder="最低资金" />
						</el-form-item>
					</el-form>
				</el-col>
				<el-col :span="3">
					<el-form label-width="30px">
						<el-form-item label="-">
							<el-input v-model="input" placeholder="最高资金" />
						</el-form-item>
					</el-form>
				</el-col>
				<el-col :span="3">
					<el-form label-width="50px">
						<el-form-item label="元/月">
							<el-button type="primary" size="medium" >确定</el-button>
						</el-form-item>
					</el-form>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="4">
					<el-form label-width="80px">
						<el-form-item label="建筑面积">
							<el-input v-model="input" placeholder="最小面积" />
						</el-form-item>
					</el-form>
				</el-col>
				<el-col :span="3">
					<el-form label-width="30px">
						<el-form-item label="-">
							<el-input v-model="input" placeholder="最大面积" />
						</el-form-item>
					</el-form>
				</el-col>
				<el-col :span="3">
					<el-form label-width="50px">
						<el-form-item label="m²">
							<el-button type="primary" size="medium" >确定</el-button>
						</el-form-item>
					</el-form>
				</el-col>
			</el-row>
		</div>
	</div>
</template>

<script>
</script>

<style>
</style>
