import { createApp } from 'vue'

import App from './App.vue'
import router from './router'
import store from './store'
import 'element-plus/dist/index.css'
import '@/assets/css/global.css'
import { getCookie, setCookie, delCookie } from './utils/cookie'

//Vue.use(VueCookies)
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
//统一导入el-icon图标
import * as ElIconModules from '@element-plus/icons-vue'

const app = createApp(App)
app.config.globalProperties.getCookie = getCookie
app.config.globalProperties.setCookie = setCookie
app.config.globalProperties.delCookie = delCookie

app.use(store).use(router).use(ElementPlus).mount('#app')
// 统一注册el-icon图标