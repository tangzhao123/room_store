<template>
	<div style="margin-top: 10px;margin-left: 20px;">
		<el-form :model="customers">
      客户录入
      <hr />
			<div style="margin-left: 30px;margin-top: 20px">
				<el-form-item label="客户等级" :label-width="formLabelWidth">
					<el-select placeholder="客户等级" v-model="customers.s" value-key="">

					</el-select>
				</el-form-item>
				<el-form-item label="租售意向" :label-width="formLabelWidth">
					<el-select placeholder="客户意向" v-model="customers.s" value-key="">

					</el-select>
				</el-form-item>
				<el-form-item label="客户来源" :label-width="formLabelWidth">
					<el-select placeholder="客户来源" v-model="customers.s" value-key="">

					</el-select>
				</el-form-item>
				<el-form-item label="客户状态" :label-width="formLabelWidth">
					<el-select placeholder="客户状态" v-model="customers.s" value-key="">

					</el-select>
				</el-form-item>
				<el-form-item label="客户称呼" :label-width="formLabelWidth">
					<el-input v-model="customers.s" placeholder="请输入客户称呼" clearable style="width:220px;" />
				</el-form-item>
				<el-form-item label="性别" :label-width="formLabelWidth">
					<el-radio-group v-model="customers.s">
						<el-radio label="男">男</el-radio>
						<el-radio label="女">女</el-radio>
						<el-radio label="未知">未知</el-radio>
					</el-radio-group>
				</el-form-item>
				<el-form-item label="联系电话" :label-width="formLabelWidth">
					<el-input v-model="customers.s" placeholder="请输入联系电话" clearable style="width:220px;" />
				</el-form-item>
				<el-form-item label="备用电话" :label-width="formLabelWidth">
					<el-input v-model="customers.s" placeholder="请输入备用电话" clearable style="width:220px;" />
				</el-form-item>
				<el-form-item label="备注" :label-width="formLabelWidth">
					<el-input v-model="customers.s" placeholder="请输入备注" :rows="3" type="textarea" clearable
						style="width:520px;" />
				</el-form-item>
			</div>
      需求意向
      <hr />
      <div style="margin-left: 30px;margin-top: 20px">
        <el-form-item label="意向区域" :label-width="formLabelWidth">
          <el-input v-model="customers.s" placeholder="请输入意向区域" clearable style="width:220px;" />
        </el-form-item>
        <el-form-item label="小区名称" :label-width="formLabelWidth">
          <el-input v-model="customers.s" placeholder="请输入小区名称" clearable style="width:220px;" />
        </el-form-item>
        <el-form-item label="户型" :label-width="formLabelWidth">
          <el-checkbox-group v-model="customers.p" style="margin-left: 40px;">
            <el-checkbox label="Option A" />
            <el-checkbox label="Option B" />
            <el-checkbox label="Option C" />
            <el-checkbox label="disabled" />
            <el-checkbox label="selected and disabled" />
          </el-checkbox-group>
        </el-form-item>
        <el-form-item label="价格" :label-width="formLabelWidth">
          <el-input v-model="customers.s" placeholder="请输入金额" clearable style="width:220px;" />
          -
          <el-input v-model="customers.s" placeholder="请输入金额" clearable style="width:220px;" />
          万
        </el-form-item>
        <el-form-item label="面积" :label-width="formLabelWidth">
          <el-input v-model="customers.s" placeholder="请输入面积" clearable style="width:220px;" />
          -
          <el-input v-model="customers.s" placeholder="请输入面积" clearable style="width:220px;" />
          m²
        </el-form-item>
        <el-form-item label="房屋用途" :label-width="formLabelWidth">
          <el-checkbox-group v-model="customers.p" style="margin-left: 40px;">
            <el-checkbox label="Option A" />
            <el-checkbox label="Option B" />
            <el-checkbox label="Option C" />
            <el-checkbox label="disabled" />
            <el-checkbox label="selected and disabled" />
          </el-checkbox-group>
        </el-form-item>
        <el-form-item label="装修类型" :label-width="formLabelWidth">
          <el-checkbox-group v-model="customers.p" style="margin-left: 40px;">
            <el-checkbox label="Option A" />
            <el-checkbox label="Option B" />
            <el-checkbox label="Option C" />
            <el-checkbox label="disabled" />
            <el-checkbox label="selected and disabled" />
          </el-checkbox-group>
        </el-form-item>
        <el-form-item label="楼层" :label-width="formLabelWidth">
          <el-checkbox-group v-model="customers.p" style="margin-left: 40px;">
            <el-checkbox label="Option A" />
            <el-checkbox label="Option B" />
            <el-checkbox label="Option C" />
            <el-checkbox label="disabled" />
            <el-checkbox label="selected and disabled" />
          </el-checkbox-group>
        </el-form-item>
        <el-form-item>
          <el-button type="primary">确定</el-button>
          <el-button>取消</el-button>
        </el-form-item>
      </div>
		</el-form>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				formLabelWidth: '75px', //label宽度
				customers: {
					s: '',
          p:[]
				},
			}
		},
	}
</script>

<style scoped>

</style>
