//导入bar.js文件的内容到main.js文件中
var bar= require('./bar');
//导入logic.js文件的内容到main.js文件中
var logic= require('./logic');
bar.info('Hello world!'+ logic.add(100,200));