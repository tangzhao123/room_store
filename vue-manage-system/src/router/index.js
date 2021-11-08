import {
	createRouter,
	createWebHistory
} from "vue-router";
import Home from "../views/Home.vue";

const routes = [{
	path: '/',
	redirect: '/login'
}, {
	path: "/",
	name: "Home",
	component: Home,
	children: [{
			path: "/dashboard",
			name: "dashboard",
			meta: {
				title: '系统首页'
			},
			component: () => import(
				"../views/Dashboard.vue")
		},
		{
			path: "/secondary",
			name: "secondary",
			meta: {
				title: '二手房管理'
			},
			component: () => import(
				"../views/secondary/Secondary.vue")
		},
		{
			path: "/look_record",
			name: "look_record",
			meta: {
				title: '二手房带看'
			},
			component: () => import(
				"../views/secondary/LookRecord.vue")
		},
		{
			path: "/hand_house",
			name: "hand_house",
			meta: {
				title: '公房池'
			},
			component: () => import(
				"../views/secondary/HandHouse.vue")
		},
		{
			path: "/into_housing",
			name: "into_housing",
			meta: {
				title: '新增房源'
			},
			component: () => import(
				"../views/secondary/IntoHousing.vue")
		},
		{
			path: "/mycustomers",
			name: "mycustomers",
			meta: {
				title: '我的客源'
			},
			component: () => import(
				"../views/customers/MyCustomers.vue")
		},
		{
			path: "/maleguestpool",
			name: "maleguestpool",
			meta: {
				title: '公客池'
			},
			component: () => import(
				"../views/customers/MaleGuestPool.vue")
		},
		{
			path: "/selectgoodroom",
			name: "selectgoodroom",
			meta: {
				title: '精选好房'
			},
			component: () => import(
				"../views/marketing/SelectGoodRoom.vue")
		},
		{
			path: "/addcustomers",
			name: "addcustomers",
			meta: {
				title: '录入客源'
			},
			component: () => import(
				"../views/customers/AddCustomers.vue")
		},
		{
			path: "/publicpools",
			name: "Publicpools",
			meta: {
				title: '公房池'
			},
			component: () => import(
				"../views/renthouse/Publicpools.vue")
		},
		{
			path: "/rentalhousing",
			name: "Rentalhousing",
			meta: {
				title: '租房管理'
			},
			component: () => import(
				"../views/renthouse/Rentalhousing.vue")
		},
		{
			path: "/add-rentalhous",
			name: "AddRentalhous",
			meta: {
				title: '租房新增'
			},
			component: () => import(
				"../views/renthouse/AddRentalhous.vue")
		},
		{
			path: "/add-rentalfollowup",
			name: "AddRentalfollowup",
			meta: {
				title: '新增跟进记录'
			},
			component: () => import(
				"../views/renthouse/AddRentalfollowup.vue")
		},
		{
			path: "/rentalfollowup",
			name: "Rentalfollowup",
			meta: {
				title: '跟进记录'
			},
			component: () => import(
				"../views/renthouse/Rentalfollowup.vue")
		},
		{
			path: "/rentalowner",
			name: "Rentalowner",
			meta: {
				title: '业主信息'
			},
			component: () => import(
				"../views/renthouse/Rentalowner.vue")
		},
		{
			path: "/find-rentalfollowup",
			name: "FindRentalfollowup",
			meta: {
				title: '查看跟进记录'
			},
			component: () => import(
				"../views/renthouse/FindRentalfollowup.vue")
		},
		{
			path: "/chakantuijian",
			name: "Chakantuijian",
			meta: {
				title: '查看推荐客源'
			},
			component: () => import(
				"../views/renthouse/Chakantuijian.vue")
		},
		{
			path: "/chakanxiangqing",
			name: "Chakanxiangqing",
			meta: {
				title: '查看详情'
			},
			component: () => import(
				"../views/renthouse/Chakanxiangqing.vue")
		},
		{
			path: "/rentalowner",
			name: "Rentalowner",
			meta: {
				title: '业主信息'
			},
			component: () => import(
				"../views/renthouse/Rentalowner.vue")
		},
		{
			path: "/find-rentalfollowup",
			name: "FindRentalfollowup",
			meta: {
				title: '查看跟进记录'
			},
			component: () => import(
				"../views/renthouse/FindRentalfollowup.vue")
		},
		{
			path: "/newhouse",
			name: "newhouse",
			meta: {
				title: '新房管理'
			},
			component: () => import(
				"../views/newhouse/NewHouse.vue")
		},
		{
			path: "/house-collection",
			name: "house-collection",
			meta: {
				title: '新房采集'
			},
			component: () => import(
				"../views/newhouse/HouseCollection.vue")
		},
		{
			path: "/house_type",
			name: "house-type",
			meta: {
				title: '户型管理'
			},
			component: () => import(
				"../views/newhouse/HouseType.vue")
		},{
			path: "/myInformation",
			name: "myInformation",
			meta: {
				tiele: '我的信息'
			},
			component: () => import(
				"../views/statistical/MyInformation.vue")
		}, {
			path: "/changePass",
			name: "changePass",
			meta: {
				tiele: '修改密码'
			},
			component: () => import(
				"../views/statistical/ChangePass.vue")
		}
	]
}, {
	path: "/login",
	name: "Login",
	meta: {
		title: '登录'
	},
	component: () => import(
		/* webpackChunkName: "login" */
		"../views/Login.vue")
}];

const router = createRouter({
	history: createWebHistory(process.env.BASE_URL),
	routes
});

router.beforeEach((to, from, next) => {
	document.title = `${to.meta.title} | vue-manage-system`;
	const role = localStorage.getItem('ms_username');
	if (!role && to.path !== '/login') {
		next('/login');
	} else if (to.meta.permission) {
		// 如果是管理员权限则可进入，这里只是简单的模拟管理员权限而已
		role === 'admin' ?
			next() :
			next('/403');
	} else {
		next();
	}
});

export default router;
