<template>
  <div class="home">
    HOME

    <el-button @click="showLogin()">login</el-button>
    <el-dialog title="登录" v-model="loginVisible" width="24rem" center="true">
      <el-form :model="form" label-width="5rem" label-position="right">
        <el-form-item label="用户名">
          <el-input v-model="form.username" style="width: 12rem"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="form.password" style="width: 12rem" show-password="true"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="login()">登录</el-button>
          <el-button @click="login()" type="primary" plain>
            去注册
            <el-icon><right /></el-icon>
          </el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import request from "@/utils/request";
import {ElMessage} from "element-plus";
import { Edit } from "@element-plus/icons-vue";




export default {
  name: 'HomeView',
  components: {
    Edit,
  },
  data(){
    return{
      loginVisible: false,
      form: {},
    }
  },
  methods:{
    showLogin(){
      this.loginVisible = true
      this.form={}
    },
    login(){
      request({
        method: 'post',
        url: "/user/login",
        data: this.form
      }).then((res)=> {
        if(res.code == -1){
          ElMessage({
            showClose: true,
            message: '请确认账号密码填写完整',
            type: 'error',
          })
        }
        else if(res.code == -2){
          ElMessage({
            showClose: true,
            message: '账号或密码错误',
            type: 'error',
          })
        }
        else if(res.code == 1){
          ElMessage({
            showClose: true,
            message: '登陆成功！',
            type: 'success',
          })
        }

      })

    }
  }
}
</script>
