<template>
	<div>
		<div style="border-bottom: 2px solid #D9D9D9; padding: 20px;">
			<el-row style="padding-left: 100px;">
				<el-col :span="8" style="color: #00A854;">
					基本信息
				</el-col>
				<el-col :span="8">
					更多信息
				</el-col>
				<el-col :span="8">
					房源图片
				</el-col>
			</el-row>
		</div>
		<el-row>
			<!-- 基本信息填写的Div -->
			<div style="padding: 20px;" > 
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="城市/区域">
							<el-col style="padding-left: 5px;">
								<el-select v-model="value" placeholder="请选择">
									<el-option v-for="item in options" :key="item.value" :label="item.label"
										:value="item.value">
									</el-option>
								</el-select>
							</el-col>
							<el-col style="padding-left: 5px;">
								<el-select v-model="value" placeholder="请选择">
									<el-option v-for="item in options" :key="item.value" :label="item.label"
										:value="item.value">
									</el-option>
								</el-select>
							</el-col>
							<el-col style="padding-left: 5px;">
								<el-select v-model="value" placeholder="请选择">
									<el-option v-for="item in options" :key="item.value" :label="item.label"
										:value="item.value">
									</el-option>
								</el-select>
							</el-col>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="小区名称">
							<el-col style="padding-left: 5px;">
								<el-input v-model="input" placeholder="请输入内容" style="width: 660px;"></el-input>
							</el-col>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form label-width="80px">
							<el-form-item label="总楼层">
								<el-select v-model="value" placeholder="请选择" style="padding-left: 5px;">
									<el-option v-for="item in options" :key="item.value" :label="item.label"
										:value="item.value">
									</el-option>
								</el-select>
							</el-form-item>
						</el-form>
					</el-col>
					<el-col :span="10">
						<el-form label-width="80px">
							<el-form-item label="所在层">
								<el-select v-model="value" placeholder="请选择" style="padding-left: 5px;">
									<el-option v-for="item in options" :key="item.value" :label="item.label"
										:value="item.value">
									</el-option>
								</el-select>
							</el-form-item>
						</el-form>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form label-width="80px">
							<el-form-item label="楼栋">
								<el-select v-model="value" placeholder="请选择" style="padding-left: 5px;">
									<el-option v-for="item in options" :key="item.value" :label="item.label"
										:value="item.value">
									</el-option>
								</el-select>
							</el-form-item>
						</el-form>
					</el-col>
					<el-col :span="10">
						<el-form label-width="80px">
							<el-form-item label="单元">
								<el-select v-model="value" placeholder="请选择" style="padding-left: 5px;">
									<el-option v-for="item in options" :key="item.value" :label="item.label"
										:value="item.value">
									</el-option>
								</el-select>
							</el-form-item>
						</el-form>
					</el-col>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="房号">
							<el-col style="padding-left: 5px;">
								<el-input v-model="input" placeholder="请输入内容" style="width: 660px;"></el-input>
							</el-col>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form label-width="80px">
							<el-form-item label="建筑面积">
								<el-input v-model="input" placeholder="请输入内容" style="padding-left: 5px;"></el-input>
							</el-form-item>
						</el-form>
					</el-col>
					<el-col :span="10">
						<el-form label-width="80px">
							<el-form-item label="套内面积" style="padding-left: 15px;">
								<el-input v-model="input" placeholder="请输入内容"></el-input>
							</el-form-item>
						</el-form>
					</el-col>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="户型">
							<el-col style="padding-left: 5px;">
								<el-select v-model="value" placeholder="请选择">
									<el-option v-for="item in options" :key="item.value" :label="item.label"
										:value="item.value">
									</el-option>
								</el-select>
							</el-col>
							<el-col style="padding-left: 5px;">
								<el-select v-model="value" placeholder="请选择">
									<el-option v-for="item in options" :key="item.value" :label="item.label"
										:value="item.value">
									</el-option>
								</el-select>
							</el-col>
							<el-col style="padding-left: 5px;">
								<el-select v-model="value" placeholder="请选择">
									<el-option v-for="item in options" :key="item.value" :label="item.label"
										:value="item.value">
									</el-option>
								</el-select>
							</el-col>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form label-width="80px">
							<el-form-item label="朝向">
								<el-input v-model="input" placeholder="请输入内容" style="padding-left: 5px;"></el-input>
							</el-form-item>
						</el-form>
					</el-col>
					<el-col :span="10">
						<el-form label-width="80px">
							<el-form-item label="建筑年代" style="padding-left: 15px;">
								<el-input v-model="input" placeholder="请输入内容"></el-input>
							</el-form-item>
						</el-form>
					</el-col>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="房屋用途">
							<el-radio label="1">居住</el-radio>
							<el-radio label="1">工业</el-radio>
							<el-radio label="1">商业</el-radio>
							<el-radio label="1">办公</el-radio>
							<el-radio label="1">文体娱乐</el-radio>
							<el-radio label="1">其他</el-radio>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="梯户比例">
							<el-col style="padding-left: 5px;">
								<el-select v-model="value" placeholder="请选择">
									<el-option v-for="item in options" :key="item.value" :label="item.label"
										:value="item.value">
									</el-option>
								</el-select>
							</el-col>
							<el-col style="padding-left: 5px;">
								<el-select v-model="value" placeholder="请选择">
									<el-option v-for="item in options" :key="item.value" :label="item.label"
										:value="item.value">
									</el-option>
								</el-select>
							</el-col>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="电梯">
							<el-radio label="1">有</el-radio>
							<el-radio label="1">无</el-radio>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form>
						<el-form-item label="请上传不动产权证">
							<el-col :span="6">
								<el-upload class="avatar-uploader" action="https://jsonplaceholder.typicode.com/posts/"
									:show-file-list="false" :on-success="handleAvatarSuccess"
									:before-upload="beforeAvatarUpload">
									<img v-if="imageUrl" :src="imageUrl" class="avatar" />
									<i v-else class="el-icon-plus avatar-uploader-icon"></i>
								</el-upload>
								封面照片
							</el-col>
							<el-col :span="6" :push="3">
								<el-upload class="avatar-uploader" action="https://jsonplaceholder.typicode.com/posts/"
									:show-file-list="false" :on-success="handleAvatarSuccess"
									:before-upload="beforeAvatarUpload">
									<img v-if="imageUrl" :src="imageUrl" class="avatar" />
									<i v-else class="el-icon-plus avatar-uploader-icon"></i>
								</el-upload>
								封底照片
							</el-col>
							<!-- <el-col :span="6" :push="">
								<el-upload class="avatar-uploader" action="https://jsonplaceholder.typicode.com/posts/"
									:show-file-list="false" :on-success="handleAvatarSuccess"
									:before-upload="beforeAvatarUpload">
									<img v-if="imageUrl" :src="imageUrl" class="avatar" />
									<i v-else class="el-icon-plus avatar-uploader-icon"></i>
								</el-upload>
								权属页照片
							</el-col> -->
							<el-col :span="6" :push="6">
								<el-upload class="avatar-uploader" action="https://jsonplaceholder.typicode.com/posts/"
									:show-file-list="false" :on-success="handleAvatarSuccess"
									:before-upload="beforeAvatarUpload">
									<img v-if="imageUrl" :src="imageUrl" class="avatar" />
									<i v-else class="el-icon-plus avatar-uploader-icon"></i>
								</el-upload>
								户型照片
							</el-col>
						</el-form-item>
						
					</el-form>
				</el-row>
				<el-row>
					<el-form>
						<el-form-item label="请上传委托协议">
							<el-col :span="6">
								<el-upload class="avatar-uploader" action="https://jsonplaceholder.typicode.com/posts/"
									:show-file-list="false" :on-success="handleAvatarSuccess"
									:before-upload="beforeAvatarUpload">
									<img v-if="imageUrl" :src="imageUrl" class="avatar" />
									<i v-else class="el-icon-plus avatar-uploader-icon"></i>
								</el-upload>
							</el-col>
						</el-form-item>
						
					</el-form>
				</el-row>
				<el-row>
					<el-col :push="15">
						<el-button type="primary" size="medium">下一步</el-button>
					</el-col>
				</el-row>
			</div>
			<!-- 更多信息填写的Div -->
			<div style="padding: 20px; display: none;" >
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="出售标题">
							<el-col style="padding-left: 5px;">
								<el-input v-model="input" placeholder="请输入内容" style="width: 660px;"></el-input>
							</el-col>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="价格">
							<el-col style="padding-left: 5px;">
								<el-input v-model="input" placeholder="请填写期望售价(万元)"></el-input>
							</el-col>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="装修类型">
							<el-radio label="1">毛胚</el-radio>
							<el-radio label="1">简装</el-radio>
							<el-radio label="1">精装</el-radio>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="110px">
						<el-form-item label="房屋获取渠道">
							<el-radio label="1">线上</el-radio>
							<el-radio label="1">线下</el-radio>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="房屋标签">
							<el-checkbox v-model="value" label="南北通透"></el-checkbox>
							<el-checkbox v-model="value" label="户型方正"></el-checkbox>
							<el-checkbox v-model="value" label="满五唯一"></el-checkbox>
							<el-checkbox v-model="value" label="满两年"></el-checkbox>
							<el-checkbox v-model="value" label="近地铁"></el-checkbox>
							<el-checkbox v-model="value" label="近学区"></el-checkbox>
							<el-checkbox v-model="value" label="随时看房"></el-checkbox>
							<el-checkbox v-model="value" label="独家房源"></el-checkbox>
							<el-checkbox v-model="value" label="不限购"></el-checkbox>
						</el-form-item>
					</el-form>
				</el-row>
				
				<el-row style="font-size: 16px ; font-weight:bold ">
					<div style="border-bottom: 2px solid #CCCCCC; width: 1240px; padding: 10px;">
						产权信息
					</div>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="权力性质">
							<el-radio label="1">划拨</el-radio>
							<el-radio label="1">出让</el-radio>
							<el-radio label="1">其他</el-radio>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="产权年限">
							<el-radio label="1">40年</el-radio>
							<el-radio label="1">50年</el-radio>
							<el-radio label="1">70年</el-radio>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="购买年限">
							<el-radio label="1">不满两年</el-radio>
							<el-radio label="1">满两年</el-radio>
							<el-radio label="1">满五年</el-radio>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="权力性质">
							<el-radio label="1">不唯一</el-radio>
							<el-radio label="1">唯一</el-radio>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row style="font-size: 16px ; font-weight:bold ">
					<div style="border-bottom: 2px solid #CCCCCC; width: 1240px; padding: 10px;">
						房源介绍
					</div>
				</el-row>
				<el-row style="padding: 10px;">
					<el-form label-width="80px">
						<el-form-item label="房屋介绍">
							<el-input v-model="input" type="textarea" :rows="3" placeholder="请输入房屋的详细信息,不超过500字" style="width: 800px;"></el-input>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row style="padding: 10px;">
					<el-form label-width="80px">
						<el-form-item label="小区介绍">
							<el-input v-model="input" type="textarea" :rows="3" placeholder="请输入房屋的详细信息,不超过500字" style="width: 800px;"></el-input>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row style="padding: 10px;">
					<el-form label-width="80px">
						<el-form-item label="附近学习">
							<el-input v-model="input" type="textarea" :rows="3" placeholder="请输入房屋的详细信息,不超过500字" style="width: 800px;"></el-input>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row style="padding: 10px;">
					<el-form label-width="80px">
						<el-form-item label="房源优势">
							<el-input v-model="input" type="textarea" :rows="3" placeholder="请输入房屋的详细信息,不超过500字" style="width: 800px;"></el-input>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row style="padding: 10px;">
					<el-form label-width="80px">
						<el-form-item label="业主心态">
							<el-input v-model="input" type="textarea" :rows="3" placeholder="请输入房屋的详细信息,不超过500字" style="width: 800px;"></el-input>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-col :push="15">
						<el-button type="primary" size="medium">上一步</el-button>
						<el-button type="primary" size="medium">下一步</el-button>
					</el-col>
				</el-row>
			</div>
			<div style="padding: 10px; display: none;">
				<el-row style="font-size: 16px ; font-weight:bold ">
					<div style="border-bottom: 2px solid #CCCCCC; width: 1240px; padding: 10px;">
						请上传房源图片
					</div>
				</el-row>
				<el-row style="padding: 10px;">
					<el-col :span="6" :push="6">
						<el-upload class="avatar-uploader" action="https://jsonplaceholder.typicode.com/posts/"
							:show-file-list="false" :on-success="handleAvatarSuccess"
							:before-upload="beforeAvatarUpload">
							<img v-if="imageUrl" :src="imageUrl" class="avatar" />
							<i v-else class="el-icon-plus avatar-uploader-icon"></i>
						</el-upload>
					</el-col>
				</el-row>
				<el-row>
					<el-col :push="10">
						<el-button type="primary" size="medium">上一步</el-button>
						<el-button type="primary" size="medium">保存</el-button>
					</el-col>
				</el-row>
			</div>
			
		</el-row>
		
	</div>
</template>

<script>
	export default {
		data() {
			return {
				options: [{
						value: '选项1',
						label: '黄金糕',
					},
					{
						value: '选项2',
						label: '双皮奶',
					},
					{
						value: '选项3',
						label: '蚵仔煎',
					},
					{
						value: '选项4',
						label: '龙须面',
					},
					{
						value: '选项5',
						label: '北京烤鸭',
					},
				],
				value: '',
				imageUrl: '',
			}
		},
		methods: {
			handleAvatarSuccess(res, file) {
				this.imageUrl = URL.createObjectURL(file.raw)
			},
			beforeAvatarUpload(file) {
				const isJPG = file.type === 'image/jpeg'
				const isLt2M = file.size / 1024 / 1024 < 2

				if (!isJPG) {
					this.$message.error('上传头像图片只能是 JPG 格式!')
				}
				if (!isLt2M) {
					this.$message.error('上传头像图片大小不能超过 2MB!')
				}
				return isJPG && isLt2M
			},
		},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409eff;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}
	.el-upload--text{
		width: 166px;
		height: 150px;
	}
</style>
