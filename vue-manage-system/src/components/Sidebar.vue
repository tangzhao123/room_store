<template>
	<div class="sidebar">
		<el-menu class="sidebar-el-menu" :default-active="onRoutes" :collapse="collapse" background-color="#324157"
			text-color="#bfcbd9" active-text-color="#20a0ff" unique-opened router>
			<template v-for="item in items">
				<template v-if="item.subs">
					<el-submenu :index="item.index" :key="item.index">
						<template #title>
							<i :class="item.icon"></i>
							<span>{{ item.title }}</span>
						</template>
						<template v-for="subItem in item.subs">
							<el-submenu v-if="subItem.subs" :index="subItem.index" :key="subItem.index">
								<template #title>{{ subItem.title }}</template>
								<el-menu-item v-for="(threeItem, i) in subItem.subs" :key="i" :index="threeItem.index">
									{{ threeItem.title }}
								</el-menu-item>
							</el-submenu>
							<el-menu-item v-else :index="subItem.index" :key="subItem.index">{{ subItem.title }}
							</el-menu-item>
						</template>
					</el-submenu>
				</template>
				<template v-else>
					<el-menu-item :index="item.index" :key="item.index">
						<i :class="item.icon"></i>
						<template #title>{{ item.title }}</template>
					</el-menu-item>
				</template>
			</template>
		</el-menu>
	</div>
</template>

<script>
	// import bus from "../common/bus";
	export default {
		data() {
			return {
				items: [{
						icon: "el-icon-lx-home",
						index: "dashboard",
						title: "系统首页"
					},
					{
						icon: "el-icon-s-home",
						index: "1",
						title: "二手房",
						subs: [{
								index: "secondary",
								title: "二手房管理"
							},
							{
								index: "look_record",
								title: "二手房带看"
							},
							{
								index: "hand_house",
								title: "公房池"
							},
						]
					},
					{
						icon: "el-icon-lx-calendar",
						index: "2",
						title: "客源",
						subs: [{
							index: "mycustomers",
							title: "我的客源"
						}, {
							index: "maleguestpool",
							title: "公客池"
						}, ]
					},
					{
						icon: "el-icon-lx-calendar",
						index: "4",
						title: "营销中心",
						subs: [{
							index: "selectgoodroom",
							title: "精选好房"
						}, ]
					},
					{
						icon: "el-icon-s-home",
						index: "5",
						title: "新房",
						subs: [{
								index: "newhouse",
								title: "新房管理"
							},
							{
								index: "house-collection",
								title: '新房采集'
							},
							{
								index: 'house_type',
								title: '户型管理'
							}
						]
					},
					{
						icon: "el-icon-lx-calendar",
						index: "6",
						title: "租房",
						subs: [{
							index: "rentalhousing",
							title: "租房管理"
						}, {
							index: "publicpools",
							title: "租房公房池"
						}, ]
					}, {
						icon: "el-icon-lx-calendar",
						index: "7",
						title: "个人中心",
						subs: [{
							index: "myInformation",
							title: "我的信息"
						}, {
							index: "changePass",
							title: "修改密码"
						}, ]
					}, {
						icon: "el-icon-lx-calendar",
						index: "8",
						title: "数据中心",
						subs: [{
							index: "newStatistics",
							title: "房源统计"
						}]
					}

				]
			};
		},
		computed: {
			onRoutes() {
				return this.$route.path.replace("/", "");
			},
			collapse() {
				return this.$store.state.collapse
			}
		}
	};
</script>

<style scoped>
	.el-submenu .el-menu-item {
		padding-left: 75px !important;
		font-size: 13px;
		height: 50px;
		line-height: 50px;
		padding: 0 45px;
		min-width: 200px;
	}


	.sidebar {
		display: block;
		position: absolute;
		left: 0;
		top: 70px;
		bottom: 0;
		overflow-y: scroll;
	}

	.sidebar::-webkit-scrollbar {
		width: 0;
	}

	.sidebar-el-menu:not(.el-menu--collapse) {
		width: 250px;
	}

	.sidebar>ul {
		height: 100%;
	}
</style>
