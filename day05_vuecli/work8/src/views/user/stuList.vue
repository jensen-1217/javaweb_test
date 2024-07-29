<template>
  <div id="div">
    <b style="color: red; font-size: 20px;">学生列表</b>
    <div style="float: right;">
        <el-button type="primary" @click="showAddStu">添加学生</el-button>
    </div>
    <el-table :data="tableData">
        <el-table-column prop="number" label="学号" width="120">
        </el-table-column>
        <el-table-column prop="name" label="姓名" width="120">
        </el-table-column>
        <el-table-column prop="birthday" label="生日" width="140">
        </el-table-column>
        <el-table-column prop="address" label="地址">
        </el-table-column>
        <el-table-column label="操作" width="180">
          <template slot-scope="props">
              <!--
                props.row 表示当前行数据
              -->
              <el-button type="warning" @click="showEditStu(props.row)">编辑</el-button>
              <el-button type="danger" @click="deleteStu(props.row)">删除</el-button>
          </template>
        </el-table-column>
    </el-table>

    <!--
        分页组件
          @size-change： 当改变每页条数时触发的函数
          @current-change：当改变页码时触发的函数
          current-page ：默认的页码
          :page-sizes：每页条数选择框中显示的值
          :page-size : 默认的每页条数
          layout： 分页组件的布局
              total（总条数）, sizes(每页条数), prev（上一页）, pager(所有的页码), next(下一页), jumper（跳转页码）
          :total: 总条数
    -->
    <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="pagination.currentPage"
            :page-sizes="[3,5,8]"
            :page-size="pagination.pageSize"
            layout="total, sizes, prev, pager, next, jumper"
            :total="pagination.total">
    </el-pagination>

    <el-dialog title="添加学生信息" :visible.sync="dialogTableVisible4add"
               @close="resetForm('addForm')">
        <!--
            :model="formData": 关联数据
            :rules: 关联校验规则
            ref： 在获取表单对象时使用
        -->
        <el-form :model="formData" :rules="rules" ref="addForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="学生学号" prop="number">
                <el-input v-model="formData.number"></el-input>
            </el-form-item>
            <el-form-item label="学生姓名" prop="name">
                <el-input v-model="formData.name"></el-input>
            </el-form-item>
            <el-form-item label="学生生日" prop="birthday">
                <!--v-model : 双向绑定 -->
                <el-input v-model="formData.birthday" type="date"></el-input>
            </el-form-item>
            <el-form-item label="学生地址" prop="address">
                <el-input v-model="formData.address"></el-input>
            </el-form-item>
            <el-form-item align="right">
                <el-button type="primary" @click="addStu()">添加</el-button>
                <el-button @click="resetForm('addForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-dialog>
    <el-dialog title="编辑学生信息" :visible.sync="dialogTableVisible4edit" @close="resetForm('editForm')"
     >
        <!--
            :model="formData": 关联数据
            :rules: 关联校验规则
            ref： 在获取表单对象时使用
        -->
        <el-form :model="editFormData" :rules="rules" ref="editForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="学生学号" prop="number">
                <el-input v-model="editFormData.number"></el-input>
            </el-form-item>
            <el-form-item label="学生姓名" prop="name">
                <el-input v-model="editFormData.name"></el-input>
            </el-form-item>
            <el-form-item label="学生生日" prop="birthday">
                <!--v-model : 双向绑定 -->
                <el-input v-model="editFormData.birthday" type="date"></el-input>
            </el-form-item>
            <el-form-item label="学生地址" prop="address">
                <el-input v-model="editFormData.address"></el-input>
            </el-form-item>

            <el-form-item align="right">
                <el-button type="warning" @click="updateStu()">修改</el-button>
            </el-form-item>
        </el-form>
    </el-dialog>
</div>
</template>

<script>
import axios from 'axios'
// 数据定义和后端交互部分
export default {
    data () {
        return {
            dialogTableVisible4add: false,  //添加窗口显示状态
            dialogTableVisible4edit: false, //编辑窗口显示状态
            formData:{},//添加表单的数据
            editFormData: {},//编辑表单的数据
            tableData:[],//表格数据
            pagination: {
                currentPage: 1, //当前页
                pageSize: 5,    //每页显示条数
                total: 0        //总条数
            },
            rules: {
                number: [
                    {required: true, message: '请输入学号', trigger: 'blur'},
                    {min: 2, max: 10, message: '长度在 2 到 10 个字符', trigger: 'blur'}
                ],
                name: [
                    {required: true, message: '请输入姓名', trigger: 'blur'},
                    {min: 2, max: 10, message: '长度在 2 到 10 个字符', trigger: 'blur'}
                ],
                birthday: [
                    {required: true, message: '请选择日期', trigger: 'change'}
                ],
                address: [
                    {required: true, message: '请输入地址', trigger: 'blur'},
                    {min: 2, max: 200, message: '长度在 2 到 200 个字符', trigger: 'blur'}
                ],
            }
        }
    },
        methods:{
            //TODO : 删除功能
            deleteStu : function(row){
                var result = confirm(`你真的要删除${row.name}吗?`);
                if(!result){
                    return;
                }
                let url = "/student/deleteStu"
                let param = `number=${row.number}`
                axios.post(url,param).then(response=>{
                    if(response.data.flag){
                        this.$message.success(response.data.message)
                    }else{
                        this.$message.error(response.data.message)
                    }
                }).finally(()=>{
                    this.selectByPage()
                })

            },
            //TODO : 修改功能
            updateStu : function(){
                let url = "/student/updateStu"
                let param = this.editFormData
                axios.post(url,param).then(response=>{
                    // console.log(response.data);
                    if(response.data.flag){
                        this.$message.success(response.data.message)
                        this.dialogTableVisible4edit = false // 添加成功隐藏弹出框
                    }else{
                        this.$message.error(response.data.message)
                    }
                }).finally(()=>{
                    this.selectByPage()
                })
            },
            //TODO: 添加功能
            addStu : function(){
                let url = "/student/addStu"
                let param = this.formData
                axios.post(url,param).then(response=>{
                    // console.log(response.data);
                    if(response.data.flag){
                        this.$message.success(response.data.message)
                        this.dialogTableVisible4add = false // 添加成功隐藏弹出框
                    }else{
                        this.$message.error(response.data.message)
                    }
                }).finally(()=>{
                    this.selectByPage()
                })
            },
            //TODO: 分页查询
            selectByPage : function(){
                let url = "/student/selectByPage"
               /* let param = {
                    currentPage : this.pagination.currentPage,
                    pageSize : this.pagination.pageSize
                }*/
               let param = this.pagination; //多一个total
                axios.post(url,param).then(response=>{
                    // console.log(response.data);
                    if(response.data.flag){
                        this.tableData = response.data.result.rows
                        this.pagination.total = response.data.result.total
                    }else{
                        this.$message.error(response.data.message)
                    }
                })
            },
            //改变每页条数时执行的函数
            handleSizeChange(pageSize) {
                //修改分页查询的参数
                this.pagination.pageSize = pageSize;
                //重新执行查询
                this.selectByPage();
            },
            //改变页码时执行的函数
            handleCurrentChange(pageNum) {
                //修改分页查询的参数
                this.pagination.currentPage = pageNum;
                //重新执行查询
                this.selectByPage();
            },
            showAddStu() {
                //弹出窗口
                this.dialogTableVisible4add = true;
            },
            resetForm(addForm) {
                //双向绑定，输入的数据都赋值给了formData， 清空formData数据
                this.formData = {};
                //清除表单的校验数据
                this.$refs[addForm].resetFields();
            },
            showEditStu(row) {
                //1. 弹出窗口
                this.dialogTableVisible4edit = true;
                console.log(row);
                //2. 显示表单数据
                this.editFormData = {
                    number:row.number,
                    name:row.name,
                    birthday:row.birthday,
                    address:row.address,
                }
                // this.editFormData = row
            }
        },
        created(){
            // console.log("xx");
            this.selectByPage();
        }
}
</script>

<style>
/* 样式部分 */
</style>