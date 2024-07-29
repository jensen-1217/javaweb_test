<template>
  <div id="app">
    <img src="./assets/logo.png">
    <a href="#/">访问vue</a>
    <a href="#/friend">访问好友</a>
    <a href="#/element">访问element</a>
    <router-view/>
    <!-- <h1>{{ msg }}</h1> -->
  </div>
</template>

<script>
export default {
  // data(){
  //   return {
  //     msg:"脚手架很简单"
  //   }
  // }
  name: 'App'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
