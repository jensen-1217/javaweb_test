//在js脚本文件中书写js代码
 //1. 验证 用户名是否符合规则：长度 6~12,单词字符组成
 function checkUsername(){
    let usernameValue=document.getElementById("username").value;
    let reg=/^\w{6,12}$/;
    let usernameFlag=reg.test(usernameValue);
    let username_errDisplay=document.getElementById("username_err")
    if(usernameFlag){
        username_errDisplay.style.display="none";
        return true;
    }else{
        username_errDisplay.style.display="inline";
        return false;
    };
   };

    //2. 验证 密码是否符合规则:长度 6~12任意字符
    function checkPassword(){
        let passwordValue=document.getElementById("password").value;
        let reg=/^.{6,12}$/;
        let passwordFlag=reg.test(passwordValue);
        let password_errDisplay=document.getElementById("password_err")
        if(passwordFlag){
            password_errDisplay.style.display="none";
            return true;
        }else{
            password_errDisplay.style.display="inline";
            return false;
        };
    };


    //3. 验证 手机号是否符合规则：长度 11，数字组成，第一位是1
    function checkTel(){
        let telValue=document.getElementById("tel").value;
        let reg=/^1[356789]\d{9}$/;
        let telFlag=reg.test(telValue);
        let tel_errDisplay=document.getElementById("tel_err")
        if(telFlag){
            tel_errDisplay.style.display="none";
            return true;
        }else{
            tel_errDisplay.style.display="inline";
            return false;
        };
    };


    //4. 表单是否可以提交
   document.getElementById("reg-form").onsubmit=function(){
    return checkPassword() && checkUsername() && checkTel();
   };