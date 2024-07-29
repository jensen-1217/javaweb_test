// 方式1
import {add,remove} from './lib.js';
add();
remove();

//方式2：  还可以写成
// import jsApi from './lib.js'  // 使用这种方式 ，必须要使用export default {} 导出
// jsApi.add()
// jsApi.remove()