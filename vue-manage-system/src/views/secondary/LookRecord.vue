<template>
	<div>
		<el-row>
			<el-form label-width="80px">
				<el-form-item label="手机号">
					<el-input placeholder="请输入手机号" v-model="phone" clearable></el-input>
				</el-form-item>
			</el-form>
			<el-col :span="2" :push="2">
				<el-button type="primary" size="medium" @click="findByUser()">查询</el-button>
			</el-col>
		</el-row>
		<el-row style="margin: 10px;">
			<el-button type="primary" size="medium" @click="dialogFormVisible = true">新增带看</el-button>
		</el-row>
		<el-table :data="lookData" style="width: 100%">
			<el-table-column type="selection"></el-table-column>
			<el-table-column prop="lookId" label="带看编号" width="180"> </el-table-column>
			<el-table-column prop="lookName" label="姓名"> </el-table-column>
			<el-table-column prop="lookPhone" label="手机号"> </el-table-column>
			<el-table-column prop="secondaryVillage" label="房源名称"> </el-table-column>
			<el-table-column prop="lookMake" label="预约时间" width="180"> </el-table-column>
			<el-table-column prop="lookEnd" label="完成时间" width="180"> </el-table-column>
			<el-table-column prop="lookState" label="看房状态"> </el-table-column>
			<el-table-column prop="address" label="操作">
				<template v-slot:default="r">
					<el-button type="primary" size="medium" @click="details(r.row)">查看详情</el-button>
				</template>
			</el-table-column>
		</el-table>

		<el-dialog title="新增带看" v-model="dialogFormVisible" width="50%">
			<el-form>
				<el-row>
					<el-col>
						<el-form-item label="预约时间">
							<el-date-picker type="date" v-model="lookRecord.lookMake" placeholder="选择日期">
							</el-date-picker>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col>
						<el-form-item label="结束时间">
							<el-date-picker type="date" v-model="lookRecord.lookEnd" placeholder="选择日期">
							</el-date-picker>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col>
						<el-form-item label="客户姓名">
							<el-input placeholder="请填写姓名" style="width: 400px;" v-model="lookRecord.lookName">
							</el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col>
						<el-form-item label="客户联系方式">
							<el-input placeholder="请填写联系方式" style="width: 400px;" v-model="lookRecord.lookPhone">
							</el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col>
						<el-form-item label="选择房源">
							<el-input v-if="false" v-model="lookRecord.secondaryNumber"></el-input>
							<el-button type="primary" size="medium" @click="findByUser()">选择房源</el-button>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col>
						<el-form-item label="带看记录">
							<el-input v-model="lookRecord.lookTitle" type="textarea" :rows="3"
								placeholder="请输入房屋的详细信息,不超过500字" style="width: 400px;">
							</el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col>
						<el-form-item label="带看图片">
							<el-upload class="upload-demo" ref="upload" action="" drag multiple :auto-upload="false"
								:on-change="handleFileUploaderChange">
								<i class="el-icon-upload"></i>
								<div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
							</el-upload>
						</el-form-item>
					</el-col>
				</el-row>
			</el-form>
			<template #footer>
				<span class="dialog-footer">
					<el-button @click="dialogFormVisible = false">取 消</el-button>
					<el-button type="primary" @click="dialogFormVisible = false,addLookRecord()">确 定</el-button>
				</span>
			</template>
		</el-dialog>
		<el-dialog title="房源" v-model="dialogTableVisible" width="80%">
			<el-table :data="secondaryData" style="width: 100%" @row-dblclick="addNumber">
				<el-table-column type="selection"></el-table-column>
				<el-table-column prop="secondaryId" label="序号"> </el-table-column>
				<el-table-column prop="secondaryNumber" label="房源编号" width="140"> </el-table-column>
				<el-table-column prop="secondaryTitle" label="出售标题" width="120"> </el-table-column>
				<el-table-column label="房源信息" width="450">
					<template v-slot:default="r">
						<el-row>
							<el-col :span="12">
								<img :src="r.row.secondaryPicture" width="200" height="100" />
							</el-col>
							<el-col :span="10">
								<span
									style="font-size:18px; font-weight: bold;">{{r.row.secondaryVillage+r.row.secondaryBuilding+r.row.secondaryUnit}}</span>
								<br />
								<span>{{r.row.secondaryModel+' '+r.row.secondaryToward+' '+r.row.secondaryType}}</span>
								<br />
								<span style="font-size:25px; color: red;">{{r.row.secondaryPrice}}万</span>
							</el-col>
						</el-row>
					</template>
				</el-table-column>
				<el-table-column prop="secondaryState" label="房源状态">
					<template v-slot:default="r">
						<el-tag type="success" v-if="r.row.secondaryState==0">上架</el-tag>
						<el-tag type="danger" v-if="r.row.secondaryState==1">下架</el-tag>
					</template>
				</el-table-column>
			</el-table>
			<el-pagination :current-page="pageNo" @current-change="findByUser" background
				layout="total,prev, pager, next,jumper" :page-size="size" :total="total">>
			</el-pagination>
		</el-dialog>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				pageNo: 1, //页码
				size: 5, //页大小
				total: 0, //总记录数
				dialogFormVisible: false, //新增弹框
				lookData: [], //带看记录表格
				phone: '', //手机号码
				lookRecord: {
					lookId: '', //序号
					lookMake: '', //预约时间
					lookEnd: '', //结束时间
					lookName: '', //客户姓名
					lookPhone: '', //客户联系方式
					secondaryNumber: '', //房源
					lookTitle: '', //带看记录
					lookPicture: '', //带看图片
					lookState: '', //带看状态
				},
				secondaryData: [], //二手房源表格
				secondary:{
					userId:'',
				},
				dialogTableVisible: false,
			}
		},
		methods: {
			//带看图片
			handleFileUploaderChange(file) {
				const self = this
				let reader = new FileReader()
				reader.readAsDataURL(file.raw)
				reader.onload = function() {
					let img_base64 = this.result
					console.log(img_base64)
					self.lookRecord.lookPicture = img_base64;
				}
				console.log(file)
				console.log(this.imgBase64Array)
			},
			//根据用户查询房源
			findByUser(no) {
				this.dialogTableVisible = true;
				this.secondary.userId = this.$store.state.token.userID;
				console.log(this.$store.state.token.userID)
				if (no == undefined) {
					no = this.pageNo
				}
				this.secondary.pageNo = no;
				this.secondary.size = this.size;
				console.log(this.secondary);
				this.axios.post('/Secondary/secondary-list', this.secondary).then((v) => {
					console.log(v.data.list)
					this.secondaryData = v.data.list;
					this.total = v.data.total;
				}).catch(function() {

				});
			},
			addNumber(row){
				console.log(row)
				this.lookRecord.secondaryNumber = row.secondaryNumber ;
				this.dialogTableVisible = false;
			},
			//新增带看记录
			addLookRecord(){
				console.log(this.lookRecord);
				//执行新增
				this.axios.post("/Secondary/add-look-record", this.lookRecord).then((res) => {
					if (res.data == 'ok') {
						this.$message.success("新增成功！");
						this.findAllLookRecord();
					} else {
						this.$message.error("新增失败！")
					}
				}).catch(() => {
					this.$message.error("新增失败！")
				})
			},
			//查询所有的带看记录
			findAllLookRecord(){
				this.axios.get('/Secondary/record-list').then((v) => {
					console.log(v.data)
					this.lookData = v.data;
				}).catch(function() {
				
				});
			},
		},
		created() {
			this.findAllLookRecord();
		}
	}
</script>

<style>
	.fangyuantupian .upload-demo,
	.fangyuantupian .el-upload {
		width: 362px !important;
		height: 182px !important;
	}
</style>
