<template>
	<div>
		<div style="border-bottom: 2px solid #D9D9D9; padding: 20px;">
			<el-row style="padding-left: 100px;">
				<el-col :span="8" v-bind:class="{ 'active': isActive }">
					基本信息
				</el-col>
				<el-col :span="8" v-bind:class="{ 'more': isMore }">
					出租信息
				</el-col>
				<el-col :span="8" v-bind:class="{ 'picture': isPicture }">
					房源图片
				</el-col>
			</el-row>
		</div>
		<el-row>
			<!-- 基本信息填写的Div -->
			<div style="padding: 20px;" v-if="flag">
				<el-input v-model="rentalhousing.rehoNo" type="hidden"></el-input>
				<el-input v-model="rentalhousing.rehoNumber" style="display:none;"></el-input>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="区">
							<el-col style="padding-left: 5px;">
								<el-select v-model="quid" placeholder="请选择区" @change="getUptown()">
									<el-option v-for="item in qu" :key="item.countyId" :label="item.countyName"
										:value="item.countyId">
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
								<el-select v-model="xquid" placeholder="请选择小区" @change="getDizi()">
									<el-option v-for="item in xqu" :key="item.uptownId" :label="item.uptownName"
										:value="item.uptownName">
									</el-option>
								</el-select>
							</el-col>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form label-width="80px">
							<el-form-item label="单元">
								<el-select v-model="rentalhousing.rehoUnit" placeholder="请选择单元" style="padding-left: 5px;">
									<el-option value="1单元">1单元</el-option>
									<el-option value="2单元">2单元</el-option>
									<el-option value="3单元">3单元</el-option>
									<el-option value="4单元">4单元</el-option>
									<el-option value="5单元">5单元</el-option>
									<el-option value="6单元">6单元</el-option>
									<el-option value="7单元">7单元</el-option>
									<el-option value="8单元">8单元</el-option>
									<el-option value="9单元">9单元</el-option>
									<el-option value="10单元">10单元</el-option>
								</el-select>
							</el-form-item>
						</el-form>
					</el-col>
					
					<el-col :span="10">
						<el-form label-width="80px">
							<el-form-item label="楼栋">
								<el-select v-model="rentalhousing.rehoBuilding" placeholder="请选择楼栋" style="padding-left: 5px;">
									<el-option value="1栋">1栋</el-option>
									<el-option value="2栋">2栋</el-option>
									<el-option value="3栋">3栋</el-option>
									<el-option value="4栋">4栋</el-option>
									<el-option value="5栋">5栋</el-option>
									<el-option value="6栋">6栋</el-option>
									<el-option value="7栋">7栋</el-option>
									<el-option value="8栋">8栋</el-option>
									<el-option value="9栋">9栋</el-option>
									<el-option value="10栋">10栋</el-option>
								</el-select>
							</el-form-item>
						</el-form>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form label-width="80px">
							<el-form-item label="总楼层">
								<el-select v-model="rentalhousing.rehoFloornumber" placeholder="请选择楼层" style="padding-left: 5px;">
									<el-option value="1层">1层</el-option>
									<el-option value="2层">2层</el-option>
									<el-option value="3层">3层</el-option>
									<el-option value="4层">4层</el-option>
									<el-option value="5层">5层</el-option>
									<el-option value="6层">6层</el-option>
									<el-option value="7层">7层</el-option>
									<el-option value="8层">8层</el-option>
									<el-option value="9层">9层</el-option>
									<el-option value="10层">10层</el-option>
								</el-select>
							</el-form-item>
						</el-form>
					</el-col>
					<el-col :span="10">
						<el-form label-width="80px">
							<el-form-item label="所在层">
								<el-select v-model="rentalhousing.rehoLivefewfloor" placeholder="请选择层" style="padding-left: 5px;">
									<el-option value="1层">1层</el-option>
									<el-option value="2层">2层</el-option>
									<el-option value="3层">3层</el-option>
									<el-option value="4层">4层</el-option>
									<el-option value="5层">5层</el-option>
									<el-option value="6层">6层</el-option>
									<el-option value="7层">7层</el-option>
									<el-option value="8层">8层</el-option>
									<el-option value="9层9">9层</el-option>
									<el-option value="10层">10层</el-option>
								</el-select>
							</el-form-item>
						</el-form>
					</el-col>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="房号">
							<el-col style="padding-left: 5px;">
								<el-input v-model="rentalhousing.rehoRoomnumber" placeholder="请输入内容" style="width: 660px;"></el-input>
							</el-col>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form label-width="80px">
							<el-form-item label="建筑面积">
								<el-input v-model="rentalhousing.rehoCoveredarea" placeholder="请输入内容" style="padding-left: 5px;"></el-input>
							</el-form-item>
						</el-form>
					</el-col>
					<el-col :span="2">
						<el-form label-width="35px">
							<el-form-item label="㎡">
							</el-form-item>
						</el-form>
					</el-col>
					<el-col :span="10">
						<el-form label-width="80px">
							<el-form-item label="套内面积" style="padding-left: 15px;">
								<el-input v-model="rentalhousing.rehoInsidespace" placeholder="请输入内容"></el-input>
							</el-form-item>
						</el-form>
					</el-col>
					<el-col :span="2">
						<el-form label-width="30px">
							<el-form-item label="㎡">
							</el-form-item>
						</el-form>
					</el-col>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="户型">
							<el-col style="padding-left: 5px;">
								<el-select v-model="woshi" placeholder="请选择室" @change="chanRehoHousetype()">
									<el-option value="1室">1室</el-option>
									<el-option value="2室">2室</el-option>
									<el-option value="3室">3室</el-option>
									<el-option value="4室">4室</el-option>
									<el-option value="5室">5室</el-option>
									<el-option value="6室">6室</el-option>
									<el-option value="7室">7室</el-option>
									<el-option value="8室">8室</el-option>
									<el-option value="9室">9室</el-option>
									<el-option value="10室">10室</el-option>
								</el-select>
							</el-col>
							<el-col style="padding-left: 5px;">
								<el-select v-model="dating" placeholder="请选择厅" @change="chanRehoHousetype()">
									<el-option value="1厅">1厅</el-option>
									<el-option value="2厅">2厅</el-option>
									<el-option value="3厅">3厅</el-option>
									<el-option value="4厅">4厅</el-option>
									<el-option value="5厅">5厅</el-option>
									<el-option value="6厅">6厅</el-option>
									<el-option value="7厅">7厅</el-option>
									<el-option value="8厅">8厅</el-option>
									<el-option value="9厅">9厅</el-option>
									<el-option value="10厅">10厅</el-option>
								</el-select>
							</el-col>
							<el-col style="padding-left: 5px;">
								<el-select v-model="wei" placeholder="请选择卫" @change="chanRehoHousetype()">
									<el-option value="1卫">1卫</el-option>
									<el-option value="2卫">2卫</el-option>
									<el-option value="3卫">3卫</el-option>
									<el-option value="4卫">4卫</el-option>
									<el-option value="5卫">5卫</el-option>
									<el-option value="6卫">6卫</el-option>
									<el-option value="7卫">7卫</el-option>
									<el-option value="8卫">8卫</el-option>
									<el-option value="9卫">9卫</el-option>
									<el-option value="10卫">10卫</el-option>
								</el-select>
							</el-col>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="朝向">
							<el-col style="padding-left: 5px;">
								<el-select v-model="rentalhousing.rehoOrientation" placeholder="请选择">
									<el-option value="东">东</el-option>
									<el-option value="南">南</el-option>
									<el-option value="西">西</el-option>
									<el-option value="北">北</el-option>
									<el-option value="东西">东西</el-option>
									<el-option value="南北">南北</el-option>
									<el-option value="东南">东南</el-option>
									<el-option value="东北">东北</el-option>
									<el-option value="西南">西南</el-option>
									<el-option value="西北">西北</el-option>
								</el-select>
							</el-col>
							<el-col>
								<el-form label-width="80px">
									<el-form-item label="电梯" v-model="rentalhousing.rehoElevator">
										<el-radio v-model="rentalhousing.rehoElevator" label="有">有</el-radio>
										<el-radio v-model="rentalhousing.rehoElevator" label="无">无</el-radio>
									</el-form-item>	
								</el-form>
							</el-col>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="房屋类型" v-model="rentalhousing.rehoHousingtypes">
							<el-radio v-model="rentalhousing.rehoHousingtypes" label="住宅">住宅</el-radio>
							<el-radio v-model="rentalhousing.rehoHousingtypes" label="复式">复式</el-radio>
							<el-radio v-model="rentalhousing.rehoHousingtypes" label="商铺">商铺</el-radio>
							<el-radio v-model="rentalhousing.rehoHousingtypes" label="公寓">公寓</el-radio>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="梯户比例">
							<el-col style="padding-left: 5px;">
								<el-select v-model="rentalhousing.rehoLadder" placeholder="请选择梯">
									<el-option value="1梯">1梯</el-option>
									<el-option value="2梯">2梯</el-option>
									<el-option value="3梯">3梯</el-option>
									<el-option value="4梯">4梯</el-option>
								</el-select>
							</el-col>
							<el-col style="padding-left: 5px;">
								<el-select v-model="rentalhousing.rehoHouseholds" placeholder="请选择户">
									<el-option value="1户">1户</el-option>
									<el-option value="2户">2户</el-option>
									<el-option value="3户">3户</el-option>
									<el-option value="4户">4户</el-option>
									<el-option value="5户">5户</el-option>
									<el-option value="6户">6户</el-option>
									<el-option value="7户">7户</el-option>
									<el-option value="8户">8户</el-option>
									<el-option value="9户">9户</el-option>
									<el-option value="10户">10户</el-option>
								</el-select>
							</el-col>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form>
						<el-form-item label="请上传不动产权证">
							<el-col :span="16" style="margin-right: 50px;" class="fangyuantupian">
								<el-upload class="upload-demo" ref="upload" action="" drag multiple :auto-upload="false"
									:on-change="handleFileUploaderCoverPhoto">
									<i class="el-icon-upload"></i>
									<div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
								</el-upload>
								请上传封面照片
							</el-col>
							<el-col :span="6" class="fangyuantupian">
								<el-upload class="upload-demo" ref="upload" action="" drag multiple :auto-upload="false"
									:on-change="handleFileUploaderBackPhoto">
									<i class="el-icon-upload"></i>
									<div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
								</el-upload>
								请上传封底照片
							</el-col>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form>
						<el-form-item label="">
							<el-col :span="16" style="margin-right: 50px; margin-left: 125px;" class="fangyuantupian">
								<el-upload class="upload-demo" ref="upload" action="" drag multiple :auto-upload="false"
									:on-change="handleFileUploaderPagePhoto">
									<i class="el-icon-upload"></i>
									<div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
								</el-upload>
								请上传权属页照片
							</el-col>
							<el-col :span="6" class="fangyuantupian">
								<el-upload class="upload-demo" ref="upload" action="" drag multiple :auto-upload="false"
									:on-change="handleFileUploaderDoorPhoto">
									<i class="el-icon-upload"></i>
									<div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
								</el-upload>
								请上传户型照片
							</el-col>
						</el-form-item>
					</el-form>
				</el-row>

				<el-row>
					<el-form>
						<el-form-item label="请上传委托协议" class="labelss">
							<el-col :span="6" class="fangyuantupian">
								<el-upload class="upload-demo" ref="upload" action="" drag multiple :auto-upload="false"
									:on-change="handleFileUploaderEntrust">
									<i class="el-icon-upload"></i>
									<div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
								</el-upload>
							</el-col>
						</el-form-item>

					</el-form>
				</el-row>

				<el-row>
					<el-col :push="15">
						<el-button type="primary" size="medium" @click="showMore()">下一步</el-button>
					</el-col>
				</el-row>
			</div>
			<!-- 更多信息填写的Div -->
			<div style="padding: 20px;"  v-if="flag1">
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="出售标题">
							<el-col style="padding-left: 5px;">
								<el-input v-model="rentalhousing.rehoRentouttitle" placeholder="请输入您的房屋出租标题" style="width: 660px;"></el-input>
							</el-col>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-col style="padding-left: 5px;" :span="6">
						<el-form label-width="80px">
							<el-form-item label="价格">
									<el-input v-model="rentalhousing.rehoRent" placeholder="请填写期望租金"></el-input>
							</el-form-item>
						</el-form>
					</el-col>
					<el-col :span="2">
						<el-form label-width="50px">
							<el-form-item label="元/月">
							</el-form-item>
						</el-form>
					</el-col>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="支付方式">
							<el-col span="2">
								<el-radio v-model="rentalhousing.rehoPayway" label="押一付一"></el-radio>
								<el-radio v-model="rentalhousing.rehoPayway" label="押一付二"></el-radio>
								<el-radio v-model="rentalhousing.rehoPayway" label="押一付三"></el-radio>
								<el-radio v-model="rentalhousing.rehoPayway" label="押二付一"></el-radio>
								<el-radio v-model="rentalhousing.rehoPayway" label="半年付"></el-radio>
								<el-radio v-model="rentalhousing.rehoPayway" label="年付"></el-radio>
								<el-radio v-model="rentalhousing.rehoPayway" label="面谈"></el-radio>
							</el-col>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="装修类型">
							<el-radio v-model="rentalhousing.rehoFitmenttype" label="毛坯房">毛坯房</el-radio>
							<el-radio v-model="rentalhousing.rehoFitmenttype" label="普通装修">普通装修</el-radio>
							<el-radio v-model="rentalhousing.rehoFitmenttype" label="精装修">精装修</el-radio>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="最短租期">
							<el-radio v-model="rentalhousing.rehoShortestlease" label="1个月">1个月</el-radio>
							<el-radio v-model="rentalhousing.rehoShortestlease" label="3个月">3个月</el-radio>
							<el-radio v-model="rentalhousing.rehoShortestlease" label="半年">半年</el-radio>
							<el-radio v-model="rentalhousing.rehoShortestlease" label="一年">一年</el-radio>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="188px">
						<el-form-item label="配套设施（最少选1个）：">
							<el-checkbox-group v-model="rehoSuppfacility">
								<el-checkbox label="电视"></el-checkbox>
								<el-checkbox label="床"></el-checkbox>
								<el-checkbox label="衣柜"></el-checkbox>
								<el-checkbox label="洗衣机"></el-checkbox>
								<el-checkbox label="热水器"></el-checkbox>
								<el-checkbox label="空调"></el-checkbox>
								<el-checkbox label="WiFi"></el-checkbox>
								<el-checkbox label="天然气"></el-checkbox>
								<el-checkbox label="暖气"></el-checkbox>
								<el-checkbox label="阳台"></el-checkbox>
								<el-checkbox label="冰箱"></el-checkbox>
								<el-checkbox label="厨房"></el-checkbox>
								<el-checkbox label="独立卫生间"></el-checkbox>
								<el-checkbox label="地毯"></el-checkbox>
							</el-checkbox-group>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="168px">
						<el-form-item label="房屋标签（最多4个）:">
							<el-checkbox-group v-model="rehoHouslabel" :max="4">
								<el-checkbox label="临近地铁"></el-checkbox>
								<el-checkbox label="停车场"></el-checkbox>
								<el-checkbox label="南北通透"></el-checkbox>
								<el-checkbox label="出行方便"></el-checkbox>
								<el-checkbox label="家电齐全"></el-checkbox>
								<el-checkbox label="拎包入住"></el-checkbox>
								<el-checkbox label="随时起租"></el-checkbox>
								<el-checkbox label="采光十足"></el-checkbox>
							</el-checkbox-group>
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
						<el-form-item label="房源介绍">
							<el-input v-model="rentalhousing.rehoHousremark" type="textarea" :rows="3" placeholder="请输入房源的详细信息,不超过500字" style="width: 800px;"></el-input>
						</el-form-item>
					</el-form>
				</el-row>
				
				<el-row>
					<el-col :push="15">
						<el-button type="primary" size="medium" @click="showBasic()">上一步</el-button>
						<el-button type="primary" size="medium" @click="showHousing()">下一步</el-button>
					</el-col>
				</el-row>
			</div>
			<div style="padding: 10px;" v-if="flag2">
				<el-row style="font-size: 16px ; font-weight:bold ">
					<div style="border-bottom: 2px solid #CCCCCC; width: 1240px; padding: 10px;">
						请上传房源图片
					</div>
				</el-row>
				<el-row style="padding: 10px;" class="fangyuantupian">
					<el-upload class="upload-demo" ref="upload" action="" drag multiple :auto-upload="false"
						:on-change="handleFileUploaderChange">
						<i class="el-icon-upload"></i>
						<div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
					</el-upload>
				</el-row>
				
				<el-row>
					<el-col :push="10">
						<el-button type="primary" size="medium" @click="showMores()">上一步</el-button>
						<el-button type="primary" size="medium" @click="baocun()">保存</el-button>
					</el-col>
				</el-row>
			</div>
			
		</el-row>
		
	</div>
</template>

<script>

import { ElMessage } from 'element-plus'
	export default {
		data() {
			return {

				isActive: true, //基本信息样式
				isMore: false, //更多信息样式
				isPicture: false, //房源图片样式
				flag: true, //基本信息Div显示隐藏
				flag1: false, //更多信息Div显示隐藏
				flag2: false, //房源图片Div显示隐藏

				rentalhousing:{
					rehoNo:"",//编号
					rehoNumber:"",//租房房源编号(生成)
					rehoSite:"",//城市/区域(省、市、区)
					rehoCommunity:"",//小区名称
					rehoUnit:"",//单元
					rehoBuilding:"",//楼栋
					rehoFloornumber:"",//总楼层
					rehoLivefewfloor:"",//所在层
					rehoRoomnumber:"",//序号(房间号)
					rehoCoveredarea:"",//建筑面积
					rehoInsidespace:"",//套内面积(不能大于建筑面积)
					rehoHousetype:"",//户型(几室、几厅、几卫)
					rehoOrientation:"",//朝向
					rehoElevator:"",//电梯(有、无)
					rehoHousingtypes:"",//房屋类型(住宅、复式、公寓、商铺、写字楼)
					rehoLadder:"",//梯(梯户比例)
					rehoHouseholds:"",//户
					rehoCertcateCover:"",//不动产权证封面
					rehoCertcateBackcover:"",//不动产权证封底
					rehoCertcateQsy:"",//不动产权证权属页
					rehoCertcateFamilypage:"",//不动产权证户型页
					rehoZhutu:"",//主图
					rehoWeito:"",//委托
					rehoRentouttitle:"",//出租标题
					rehoRent:"",//租金
					rehoPayway:"",//付款方式
					rehoFitmenttype:"",//装修类型
					rehoShortestlease:"",//最短租期
					rehoSuppfacility:"",//配套设施
					rehoHouslabel:"",//房源标签
					rehoHousremark:"",//房源介绍
					rehoUsersNo:"",//用户编号
				},
				woshi:"",
				dating:"",
				wei:"",
				quid:"",//区
				quname:"",
				qu:[],
				xqu:[],//xiao区数据
				xquid:"",//区
				rehoSuppfacility:[],
				rehoHouslabel:[],

				value: '',
				imageUrl: '',
			}
		},
		methods: {
			baocun(){
				//判断是否有房源图
				this.rentalhousing.rehoRoomnumber = this.rentalhousing.rehoRoomnumber+"号";
				var use = this.$store.state.token;
				this.rentalhousing.rehoUsersNo = use.userID;
				var number = "ZF"+Date.parse(new Date());
				this.rentalhousing.rehoNumber = number;
				this.rentalhousing.rehoSite = use.userProvince+","+use.userCity+","+this.quname;

				var a = "";
				this.rehoSuppfacility.forEach((v)=>{
					a += v+",";
				});
				if(a.length > 0){
					a = a.substr(0,a.length-1)
					this.rentalhousing.rehoSuppfacility = a;
				}
				
				var b = "";
				this.rehoHouslabel.forEach((v)=>{
					b += v+",";
				});
				if(b.length > 0){
					b = b.substr(0,b.length-1);
					this.rentalhousing.rehoHouslabel = b;
					
				}

				// 新增房源
				this.axios.post("Renthouse/insertRentalhousing", this.rentalhousing).then((res) => {
					console.log(res)
					ElMessage({
						message: '新增成功！',
						type: 'success',
					})
					this.closes();
					this.$router.push("/rentalhousing");
					// if (res.data == 'ok') {

					// 	this.getData();
					// 	this.$message.success("新增成功！");
					// } else {
					// 	this.$message.error("新增失败！")
					// }
					//成功！
				}).catch(() => {
					this.$message.error("新增失败！")
				})
			},
			chanRehoHousetype(){
				if(this.woshi != "" && this.dating != "" && this.wei != ""){
					this.rentalhousing.rehoHousetype = this.woshi+this.dating+this.wei;
				}
			},
			
			getDizi(){
				this.qu.forEach((key)=>{
					if(key.countyId == this.quid){
						this.quname = key.countyName;	
						this.rentalhousing.rehoCommunity = this.xquid;
					}
				});
			},
			getUptown(){
				this.xquid = ""
				this.axios({
					url: 'Renthouse/findAllUptownByUptownBelong',
					params:{
						uptownBelong:this.quid
					}
				}).then((v) => {
					this.xqu = v.data
				}).catch()
			},
			getCounty(){
				this.axios({
					url: 'Renthouse/findAllCountyByCountyBelong',
					params:{
						countyBelong:2
					}
				}).then((v) => {
					this.qu = v.data
				}).catch()
			},
			//房源图片
			handleFileUploaderChange(file) {
				const self = this
				let reader = new FileReader()
				reader.readAsDataURL(file.raw)
				reader.onload = function() {
					let img_base64 = this.result
					self.rentalhousing.rehoZhutu  = img_base64;
				}
			},
			//封面照片
			handleFileUploaderCoverPhoto(file) {
				const self = this
				let reader = new FileReader()
				reader.readAsDataURL(file.raw)
				reader.onload = function() {
					let img_base64 = this.result
					self.rentalhousing.rehoCertcateCover = img_base64;
				}
			},
			//封底照片
			handleFileUploaderBackPhoto(file) {
				const self = this
				let reader = new FileReader()
				reader.readAsDataURL(file.raw)
				reader.onload = function() {
					let img_base64 = this.result
					self.rentalhousing.rehoCertcateBackcover = img_base64;
				}
			},
			//权属页照片
			handleFileUploaderPagePhoto(file) {
				const self = this
				let reader = new FileReader()
				reader.readAsDataURL(file.raw)
				reader.onload = function() {
					let img_base64 = this.result
					self.rentalhousing.rehoCertcateQsy = img_base64;
				}
			},
			//户型照片
			handleFileUploaderDoorPhoto(file) {
				const self = this
				let reader = new FileReader()
				reader.readAsDataURL(file.raw)
				reader.onload = function() {
					let img_base64 = this.result
					self.rentalhousing.rehoCertcateFamilypage = img_base64;
				}
			},
			//委托协议照片
			handleFileUploaderEntrust(file) {
				const self = this
				let reader = new FileReader()
				reader.readAsDataURL(file.raw)
				reader.onload = function() {
					let img_base64 = this.result
					self.rentalhousing.rehoWeito  = img_base64;
				}
			},

			//点击下一步显示更多信息
			showMore() {
				this.flag = false;
				this.flag1 = true;
				this.isActive = false;
				this.isMore = true;
			},
			//点击更多信息上一步显示基本信息
			showBasic() {
				this.flag1 = false;
				this.flag = true;
				this.isMore = false;
				this.isActive = true;
			},
			//点击下一步显示房源图片界面
			showHousing() {
				this.flag1 = false;
				this.flag2 = true;
				this.isMore = false;
				this.isPicture = true;
			},
			//点击房源上一步显示更多信息
			showMores() {
				this.flag2 = false;
				this.flag1 = true;
				this.isPicture = false;
				this.isMore = true;
			},
			//图片转码
			Base64(file) {
				return new Promise(function(resolve, reject) {
					let reader = new FileReader();
					let imgResult = "";
					reader.readAsDataURL(file);
					reader.onload = function() {
						imgResult = reader.result;
					};
					reader.onerror = function(error) {
						reject(error);
					};
					reader.onloadend = function() {
						resolve(imgResult)
					}
				})
			},
			//
			closes(){
				
				this.isActive= true //基本信息样式
				this.isMore= false //更多信息样式
				this.isPicture= false //房源图片样式
				this.flag= true //基本信息Div显示隐藏
				this.flag1= false //更多信息Div显示隐藏
				this.flag2= false //房源图片Div显示隐藏

				this.rentalhousing={
					rehoNo:"",//编号
					rehoNumber:"",//租房房源编号(生成)
					rehoSite:"",//城市/区域(省、市、区)
					rehoCommunity:"",//小区名称
					rehoUnit:"",//单元
					rehoBuilding:"",//楼栋
					rehoFloornumber:"",//总楼层
					rehoLivefewfloor:"",//所在层
					rehoRoomnumber:"",//序号(房间号)
					rehoCoveredarea:"",//建筑面积
					rehoInsidespace:"",//套内面积(不能大于建筑面积)
					rehoHousetype:"",//户型(几室、几厅、几卫)
					rehoOrientation:"",//朝向
					rehoElevator:"",//电梯(有、无)
					rehoHousingtypes:"",//房屋类型(住宅、复式、公寓、商铺、写字楼)
					rehoLadder:"",//梯(梯户比例)
					rehoHouseholds:"",//户
					rehoCertcateCover:"",//不动产权证封面
					rehoCertcateBackcover:"",//不动产权证封底
					rehoCertcateQsy:"",//不动产权证权属页
					rehoCertcateFamilypage:"",//不动产权证户型页
					rehoZhutu:"",//主图
					rehoWeito:"",//委托
					rehoRentouttitle:"",//出租标题
					rehoRent:"",//租金
					rehoPayway:"",//付款方式
					rehoFitmenttype:"",//装修类型
					rehoShortestlease:"",//最短租期
					rehoSuppfacility:"",//配套设施
					rehoHouslabel:"",//房源标签
					rehoHousremark:"",//房源介绍
					rehoUsersNo:"",//用户编号
				}
				this.woshi=""
				this.dating=""
				this.wei=""
				this.quid=""//区
				this.quname=""
				this.qu=[]
				this.xqu=[]//xiao区数据
				this.xquid=""//区
				this.rehoSuppfacility=[]
				this.rehoHouslabel=[]

				this.value= ''
				this.imageUrl= ''
			},
		},
		created(){
			// if(){//当前登陆人市 为株洲市，编号1，长沙市编号2

			// }else{}
			this.getCounty();
		}
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
	

	.active {
		color: #2a75ec;
	}

	.more {
		color: #2a75ec;
	}

	.picture {
		color: #2a75ec;
	}
	

	.fangyuantupian .upload-demo,
	.fangyuantupian .el-upload {
		width: 362px !important;
		height: 182px !important;
	}
	.labelss .el-form-item__label{
		margin-right: 16px;
	}
</style>
