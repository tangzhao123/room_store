<template>
	<div>
		<el-row>
			<el-form label-width="80px">
				<el-form-item label="房源名称">
					<el-input v-model="name" placeholder="请输入房源名称" @change="getData1()" clearable></el-input>
				</el-form-item>
			</el-form>
			<el-col :span="6">
				<el-form label-width="80px">
					<el-form-item label="业主">
						<el-input v-model="yezhu" placeholder="姓名或电话" @change="getData1()" clearable></el-input>
					</el-form-item>
				</el-form>
			</el-col>
			<el-col :span="4" :push="1">
				<el-form label-width="80px">
					<el-form-item label="房源状态">
						<el-select v-model="fyzt" @change="getData1()" placeholder="房源状态">
							<el-option value="全部">全部</el-option>
							<el-option value="上架">上架</el-option>
							<el-option value="下架">下架</el-option>
						</el-select>
					</el-form-item>
				</el-form>
			</el-col>
			<el-col :span="2" :push="2">
				<el-button type="primary" size="medium" @click="getData1()">查询</el-button>
			</el-col>
		</el-row>
		<el-row style="margin: 10px;">
			<el-button type="primary" size="medium" @click="intoHousing">录入房源</el-button>
		</el-row>
		<div style="height: 430px; width: 1250px; border: 1px solid #D9D9D9; margin-left: 5px; margin: 10px;">
			<el-row>
				<el-form label-width="80px">
					<el-form-item label="位置">
						<el-radio v-model="ra" @change="getData1()" value="株洲市">株洲市</el-radio>
					</el-form-item>
				</el-form>
			</el-row>
			<el-row>
				<el-form label-width="80px">
					<el-form-item label="区域">
						<el-col span="2">
							<el-checkbox v-model="quyu" @change="getData1()" label="天元区"></el-checkbox>
							<el-checkbox v-model="quyu" @change="getData1()" label="荷塘区"></el-checkbox>
							<el-checkbox v-model="quyu" @change="getData1()" label="株洲县"></el-checkbox>
						</el-col>
					</el-form-item>
				</el-form>
			</el-row>
			<el-row>
				<el-form label-width="80px">
					<el-form-item label="租金">
						<el-col span="2">
							<el-checkbox v-model="jine" @change="getData1()" label="1500">1500元以下</el-checkbox>
							<el-checkbox v-model="jine" @change="getData1()" label="1500-2000">1500-2000元</el-checkbox>
							<el-checkbox v-model="jine" @change="getData1()" label="2000-3000">2000-3000元</el-checkbox>
							<el-checkbox v-model="jine" @change="getData1()" label="3000-5000">3000-5000元</el-checkbox>
							<el-checkbox v-model="jine" @change="getData1()" label="5000-8000">5000-8000元</el-checkbox>
							<el-checkbox v-model="jine" @change="getData1()" label="8000">8000元以上</el-checkbox>
						</el-col>
					</el-form-item>
				</el-form>
			</el-row>
			<el-row>
				
				<el-col :span="4">
					<el-form label-width="80px">
						<el-form-item label="">
							<el-input v-model="zuidi" placeholder="资金" />
						</el-form-item>
					</el-form>
				</el-col>
				<el-col :span="3">
					<el-form label-width="30px">
						<el-form-item label="-">
							<el-input v-model="zuigao" placeholder="资金" />
						</el-form-item>
					</el-form>
				</el-col>
				<el-col :span="3">
					<el-form label-width="50px">
						<el-form-item label="元/月">
							<el-button type="primary" size="medium" @click="getData1()">确定</el-button>
						</el-form-item>
					</el-form>
				</el-col>
			</el-row>
			<el-row>
				<el-form label-width="80px">
					<el-form-item label="房屋类型">
						<el-col span="2">
							<el-checkbox v-model="leixing" @change="getData1()" label="住宅"></el-checkbox>
							<el-checkbox v-model="leixing" @change="getData1()" label="复式"></el-checkbox>
							<el-checkbox v-model="leixing" @change="getData1()" label="公寓"></el-checkbox>
							<el-checkbox v-model="leixing" @change="getData1()" label="商铺"></el-checkbox>
						</el-col>
					</el-form-item>
				</el-form>
			</el-row>
			<el-row>
				<el-form label-width="80px">
					<el-form-item label="标签">
						<el-col span="2">
							<el-checkbox v-model="biaoqian" @change="getData1()" label="临近地铁"></el-checkbox>
							<el-checkbox v-model="biaoqian" @change="getData1()" label="停车场"></el-checkbox>
							<el-checkbox v-model="biaoqian" @change="getData1()" label="南北通透"></el-checkbox>
							<el-checkbox v-model="biaoqian" @change="getData1()" label="出行方便"></el-checkbox>
							<el-checkbox v-model="biaoqian" @change="getData1()" label="家电齐全"></el-checkbox>
							<el-checkbox v-model="biaoqian" @change="getData1()" label="拎包入住"></el-checkbox>
							<el-checkbox v-model="biaoqian" @change="getData1()" label="随时起租"></el-checkbox>
							<el-checkbox v-model="biaoqian" @change="getData1()" label="采光十足"></el-checkbox>
						</el-col>
					</el-form-item>
				</el-form>
			</el-row>
			<el-row>
				<el-form label-width="80px">
					<el-form-item label="支付方式">
						<el-col span="2">
							<el-checkbox v-model="zhifu" @change="getData1()" label="押一付一"></el-checkbox>
							<el-checkbox v-model="zhifu" @change="getData1()" label="押一付二"></el-checkbox>
							<el-checkbox v-model="zhifu" @change="getData1()" label="押一付三"></el-checkbox>
							<el-checkbox v-model="zhifu" @change="getData1()" label="押二付一"></el-checkbox>
							<el-checkbox v-model="zhifu" @change="getData1()" label="半年付"></el-checkbox>
							<el-checkbox v-model="zhifu" @change="getData1()" label="年付"></el-checkbox>
							<el-checkbox v-model="zhifu" @change="getData1()" label="面谈"></el-checkbox>
						</el-col>
					</el-form-item>
				</el-form>
			</el-row>
		</div>
		<div style="width: 1250px; margin-left: 5px;">
			<el-row style="margin: 10px;">
				<el-table :data="tableData1.slice((queryParams.pageNum-1)*queryParams.pageSize,queryParams.pageNum*queryParams.pageSize)" :cell-style="{'text-align':'center'}" :header-cell-style="{'text-align':'center'}">
					<el-table-column prop="rehoNumber" label="房源编号" width="140px"> </el-table-column>
					<el-table-column prop="rehoRentouttitle" label="出租标题" width="140px"> </el-table-column>
					<el-table-column prop="rehoCommunity" label="房源信息" width="440px">
						<template v-slot:default="v">
							<div>
								<div style="float: left;">
								<img :src="v.row.rehoZhutu" style="width:100px;height:100px">
								</div>
								<div style="float:left;margin-left: 5px;">
									<div style="height: 10px;">
									<span style="font-size: 20px;color:#333; float: left;">
										{{v.row.rehoCommunity}}{{v.row.rehoBuilding}}{{v.row.rehoUnit}}{{v.row.rehoRoomnumber}}</span>
									</div>
									<div style="height: 33px;">
									<br>
									<span style="font-size: 14px;float: left;">
										{{v.row.rehoHousetype}} {{v.row.rehoOrientation}} {{v.row.rehoFitmenttype}} {{v.row.rehoPayway}}</span>
									</div>
									<br>
									<div>
									<span style="color: #f23036;font-size: 22px;margin-right:5px;float: left;">{{v.row.rehoRent}}元/月</span>&nbsp;&nbsp;
									<span style="font-size: 17px;float: left;">{{v.row.rehoCoveredarea}}㎡</span>
									</div>
								</div>
							</div>
						</template>
					</el-table-column>
					<el-table-column prop="rehoShelf" label="房源状态" width="80px">
						<template v-slot:default="v">
							<div>{{v.row.rehoShelf == 1 ? "上架":"下架"}}</div>
						</template>
					</el-table-column>
					<el-table-column prop="rehoGfczt" label="公房池状态" width="90px">
						<template v-slot:default="v">
							<div>{{v.row.rehoGfczt == 2 ? "不在公房池":"已在公房池"}}</div>
						</template></el-table-column>
					<el-table-column prop="rehoHousingtypes" label="房屋类型" width="80px">
						<template v-slot:default="v">
							<div>{{v.row.rehoHousingtypes == null ? "未知" : v.row.rehoHousingtypes}}</div>
						</template>
					</el-table-column>
					<el-table-column prop="rehoDate" label="发布时间" width="160px"> </el-table-column>
					<el-table-column prop="rehoGenjindate" label="最近跟进时间" width="160px">
						<template v-slot:default="v">
							<div>{{v.row.rehoGenjindate == null ? "-" : v.row.rehoGenjindate}}</div>
						</template>
					</el-table-column>
					<el-table-column prop="" label="操作" fixed="right" width="180px">
						<template v-slot:default="v">
							<div class="dianji" style="margin-bottom:8px">
								<span style="margin-left:-14px;margin-right:29px" @click="xiangqing(v.row)">查看详情</span>
								<span @click="xiajia(v.row)">{{v.row.rehoShelf == 1 ? "下架":"上架"}}</span>
							</div>
							<div class="dianji" style="margin-bottom:8px">
								<span style="margin-right:15px;" @click="genjinjilu(v.row)">跟进记录</span>
								<span @click="yezhuxx(v.row)">业主信息</span>
							</div>
							<div class="dianji">
								<span style="margin-left:0px;margin-right:29px" @click="chugongfangchi(v.row)">{{v.row.rehoGfczt == 1 ? "移出公房池":"移入公房池"}}</span>
								<span>编辑</span>
							</div>
						</template>
					</el-table-column>
				</el-table>
				<!-- 分页组件开始 -->
				<div class="block" align="center">
				<el-pagination
					@size-change="handleSizeChange"
					@current-change="handleCurrentChange"
					:page-sizes="[3,6,12,20]"
					:current-page="queryParams.pageNum"
					:page-size="queryParams.pageSize"
					layout="total,sizes, prev, pager, next, jumper"
					:total="tableData1.length">
				</el-pagination>
				</div>
			</el-row>
		</div>

		<el-dialog
			v-model="dialogVisible"
			:title="xjrehoRentouttitle"
			width="30%"
			:before-close="handleClose">
			<span>确定要{{xjzt == 2?"下架":"上架"}}吗？</span>
			<template #footer>
			<span class="dialog-footer">
				<el-button @click="dialogVisible = false">取消</el-button>
				<el-button type="primary" @click="qdxiajia()">确定</el-button>
			</span>
			</template>
		</el-dialog>

		<el-dialog v-model="centerDialogVisible" title="移入公房池设置" width="30%" center>
			<div>
				<el-row>
					<el-col :span="2">
						<el-form label-width="80px">
							<el-form-item label="房源编号">
							</el-form-item>
						</el-form>
					</el-col>
					<el-col :span="6">
						<el-form label-width="190px">
							<el-form-item :label="xjrehoNumber">
							</el-form-item>
						</el-form>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="2">
						<el-form label-width="80px">
							<el-form-item label="房源标题">
							</el-form-item>
						</el-form>
					</el-col>
					<el-col :span="6">
						<el-form label-width="80px">
							<el-form-item :label="xjrehoRentouttitle">
							</el-form-item>
						</el-form>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="15">
						<el-form label-width="100px">
							<el-form-item label="房源提供方">
								<el-input v-model="tigong" />
							</el-form-item>
						</el-form>
					</el-col>
					<el-col :span="3">
						<el-form label-width="30px">
							<el-form-item label="元">
							</el-form-item>
						</el-form>
					</el-col>
				</el-row>
			</div>
			<template #footer>
			<span class="dialog-footer">
				<el-button @click="centerDialogVisible = false">取消</el-button>
				<el-button type="primary" @click="quedingyiru()" >确定</el-button>
			</span>
			</template>
		</el-dialog>

		<el-dialog
			v-model="dialogVisible1"
			:title="xjrehoRentouttitle"
			width="30%"
			:before-close="handleClose">
			<span>确定要移出公房池吗？</span>
			<template #footer>
			<span class="dialog-footer">
				<el-button @click="dialogVisible1 = false">取消</el-button>
				<el-button type="primary" @click="qdyichu()">确定</el-button>
			</span>
			</template>
		</el-dialog>
	</div>
</template>

<script>
import { ElMessage } from 'element-plus'
	export default {
		data() {
			return {
				dialogVisible:false,//上下架
				xjzt:0,
				xjrehoNumber:"",
				xjrehoRentouttitle:"",
				dialogVisible1:false,//移出
				centerDialogVisible:false,//入
				tigong:"",
				//模糊查询
				name:"",
				yezhu:"",
				fyzt:"",
				zhifu:[],
				biaoqian:[],
				leixing:[],
				zuidi:"",
				zuigao:"",
				jine:[],
				quyu:[],

				// 分页参数
				queryParams: {
					//初始页
					pageNum: 1,
					//每页数据
					pageSize: 3
				},
				// 分页数据总条数
				total: 0,
				tableData1:[],
			}
		},
		methods: {
			// 初始页currentPage、初始每页数据数pagesize和数据data
			handleSizeChange(size) {
			this.queryParams.pageSize = size;
			// console.log(this.pagesize) //每页下拉显示数据
			},
			handleCurrentChange(currentPage) {
			this.queryParams.pageNum = currentPage;
			// console.log(this.currentPage) //点击第几页
			},
			//跳转到新增房源的界面
			intoHousing(){
				this.$router.push("/add-rentalhous");
			},
			yezhuxx(row){
				this.$router.push({
					path:"/rentalowner",
					query: {
						params: JSON.stringify({no:row.rehoNo,Title:row.rehoRentouttitle,number:row.rehoNumber}) 
					}
				});
			},
			xiangqing(id){
				this.$router.push({
					path:"/zufang-details",
					query: {
						params: JSON.stringify({no:id.rehoNumber}) 
					}
				});
			},
			genjinjilu(row){
				this.$router.push({
					path:"/rentalfollowup",
					query: {
						params: JSON.stringify({no:row.rehoNo}) 
					}
				});
			},
			getData1(){
				var quyus = this.quyu.join(",");
				var jines = this.jine.join(",");
				var zujins = this.zuidi+","+this.zuigao;
				var leixings = this.leixing.join(",");
				var biaoqians = this.biaoqian.join(",");
				var zhifus = this.zhifu.join(",");

				var voRentalhousing = {
					name:this.name,
					yezhu:this.yezhu,
					fyzt:this.fyzt,
					zhifus:zhifus,
					biaoqians:biaoqians,
					leixings:leixings,
					zujins:zujins,
					jines:jines,
					quyus:quyus,
					userid:this.$store.state.token.userID
				}
				var fl = true;
				if(this.zuidi != ""){
					if(!this.isRealNum(this.zuidi)){
						fl = false;
						ElMessage({
							message: '金额请输入数字！',
							type: 'warning',
						})
					}
				}
				if(this.zuigao != ""){
					if(!this.isRealNum(this.zuigao)){
						fl = false;
						ElMessage({
							message: '金额请输入数字！',
							type: 'warning',
						})
					}
				}
				
				if(fl){
					this.axios.post("Renthouse/findRentalhousingMultiple", voRentalhousing).then((res) => {
						this.tableData1 = res.data;
					}).catch(() => {
					});
				}
			},
			isRealNum(val){
				// isNaN()函数 把空串 空格 以及NUll 按照0来处理 所以先去除，
				if(val === "" || val ==null){
					return false;
				}
				if(!isNaN(val)){	
					//对于空数组和只有一个数值成员的数组或全是数字组成的字符串，isNaN返回false，例如：'123'、[]、[2]、['123'],isNaN返回false,
					//所以如果不需要val包含这些特殊情况，则这个判断改写为if(!isNaN(val) && typeof val === 'number' )
					return true; 
				}else{ 
					return false; 
				} 
			},
			xiajia(row){
				var zt = 1
				if(row.rehoShelf == 1){
					zt = 2
				}
				this.xjzt = zt;
				this.xjrehoRentouttitle = row.rehoRentouttitle 
				this.xjrehoNumber = row.rehoNumber
				this.dialogVisible = true;
			},
			qdxiajia(){
				this.axios({
					url: 'Renthouse/updateRentalhousingRehoShelfByNumber',
					params:{
						rehoShelf:this.xjzt,
						rehoNumber:this.xjrehoNumber
					}
				}).then((v) => {
					console.log(v)
					this.dialogVisible = false;
					var sj = "上架";
					if(this.xjzt == 2){
						sj = "下架";
					}
					this.$message.success(sj+"成功！");
					this.getData1();
				}).catch()
			},
			quedingyiru(){
				var fl = true
				if(this.tigong == ""){
					ElMessage({
						message: '请输入成交奖励！',
						type: 'warning',
					})
					fl = false;
				}else if(this.tigong != ""){
					if(!this.isRealNum(this.tigong)){
						fl = false;
						ElMessage({
							message: '成交奖励请输入数字！',
							type: 'warning',
						})
					}
				}
				if(fl){
					var rentalpublicpools = {
						reppRehoNo:this.xjrehoNumber,
						reppMoney:this.tigong
					}
					this.axios.post("Renthouse/insertRentalpublicpools", rentalpublicpools).then((res) => {
						this.getData1();
						var sj = "移入";
						if(this.yrrehoGfczt == 2){
							sj = "移出";
						}
						this.tigong = "";
						this.$message.success(sj+"成功！");
						this.centerDialogVisible = false;
						console.log(res)
					}).catch()
				}
			},
			qdyichu(){
				this.axios({
					url: 'Renthouse/deleteRentalpublicpoolsByReppRehoNo',
					params:{	
						reppRehoNo:this.xjrehoNumber
					}
				}).then((v) => {
					this.getData1();
					this.$message.success("移出成功！");
					this.dialogVisible1 = false;
					console.log(v)
				}).catch()
			},

			chugongfangchi(row){
				console.log(row)
				if(row.rehoGfczt == 2){
					this.yrrehoGfczt = 1;
					this.xjrehoNumber = row.rehoNumber;
					this.xjrehoRentouttitle = row.rehoRentouttitle
					this.centerDialogVisible = true;
				}else{
					this.xjrehoNumber = row.rehoNumber;
					this.dialogVisible1 = true;
				}
				
			},
		},
		created() {
			this.getData1();
		}
	}
</script>

<style>
	.dianji span{
		color: #2a75ec;
		cursor:pointer;
		filter: alpha(Opacity=100);
		opacity: 1;
	}
	.dianji :hover{
		filter: alpha(Opacity=100);
		opacity: 1;
	}
</style>
