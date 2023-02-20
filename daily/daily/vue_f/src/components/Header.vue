<template>
  <div style="height: 3Rem; line-height: 3rem; border-bottom: 1px solid #ccc; display: flex ">
    <div>
      <el-button style="margin-left: 16px" @click="leftDrawer = true">
        <el-icon><more /></el-icon>
      </el-button>
    </div>
    <el-drawer v-model="leftDrawer" title="I am the title" :with-header="false" direction="ltr">
      <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
      >
        <el-menu-item index="2">
          <el-icon><icon-menu /></el-icon>
          <span>Navigator Two</span>
        </el-menu-item>

      </el-menu>

    </el-drawer>
    <el-drawer v-model="rightDrawer" size="30%" title="I am the title" :with-header="false">
      <el-menu class="el-menu-vertical-demo" style="border-right: 0;">
        <el-menu-item index="1" style="padding: 0px;">
          <el-avatar :src="profilePicture" size="large" style="margin: 0 auto"></el-avatar>
        </el-menu-item>
        <el-menu-item index="2" style="padding: 0px;">
          <span style="margin: 0 auto;color: dodgerblue;font-weight :bold">{{name}}</span>
        </el-menu-item>
        <el-menu-item index="3" style="padding: 0px;">
          <el-icon><chat-dot-square /></el-icon>
          <span style="margin: 0 auto;">Message</span>
        </el-menu-item>
        <el-menu-item index="4" style="padding: 0px;">
          <el-icon><mostly-cloudy /></el-icon>
          <span style="margin: 0 auto;">Center</span>
        </el-menu-item>
        <el-menu-item index="5" style="padding: 0px;">
          <el-icon><star /></el-icon>
          <span style="margin: 0 auto;">Favorite</span>
        </el-menu-item>

        <el-menu-item index="6" style="padding: 0px;">
          <el-icon><lock /></el-icon>
          <span style="margin: 0 auto;">security</span>
        </el-menu-item>
        <el-menu-item index="7" style="padding: 0px;">
          <el-icon><setting /></el-icon>
          <span style="margin: 0 auto;">setting</span>
        </el-menu-item>
        <el-menu-item index="8" style="padding: 0px;" @click="logout">
          <el-icon><key /></el-icon>
          <span style="margin: 0 auto;">logout</span>
        </el-menu-item>
      </el-menu>
    </el-drawer>
    <el-dialog title="登录" v-model="loginVisible" width="24rem" center="true" @close="loginDialogClose()">
      <el-form :model="form" label-width="5rem" label-position="right">
        <el-form-item label="用户名">
          <el-input v-model="form.username" style="width: 12rem"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="form.password" style="width: 12rem" show-password="true"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="login()">登录</el-button>
          <el-button @click="registerShow()" type="primary" plain>
            去注册
            <el-icon><right /></el-icon>
          </el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <el-dialog title="注册" v-model="registerVisible" width="24rem" center="true" @close="registerDialogClose()">
      <el-form :model="registerForm" label-width="5rem" label-position="right">
        <el-form-item label="用户名"  required='true'>
          <el-input v-model="registerForm.username" style="width: 12rem"></el-input>
        </el-form-item>
        <el-form-item label="密码"  required='true'>
          <el-input v-model="registerForm.passwordFirst" style="width: 12rem" show-password="true"></el-input>
        </el-form-item>
        <el-form-item label="再次输入"  required='true'>
          <el-input v-model="registerForm.passwordSecond" style="width: 12rem" show-password="true"></el-input>
        </el-form-item>
        <el-form-item label="昵称"  required='true'>
          <el-input v-model="registerForm.name" style="width: 12rem"></el-input>
        </el-form-item>
        <el-form-item label="手机号">
          <el-input v-model="registerForm.phone_num" style="width: 12rem"></el-input>
        </el-form-item>
        <el-form-item label="邮箱"  required='true'>
          <el-input v-model="registerForm.email" style="width: 12rem"></el-input>
        </el-form-item>
        <el-form-item label="验证码"  required='true'>
          <el-input v-model="registerForm.code" style="width: 6rem"></el-input>
          <el-button :disabled="getCodeDisable" @click="getCode"> 获取验证码 </el-button>
          <el-tag v-show="codeShow" size="small">{{count}}</el-tag>
        </el-form-item>
        <el-form-item>
          <el-button @click="register()">注册</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <div style="width:200px; padding-left: 1rem; font-weight: bold; color: blue">DailySpace</div>
    <div style="flex:1px"></div>
    <div>
      <el-button style="margin-right: 16px;" @click="HeaderRightButton()">
        <el-icon ><User /></el-icon>
      </el-button>
    </div>
  </div>

</template>

<script>
import { User, More, ArrowLeft ,ArrowRight, Lock, Setting, ChatDotSquare, MostlyCloudy, Star, Key, Right } from "@element-plus/icons-vue";

import '../main'
import request from "@/utils/request";
import {ElMessage} from "element-plus";
export default {
  name: "Header",
  components: {
    User,
    More,
    ArrowLeft,
    ArrowRight,
    Lock,
    Setting,
    ChatDotSquare,
    MostlyCloudy,
    Star,
    Key,
    Right,
  },
  data(){
    return{
      rightDrawerSize: "20%",
      leftDrawer: false,
      rightDrawer: false,
      isCollapse: false,
      handleOpen: false,
      handleClose: true,
      profilePicture: 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fku.90sjimg.com%2Felement_origin_min_pic%2F01%2F37%2F09%2F22573c3a831082c.jpg&refer=http%3A%2F%2Fku.90sjimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1648554299&t=59ed3559126946ab128e03da0acfcf25',
      name: "default",
      loginVisible: false,
      registerVisible: false,
      count: '',
      timer: null,
      getCodeDisable: false,
      codeShow: false,
      form: {},
      codeCheckFailed: false,
      registerForm: {
        username: '',
        passwordFirst: '',
        passwordSecond: '',
        name: '',
        phone_num: '',
        email: '',
        code: '',
      },
    }
  },
  methods: {
    HeaderRightButton() {
      if (this.getCookie('username') == null) {
        console.log("登录！！！")
        this.loginVisible = true
      } else {
        this.rightDrawer = true
        this.name = this.getCookie('name')
        if(this.getCookie('profilePicture')!=null) {
          console.log('sss')
          this.profilePicture = this.getCookie('profilePicture')
        }
      }
    },
    logout(){
      this.delCookie('username')
      this.delCookie('name')
      this.delCookie('profilePicture')
      ElMessage({
        showClose: true,
        message: '注销成功！',
        type: 'success',
      },)
      this.rightDrawer = false
      this.loginVisible = true
    },
    loginSuccess() {
      this.loginVisible = false
    },
    loginDialogClose() {
      this.loginVisible = false
      this.form = {}
    },
    registerDialogClose() {
      this.registerVisible = false
    },
    login() {
      request({
        method: 'post',
        url: "/user/login",
        data: this.form
      }).then((res) => {
        if (res.code == -1) {
          ElMessage({
            showClose: true,
            message: '请确认账号密码填写完整',
            type: 'error',
          })
        } else if (res.code == -2) {
          ElMessage({
            showClose: true,
            message: '账号或密码错误',
            type: 'error',
          })
        } else if (res.code == 1) {
          ElMessage({
            showClose: true,
            message: '登陆成功！',
            type: 'success',
          },)
          this.delCookie('username')
          this.delCookie('name')
          this.delCookie('profilePicture')
          this.setCookie('username', res.data.username, 7)
          this.setCookie('name', res.data.name, 7)
          if(res.data.profilePicture) {
            this.setCookie('profilePicture', res.data.profilePicture, 7)
          }
          this.loginSuccess()
        }
      })

    },

    registerShow() {
      this.loginDialogClose()
      this.registerVisible = true
      this.registerForm = {
        username: '',
        passwordFirst: '',
        passwordSecond: '',
        name: '',
        phone_num: '',
        email: '',
        code: '',
      }
    },
    checkEmail(mailAddress) {
      const regEmail = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
      if (mailAddress != '' && !regEmail.test(mailAddress)) {
        return false
      } else {
        return true
      }
    },
    getCode() {
      const TIME_COUNT = 60;
      if ((this.registerForm.email != null) && this.checkEmail(this.registerForm.email)) {
        if (!this.timer) {
          this.count = TIME_COUNT;
          console.log(this.count)
          this.codeShow = false;
          this.getCodeDisable = true
          this.timer = setInterval(() => {
            if (this.count > 0 && this.count <= TIME_COUNT) {
              this.codeShow = true;
              this.count--;
            } else {
              clearInterval(this.timer);
              this.timer = null;
              this.getCodeDisable = false
              this.codeShow = false
            }
          }, 1000)
          request({
            method: 'post',
            url: "/user/getCode",
            data: this.registerForm.email
          }).then((res) => {
            if (res.code == -1) {
              ElMessage({
                showClose: true,
                message: '发送错误',
                type: 'error',
              })
            } else if (res.code == 1) {
              ElMessage({
                showClose: true,
                message: '发送成功！',
                type: 'success',
              },)

            }

          })
        }
      } else {
        ElMessage({
          showClose: true,
          message: '请确认邮箱填写完整并且正确',
          type: 'error',
        })
      }
    },
    async checkUserName(username){
      let UserIsAlready = true
      let resualt = await request({
        method: 'post',
        url: "/user/checkUser",
        data: this.registerForm.username
      }).then((res) => {
        if (res.code == -1) {
          UserIsAlready = false
        } else if (res.code == 1) {
          UserIsAlready = true
        }
      })
      if (UserIsAlready){
        return true;
      }
      else{
        return false;
      }
    },
    async checkCode(code) {
      let dataEmailCode = {
        email: this.registerForm.email,
        code: code,
      }
      let result = await request({
        method: 'post',
        url: "/user/checkCode",
        data: dataEmailCode
      }).then((res) => {
        if (res.code == -1) {
          this.codeCheckFailed = false
        } else if (res.code == 1) {
          this.codeCheckFailed = true
        }
      })
      if(this.codeCheckFailed){
        return false
      }
      else{
        return true
      }
    },
    registerSuccess() {
      this.registerVisible = false
      this.loginVisible = true
    },
    postRegister(){
      const newRegisterForm ={
        username: this.registerForm.username,
        password: this.registerForm.passwordFirst,
        email: this.registerForm.email,
        phone_number: this.registerForm.phone_num,
        name: this.registerForm.name,
      }
      request({
        method: 'post',
        url: "/user/register",
        data: newRegisterForm
      })

      },
    async register() {
      let is_void = false
      for (const key in this.registerForm) {
        if (this.registerForm[key] == '' && key != 'phone_num') {
          //没填完
          is_void = true
          break;
        }
      }
      if (is_void) {
        ElMessage({
          showClose: true,
          message: '请输入必填栏所需内容',
          type: 'error',
        })
      }
      else if (await this.checkUserName(this.registerForm.username)){
        ElMessage({
          showClose: true,
          message: '用户名已存在！',
          type: 'error',
        })
      }
      else if (this.registerForm.passwordFirst != this.registerForm.passwordSecond) {
        ElMessage({
          showClose: true,
          message: '请确定两次密码输入一致！',
          type: 'error',
        })
      }
      else if (await this.checkCode(this.registerForm.code)) {
        ElMessage({
          showClose: true,
          message: '请确定验证码填写正确！',
          type: 'error',
        })
      }
      else {
        this.postRegister()
        ElMessage({
          showClose: true,
          message: '注册成功！',
          type: 'success',
        })
        this.registerSuccess()
      }
    },
  },
}

</script>


<style scoped>

</style>