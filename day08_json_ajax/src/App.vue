<template>
  <div>
        <h1>axios和json综合</h1>
        <input type="button" value="请求和响应都是普通字符串" @click="method01()"> <br>
        <input type="button" value="响应数据改成json字符串" @click="method02()"> <br>
        <input type="button" value="请求数据也改成json字符串" @click="method03()"> <br>
        <hr>
        <h3>好友列表</h3>
        <div id="messageDiv"></div>
        <table width="500px" cellspacing="0px" cellpadding="5px" border="1px" id="myTable">
            <tr>
                <!-- <th>id</th> -->
                <th>name</th>
                <th>password</th>
            </tr>
            <!-- <tr>
                <td></td>
                <td></td>
                <td></td>
            </tr>-->
        </table>
  </div>
       
</template>

<script>
import axios from 'axios'
export default {
  methods: {
    //1.请求和响应都是普通字符串
    method01(){
       let url="/ajaxJsonTest01Servlet";
       let params="username=白岩&password=123456";
       axios.post(url,params)
            .then(resp=>{
              console.log(resp.data);
            });
    },
    //2.请求是普通字符串，响应数据改成json字符串
    method02(){
      let url="/ajaxJsonTest02Servlet";
       let params="username=白岩&password=123456";
       axios.post(url,params)
            .then(resp=>{
              console.log(resp.data);
            });
    },
    //3.请求是json字符串，响应数据改成json字符串
    // method03(){
    //   let url="/ajaxJsonTest03Servlet";
    //   let params="{\"name\":\"白岩\",\"password\":\"1234\"}";
    //   axios.post(url,params)
    //         .then(resp=>{
    //           //console.log(resp.data);
    //           let arr=resp.data;
    //           let content="";
    //           for(let obj of arr){
    //             content=content+`<tr>
    //                               <td>${obj.name}</td>
    //                               <td>${obj.password}</td>
    //                             </tr>`
    //           }
    //           console.log(content);
    //           document.getElementById("myTable").innerHTML+=content;
    //         });
    // }

    method03(){
      let url="/ajaxJsonTest04Servlet";
      let params="{\"name\":\"白岩\",\"password\":\"1234\"}";
      axios.post(url,params)
            .then(resp=>{
              //console.log(resp.data);
             let obj=resp.data;
             if(obj.flag){
              document.getElementById("messageDiv").innerHTML=obj.message;
              document.getElementById("messageDiv").style.color="red";
              let arr=obj.valueData;
              let content="";
              for(let u of arr){
                content=content+`<tr>
                                  <td>${u.name}</td>
                                  <td>${u.password}</td>
                                </tr>`
              }
              console.log(content);
              document.getElementById("myTable").innerHTML+=content;
             }else{
              document.getElementById("messageDiv").innerHTML=obj.message;
             }
            });
    }
  }
}
</script>

<style>

</style>
