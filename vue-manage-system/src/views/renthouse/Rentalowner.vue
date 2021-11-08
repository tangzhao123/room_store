<template>
	<div style="margin-top:50px">
		<el-row>
			<el-col :span="8">
				<el-form label-width="150px">
					<el-form-item label="房源标题"> 
						<el-input disabled  v-model="Titles" />
					</el-form-item>
				</el-form>
			</el-col>
		</el-row>
		<el-row>
			<el-col :span="8">
				<el-form label-width="150px">
					<el-form-item label="业主姓名">
						<el-input v-model="rentalowner.reowName" />
					</el-form-item>
				</el-form>
			</el-col>
		</el-row>
		<el-row>
			<el-col :span="8">
				<el-form label-width="150px">
					<el-form-item label="业主电话">
						<el-input v-model="rentalowner.reowPhone" />
					</el-form-item>
				</el-form>
			</el-col>
		</el-row>
		<el-row>
			<el-col :span="8">
				<el-form label-width="150px">
					<el-form-item label="备用电话">
						<el-input v-model="rentalowner.reowPhones" />
					</el-form-item>
				</el-form>
			</el-col>
		</el-row>
		<el-row>
			<el-col :span="15">
				<el-form label-width="150px">
					<el-form-item label="备注">
						<el-input :rows="8" v-model="rentalowner.reowRemark" placeholder="请输入备注"  type="textarea"/>
					</el-form-item>
				</el-form>
			</el-col>
		</el-row>
		<el-row>
			<el-col :span="5">
				<el-form label-width="150px">
					<el-form-item label="">
						<el-button type="primary" @click="queding()">确定</el-button>
					</el-form-item>
				</el-form>
			</el-col>
			<el-col :span="5">
				<el-button @click="quxiao()">取消</el-button>
			</el-col>
		</el-row>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				rentalowner:{
					reowNo:"",
					reowName:"",
					reowPhone:"",
					reowPhones:"",
					reowRemark:"",
					reowRehoNo:""
				},
				Titles:"",
				no:"",
				number:"",
				zx:"",
			}
		},
		methods: {
			quxiao(){
				this.$router.push("/rentalhousing");
			},
			queding(){
				if(this.zx == "新增"){
					this.axios.post("Renthouse/insertRentalowner", this.rentalowner).then((res) => {
						this.clear();
						console.log(res)
						this.$router.push("/rentalhousing");
					}).catch(() => {
						
					});
				}else{
					this.axios.post("Renthouse/updateRentalowner", this.rentalowner).then((res) => {
						console.log(res)
						this.clear();
						this.$router.push("/rentalhousing");
					}).catch(() => {
						
					});
				}
			},
			getDate(){
				let params = JSON.parse( this.$route.query.params);
				this.no = params.no;
				this.rentalowner.reowRehoNo = this.no;
				this.Titles = params.Title;
				this.number = params.number;

				//chaxun 
				this.axios({
					url: 'Renthouse/findAllRentalowner',
					params:{
						param:this.no
					}
				}).then((v) => {
					var zx = "新增";
					if(v.data != ""){
						zx = "修改"
						this.rentalowner = v.data;
					}
					this.zx = zx;
				}).catch()
			},
			clear(){
				this.rentalowner={
					reowNo:"",
					reowName:"",
					reowPhone:"",
					reowPhones:"",
					reowRemark:"",
					reowRehoNo:""
				}
				this.Titles=""
				this.no=""
				this.number=""
				this.zx=""
			}
		},
		created() {
			this.clear();
			this.getDate();
		}
	}
</script>

<style>
</style>
