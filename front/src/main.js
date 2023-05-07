import { createApp } from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios'
import './assets/css/main.css'

// eslint-disable-next-line no-undef
Vue.use(ElementUI);
// eslint-disable-next-line no-undef
Vue.prototype.$http=axios

createApp(App).mount('#app')
