import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AboutView from "@/views/AboutView.vue";
import Regist from "@/views/Regist.vue";
import Forgetpwd from "@/views/Forgetpwd.vue";
import Updatepwd from "@/views/Updatepwd.vue";
import Person from "@/views/Person.vue";

Vue.use(VueRouter)
// 获取原型对象push函数
const originalPush = VueRouter.prototype.push

// 获取原型对象replace函数
const originalReplace = VueRouter.prototype.replace

// 修改原型对象中的push函数
VueRouter.prototype.push = function push(location){
  return originalPush.call(this , location).catch(err=>err)
}

// 修改原型对象中的replace函数
VueRouter.prototype.replace = function replace(location){
  return originalReplace.call(this , location).catch(err=>err)
}


const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    component: AboutView,
    children: [
      {
        path: '/personal',
        component: Person
      }
    ]
  },

    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
   /* component: () => import(/!* webpackChunkName: "about" *!/ '../views/AboutView.vue')*/

  {
    path: '/register',
    name:'register',
    component: Regist
  },
  {
    path: '/forgetpwd',
    name:'forgetpwd',
    component: Forgetpwd
  },
  {
    path: '/updatepwd',
    name:'updatepwd',
    component: Updatepwd
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
