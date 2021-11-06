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
		<div style="height: 300px; width: 1250px; border: 1px solid #D9D9D9; margin-left: 5px; margin: 10px;">
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
				<el-form label-width="80px">
					<el-form-item label="租金">
						<el-col span="2">
							<el-checkbox v-model="value" label="一室"></el-checkbox>
							<el-checkbox v-model="value" label="二室"></el-checkbox>
							<el-checkbox v-model="value" label="三室"></el-checkbox>
							<el-checkbox v-model="value" label="四室"></el-checkbox>
							<el-checkbox v-model="value" label="五室及以上"></el-checkbox>
						</el-col>
					</el-form-item>
				</el-form>
			</el-row>
			<el-row>
				<el-form label-width="80px">
					<el-form-item label="建筑面积">
						<el-col span="2">
							<el-checkbox v-model="value" label="朝东"></el-checkbox>
							<el-checkbox v-model="value" label="朝南"></el-checkbox>
							<el-checkbox v-model="value" label="朝西"></el-checkbox>
							<el-checkbox v-model="value" label="朝北"></el-checkbox>
							<el-checkbox v-model="value" label="南北"></el-checkbox>
							<el-checkbox v-model="value" label="其他"></el-checkbox>
						</el-col>
					</el-form-item>
				</el-form>
			</el-row>
		</div>
	</div>
</template>

<script>
</script>

<style>
</style>
