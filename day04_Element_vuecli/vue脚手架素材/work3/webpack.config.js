var path = require("path"); // 导入 node.js 中专门操作路径的模块，固定写法
//执行webpack命令的时候会读取到module.exports中的内容
module.exports = {
    //执行webpack命令的时候,读取入口main.js，由于main.js关联bar.js和logic.js，所以会将这三个js文件合并到一个js文件中
	entry: './src/main.js', // 打包入口文件的路径
    //输出文件位置
	output: {
        //__dirname表示当前工程目录
		path: path.resolve(__dirname, './dist'),  // 输出文件的存放路径
		filename: 'bundle.js'  // 输出文件的名称
	}
};