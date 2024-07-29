import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import friend from '@/views/friend'
import element from '@/views/element'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path:'/friend',
      name:'friend',
      component:friend
    },
    {
      path:'/element',
      name:'element',
      component:element
    }
  ]
})
