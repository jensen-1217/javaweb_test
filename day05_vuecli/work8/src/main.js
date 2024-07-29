// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

 // 导入组件库
 import ElementUI from 'element-ui';
 // 导入组件相关样式
 import 'element-ui/lib/theme-chalk/index.css';
 // 配置 Vue 插件
 Vue.use(ElementUI);

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
