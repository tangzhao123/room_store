<template>
	<div>
		<div style="border-bottom: 2px solid #D9D9D9; padding: 20px;">
			<el-row style="padding-left: 100px;">
				<el-col :span="8" v-bind:class="{ 'active': isActive }">
					基本信息
				</el-col>
				<el-col :span="8" v-bind:class="{ 'more': isMore }">
					更多信息
				</el-col>
				<el-col :span="8" v-bind:class="{ 'picture': isPicture }">
					房源图片
				</el-col>
			</el-row>
		</div>
		<el-row>
			<!-- 基本信息填写的Div -->
			<div style="padding: 20px;" v-if="flag">
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="城市/区域">
							<el-col style="padding-left: 5px;">
								<el-select v-model="province" placeholder="请选择省">
									<el-option v-for="item in provinces" :key="item.label" :label="item.label"
										:value="item.label">
									</el-option>
								</el-select>
							</el-col>
							<el-col style="padding-left: 5px;">
								<el-select v-model="city" placeholder="请选择市">
									<el-option v-for="item in citys" :key="item.label" :label="item.label"
										:value="item.label">
									</el-option>
								</el-select>
							</el-col>
							<el-col style="padding-left: 5px;">
								<el-select v-model="area" placeholder="请选择区">
									<el-option v-for="item in areas" :key="item.label" :label="item.label"
										:value="item.label">
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
								<el-input v-model="secondary.secondaryVillage" placeholder="请输入小区名称"
									style="width: 660px;"></el-input>
							</el-col>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form label-width="80px">
							<el-form-item label="总楼层">
								<el-select v-model="secondary.secondaryFloor" placeholder="请选择"
									style="padding-left: 5px;">
									<el-option v-for="item in total" :key="item.label" :label="item.label"
										:value="item.label">
									</el-option>
								</el-select>
							</el-form-item>
						</el-form>
					</el-col>
					<el-col :span="10">
						<el-form label-width="80px">
							<el-form-item label="所在层">
								<el-select v-model="secondary.secondaryLayer" placeholder="请选择"
									style="padding-left: 5px;">
									<el-option v-for="item in total" :key="item.label" :label="item.label"
										:value="item.label">
									</el-option>
								</el-select>
							</el-form-item>
						</el-form>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form label-width="80px">
							<el-form-item label="单元">
								<el-select v-model="secondary.secondaryUnit" placeholder="请选择"
									style="padding-left: 5px;">
									<el-option v-for="item in unit" :key="item.label" :label="item.label"
										:value="item.label">
									</el-option>
								</el-select>
							</el-form-item>
						</el-form>
					</el-col>
					<el-col :span="10">
						<el-form label-width="80px">
							<el-form-item label="楼栋">
								<el-input v-model="secondary.secondaryBuilding" placeholder="请输入楼栋"></el-input>

							</el-form-item>
						</el-form>
					</el-col>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="房号">
							<el-col style="padding-left: 5px;">
								<el-input v-model="secondary.secondaryRoom" placeholder="请输入房号" style="width: 660px;">
								</el-input>
							</el-col>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form label-width="80px">
							<el-form-item label="建筑面积">
								<el-input v-model="secondary.secondaryArea" placeholder="请输入内容"
									style="padding-left: 5px;">
								</el-input>
							</el-form-item>
						</el-form>
					</el-col>
					<el-col :span="10">
						<el-form label-width="80px">
							<el-form-item label="套内面积" style="padding-left: 15px;">
								<el-input v-model="secondary.secondaryWithin" placeholder="请输入内容"></el-input>
							</el-form-item>
						</el-form>
					</el-col>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="户型">
							<el-col style="padding-left: 5px;">
								<el-select v-model="room" placeholder="请选择室">
									<el-option v-for="item in rooms" :key="item.label" :label="item.label"
										:value="item.label">
									</el-option>
								</el-select>
							</el-col>
							<el-col style="padding-left: 5px;">
								<el-select v-model="hall" placeholder="请选择厅">
									<el-option v-for="item in halls" :key="item.label" :label="item.label"
										:value="item.label">
									</el-option>
								</el-select>
							</el-col>
							<el-col style="padding-left: 5px;">
								<el-select v-model="who" placeholder="请选择卫">
									<el-option v-for="item in whos" :key="item.label" :label="item.label"
										:value="item.label">
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
								<el-select v-model="secondary.secondaryToward" placeholder="请选择朝向">
									<el-option v-for="item in toward" :key="item.label" :label="item.label"
										:value="item.label">
									</el-option>
								</el-select>

							</el-form-item>
						</el-form>
					</el-col>
					<el-col :span="10">
						<el-form label-width="80px">
							<el-form-item label="建筑年代" style="padding-left: 15px;">
								<el-input v-model="secondary.secondaryYear" placeholder="请输入内容"></el-input>
							</el-form-item>
						</el-form>
					</el-col>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="房屋用途">
							<el-radio label="居住" v-model="secondary.secondaryUse">居住</el-radio>
							<el-radio label="工业" v-model="secondary.secondaryUse">工业</el-radio>
							<el-radio label="商业" v-model="secondary.secondaryUse">商业</el-radio>
							<el-radio label="办公" v-model="secondary.secondaryUse">办公</el-radio>
							<el-radio label="文体娱乐" v-model="secondary.secondaryUse">文体娱乐</el-radio>
							<el-radio label="其他" v-model="secondary.secondaryUse">其他</el-radio>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="梯户比例">
							<el-col style="padding-left: 5px;">
								<el-select v-model="ladder" placeholder="请选择">
									<el-option v-for="item in ladders" :key="item.label" :label="item.label"
										:value="item.label">
									</el-option>
								</el-select>
							</el-col>
							<el-col style="padding-left: 5px;">
								<el-select v-model="households" placeholder="请选择">
									<el-option v-for="item in household" :key="item.label" :label="item.label"
										:value="item.label">
									</el-option>
								</el-select>
							</el-col>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="电梯">
							<el-radio label="有" v-model="secondary.secondaryElevator">有</el-radio>
							<el-radio label="无" v-model="secondary.secondaryElevator">无</el-radio>
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
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请上传封面照片
							</el-col>
							<el-col :span="6" class="fangyuantupian">
								<el-upload class="upload-demo" ref="upload" action="" drag multiple :auto-upload="false"
									:on-change="handleFileUploaderBackPhoto">
									<i class="el-icon-upload"></i>
									<div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
								</el-upload>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请上传封底照片
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
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请上传权属页照片
							</el-col>
							<el-col :span="6" class="fangyuantupian">
								<el-upload class="upload-demo" ref="upload" action="" drag multiple :auto-upload="false"
									:on-change="handleFileUploaderDoorPhoto">
									<i class="el-icon-upload"></i>
									<div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
								</el-upload>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请上传户型照片
							</el-col>
						</el-form-item>
					</el-form>
				</el-row>

				<el-row>
					<el-form>
						<el-form-item label="请上传委托协议">
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
			<div style="padding: 20px; " v-if="flag1">
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="出售标题">
							<el-col style="padding-left: 5px;">
								<el-input v-model="secondary.secondaryTitle" placeholder="请输入内容" style="width: 660px;">
								</el-input>
							</el-col>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="价格">
							<el-col style="padding-left: 5px;">
								<el-input v-model="secondary.secondaryPrice" placeholder="请填写期望售价(万元)"></el-input>
							</el-col>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="装修类型">
							<el-radio label="毛胚" v-model="secondary.secondaryType">毛胚</el-radio>
							<el-radio label="简装" v-model="secondary.secondaryType">简装</el-radio>
							<el-radio label="精装" v-model="secondary.secondaryType">精装</el-radio>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="110px">
						<el-form-item label="房屋获取渠道">
							<el-radio label="线上" v-model="secondary.secondaryAccess">线上</el-radio>
							<el-radio label="线下" v-model="secondary.secondaryAccess">线下</el-radio>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="房屋标签">

							<el-checkbox-group v-model="checkList" @change="changeCheckbox">
								<el-checkbox label="南北通透"></el-checkbox>
								<el-checkbox label="户型方正"></el-checkbox>
								<el-checkbox label="满五唯一"></el-checkbox>
								<el-checkbox label="满两年"></el-checkbox>
								<el-checkbox label="近地铁"></el-checkbox>
								<el-checkbox label="近学区"></el-checkbox>
								<el-checkbox label="随时看房"></el-checkbox>
								<el-checkbox label="独家房源"></el-checkbox>
								<el-checkbox label="不限购"></el-checkbox>
							</el-checkbox-group>
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
							<el-radio label="划拨" v-model="secondary.secondaryPower">划拨</el-radio>
							<el-radio label="出让" v-model="secondary.secondaryPower">出让</el-radio>
							<el-radio label="其他" v-model="secondary.secondaryPower">其他</el-radio>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="产权年限">
							<el-radio label="40年" v-model="secondary.secondaryRights">40年</el-radio>
							<el-radio label="50年" v-model="secondary.secondaryRights">50年</el-radio>
							<el-radio label="70年" v-model="secondary.secondaryRights">70年</el-radio>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="购买年限">
							<el-radio label="不满两年" v-model="secondary.secondaryBuy">不满两年</el-radio>
							<el-radio label="满两年" v-model="secondary.secondaryBuy">满两年</el-radio>
							<el-radio label="满五年" v-model="secondary.secondaryBuy">满五年</el-radio>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row>
					<el-form label-width="80px">
						<el-form-item label="权力性质">
							<el-radio label="不唯一" v-model="secondary.secondaryOnly">不唯一</el-radio>
							<el-radio label="唯一" v-model="secondary.secondaryOnly">唯一</el-radio>
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
							<el-input v-model="secondary.secondaryHousing" type="textarea" :rows="3"
								placeholder="请输入房屋的详细信息,不超过500字" style="width: 800px;"></el-input>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row style="padding: 10px;">
					<el-form label-width="80px">
						<el-form-item label="小区介绍">
							<el-input v-model="secondary.secondaryCommunity" type="textarea" :rows="3"
								placeholder="请输入房屋的详细信息,不超过500字" style="width: 800px;"></el-input>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row style="padding: 10px;">
					<el-form label-width="80px">
						<el-form-item label="附近学校">
							<el-input v-model="secondary.secondarySchool" type="textarea" :rows="3"
								placeholder="请输入房屋的详细信息,不超过500字" style="width: 800px;"></el-input>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row style="padding: 10px;">
					<el-form label-width="80px">
						<el-form-item label="房源优势">
							<el-input v-model="secondary.secondaryAdvantage" type="textarea" :rows="3"
								placeholder="请输入房屋的详细信息,不超过500字" style="width: 800px;"></el-input>
						</el-form-item>
					</el-form>
				</el-row>
				<el-row style="padding: 10px;">
					<el-form label-width="80px">
						<el-form-item label="业主心态">
							<el-input v-model="secondary.secondaryOwner" type="textarea" :rows="3"
								placeholder="请输入房屋的详细信息,不超过500字" style="width: 800px;"></el-input>
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
			<!-- 房源新增 -->
			<div style="padding: 10px; " v-if="flag2">
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
						<el-button type="primary" size="medium" @click="addSecondary()">保存</el-button>
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
				isActive: true, //基本信息样式
				isMore: false, //更多信息样式
				isPicture: false, //房源图片样式
				provinces: [{
					value: '1',
					label: '湖南省',
				}, ], //省
				citys: [{
					value: '1',
					label: '株洲市',
				}, ], //市
				areas: [{
					value: '1',
					label: '荷塘区',
				}, ], //区
				province: '', //省
				city: '', //市
				area: '', //区
				total: [{
						value: '1',
						label: '1层',
					},
					{
						value: '2',
						label: '2层',
					},
					{
						value: '3',
						label: '3层',
					},
					{
						value: '4',
						label: '4层',
					},
					{
						value: '5',
						label: '5层',
					},
					{
						value: '6',
						label: '6层',
					},
					{
						value: '7',
						label: '7层',
					},
					{
						value: '8',
						label: '8层',
					},
					{
						value: '9',
						label: '9层',
					},
					{
						value: '10',
						label: '10层',
					},
				], //总楼层
				unit: [{
						value: '1',
						label: '1单元',
					},
					{
						value: '2',
						label: '2单元',
					},
					{
						value: '3',
						label: '3单元',
					},
					{
						value: '4',
						label: '4单元',
					},
					{
						value: '5',
						label: '5单元',
					},
					{
						value: '6',
						label: '6单元',
					},
					{
						value: '7',
						label: '7单元',
					},
					{
						value: '8',
						label: '8单元',
					},
					{
						value: '9',
						label: '9单元',
					},
					{
						value: '10',
						label: '10单元',
					},
				], //单元
				rooms: [{
						value: '1',
						label: '1室',
					},
					{
						value: '2',
						label: '2室',
					},
					{
						value: '3',
						label: '3室',
					},
					{
						value: '4',
						label: '4室',
					},
					{
						value: '5',
						label: '5室',
					},
					{
						value: '6',
						label: '6室',
					},
					{
						value: '7',
						label: '7室',
					},
					{
						value: '8',
						label: '8室',
					},
					{
						value: '9',
						label: '9室',
					},
					{
						value: '10',
						label: '10室',
					},
				], //室
				halls: [{
						value: '1',
						label: '1厅',
					},
					{
						value: '2',
						label: '2厅',
					},
					{
						value: '3',
						label: '3厅',
					},
					{
						value: '4',
						label: '4厅',
					},
					{
						value: '5',
						label: '5厅',
					},
					{
						value: '6',
						label: '6厅',
					},
					{
						value: '7',
						label: '7厅',
					},
					{
						value: '8',
						label: '8厅',
					},
					{
						value: '9',
						label: '9厅',
					},
					{
						value: '10',
						label: '10厅',
					},
				], //厅
				whos: [{
						value: '1',
						label: '1卫',
					},
					{
						value: '2',
						label: '2卫',
					},
					{
						value: '3',
						label: '3卫',
					},
					{
						value: '4',
						label: '4卫',
					},
					{
						value: '5',
						label: '5卫',
					},
					{
						value: '6',
						label: '6卫',
					},
					{
						value: '7',
						label: '7卫',
					},
					{
						value: '8',
						label: '8卫',
					},
					{
						value: '9',
						label: '9卫',
					},
					{
						value: '10',
						label: '10卫',
					},
				], //卫
				ladders: [{
						value: '1',
						label: '一梯',
					},
					{
						value: '2',
						label: '二梯',
					},
					{
						value: '3',
						label: '三梯',
					},
					{
						value: '4',
						label: '四梯',
					},

				], //梯
				household: [{
						value: '1',
						label: '一户',
					},
					{
						value: '2',
						label: '二户',
					},
					{
						value: '3',
						label: '三户',
					},
					{
						value: '4',
						label: '四户',
					},
				], //户
				toward: [{
						value: '1',
						label: '东',
					},
					{
						value: '2',
						label: '南',
					},
					{
						value: '3',
						label: '西',
					},
					{
						value: '4',
						label: '北',
					},
					{
						value: '5',
						label: '东南',
					},
					{
						value: '6',
						label: '西南',
					},
				], //朝向
				flag: true, //基本信息Div显示隐藏
				flag1: false, //更多信息Div显示隐藏
				flag2: false, //房源图片Div显示隐藏
				value: '',
				imageUrl: '',
				secondary: { //二手房对象
					secondaryId: '', //序号
					secondaryNumber: '', //房源编号
					secondaryCity: '', //城市/区域
					secondaryVillage: '', //小区名称
					secondaryFloor: '', //总楼层
					secondaryLayer: '', //所在层
					secondaryUnit: '', //单元
					secondaryBuilding: '', //楼栋
					secondaryRoom: '', //房号
					secondaryArea: '', //建筑面积
					secondaryWithin: '', //套内面积
					secondaryModel: '', //户型
					secondaryToward: '', //朝向
					secondaryYear: '', //建筑年代
					secondaryUse: '', //房屋用途
					secondaryLadder: '', //梯户比例
					secondaryElevator: '', //有无电梯
					secondaryCover: '', //封面照片
					secondaryBack: '', //封底照片
					secondaryPage: '', //权属页照片
					secondaryFamily: '', //户型页照片
					secondaryTitle: '', //出售标题
					secondaryPrice: '', //价格
					secondaryType: '', //装修类型
					secondaryAccess: '', //房源获取渠道
					secondaryLable: '', //房屋标签
					secondaryPower: '', //权力性质
					secondaryRights: '', //产权年限
					secondaryBuy: '', //购买年限
					secondaryOnly: '', //是否唯一
					secondaryHousing: '', //房屋介绍
					secondaryCommunity: '', //小区介绍
					secondarySchool: '', //附近学校
					secondaryAdvantage: '', //房源优势
					secondaryOwner: '', //业主心态
					secondaryState: '', //上下架状态
					secondaryPoolsAccess: '', //公房池状态
					secondaryAvailability: '', //房源发布时间
					goodRoom: '', //好房外键
					userId: '' ,//用户外键
					secondaryEntrust:'',//委托协议
					secondaryPicture:'',//房源图片
				},
				room: '', //室
				hall: '', //厅
				who: '', //卫
				ladder: '', //梯
				households: '', //户
				checkList: [], //标签
				
			}
		},
		methods: {
			//获取房源标签
			changeCheckbox(val) {
				var str = "";
				for (var i = 0; i < val.length; i++) {
					str += val[i] + ",";
				}
				//去掉最后一个逗号(如果不需要去掉，就不用写)
				if (str.length > 0) {
					str = str.substr(0, str.length - 1);
				}
				this.secondary.secondaryLable = str;
			},
			//房源图片
			handleFileUploaderChange(file) {
				const self = this
				let reader = new FileReader()
				reader.readAsDataURL(file.raw)
				reader.onload = function() {
					let img_base64 = this.result
					console.log(img_base64)
					self.secondary.secondaryPicture = img_base64;
				}
				console.log(file)
				console.log(this.imgBase64Array)
			},
			//封面照片
			handleFileUploaderCoverPhoto(file) {
				const self = this
				let reader = new FileReader()
				reader.readAsDataURL(file.raw)
				reader.onload = function() {
					let img_base64 = this.result
					console.log(img_base64)
					self.secondary.secondaryCover = img_base64;
				}
				console.log(file)
				console.log(this.secondary.secondaryCover)
			},
			//封底照片
			handleFileUploaderBackPhoto(file) {
				const self = this
				let reader = new FileReader()
				reader.readAsDataURL(file.raw)
				reader.onload = function() {
					let img_base64 = this.result
					console.log(img_base64)
					self.secondary.secondaryBack = img_base64;
				}
				console.log(file)
				console.log(this.secondary.secondaryBack)
			},
			//权属页照片
			handleFileUploaderPagePhoto(file) {
				const self = this
				let reader = new FileReader()
				reader.readAsDataURL(file.raw)
				reader.onload = function() {
					let img_base64 = this.result
					console.log(img_base64)
					self.secondary.secondaryPage = img_base64;
				}
				console.log(file)
				console.log(this.secondary.secondaryPage)
			},
			//户型照片
			handleFileUploaderDoorPhoto(file) {
				const self = this
				let reader = new FileReader()
				reader.readAsDataURL(file.raw)
				reader.onload = function() {
					let img_base64 = this.result
					console.log(img_base64)
					self.secondary.secondaryFamily = img_base64;
				}
				console.log(file)
				console.log(this.secondary.secondaryFamily)
			},
			//委托协议照片
			handleFileUploaderEntrust(file) {
				const self = this
				let reader = new FileReader()
				reader.readAsDataURL(file.raw)
				reader.onload = function() {
					let img_base64 = this.result
					console.log(img_base64)
					self.secondary.secondaryEntrust = img_base64;
				}
				console.log(file)
				console.log(this.doorModelBase)
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
			//新增二手房源
			addSecondary() {
				this.secondary.secondaryCity = this.province + ',' + this.city + ',' + this.area;
				this.secondary.secondaryModel = this.room + ',' + this.hall + ',' + this.who;
				this.secondary.secondaryLadder = this.ladder + ',' + this.households;
				console.log(this.secondary);
				//执行新增
				this.axios.post("/Secondary/add-secondary", this.secondary).then((res) => {
					if (res.data == 'ok') {
						this.$message.success("新增成功！");
						this.$router.push("/secondary");
					} else {
						this.$message.error("新增失败！")
					}
				}).catch(() => {
					this.$message.error("新增失败！")
				})

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

	.el-upload--text {
		width: 166px;
		height: 150px;
	}

	.active {
		color: blue;
	}

	.more {
		color: blue;
	}

	.picture {
		color: blue;
	}

	.fangyuantupian .upload-demo,
	.fangyuantupian .el-upload {
		width: 362px !important;
		height: 182px !important;
	}
</style>
