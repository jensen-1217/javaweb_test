// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
//导入element
import ElementUI from 'element-ui'
//导入element的css样式
import 'element-ui/lib/theme-chalk/index.css'
import App from './App'
import router from './router'

//让Vue对象使用
Vue.use(ElementUI)
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
