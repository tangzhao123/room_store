import {createApp} from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import installElementPlus from './plugins/element'
import './assets/css/icon.css'
//导库
import VueAxios from 'vue-axios'
import axios from 'axios'

//统一的跨域前缀
axios.defaults.baseURL = 'http://localhost:8889/';
//设置默认的请求超时时间。例如超过了5s，就会告知用户当前请求超时，请刷新等。
axios.defaults.timeout = 5000;

const app = createApp(App)
installElementPlus(app)
app
    .use(store)
    .use(router)
	.use(VueAxios, axios)
    .mount('#app')