// 方式1
let add=function(){
    console.log('add...');
}
let remove=function(){
    console.log('remove...');
}
export {add,remove}


// 方式2： 还可以写成
// export default {
//     add(){
//         console.log('add...');
//     },
//     remove(){
//         console.log('remove...');
//     }
// }