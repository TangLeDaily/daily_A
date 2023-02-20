<template>
  <div style="height: 64px; line-height: 64px; border-bottom: 1px solid #ccc; display: flex ">
    <div>
      <el-button style="margin-left: 20px; height: 50px; width: 50px" @click="leftDrawer = true">
        <el-icon style="font-size: 16px;"><more /></el-icon>
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
    <el-drawer v-model="rightDrawer" size="128px" title="I am the title" :with-header="false">
      <el-menu class="el-menu-vertical-demo" style="border-right: 0;">
        <el-menu-item index="1" style="padding: 0px; height: 100px;width: 100px;">
          <el-avatar :src="profilePicture" size="large" style="margin: 0 auto;height: 100px;width: 100px"></el-avatar>
        </el-menu-item>
        <el-menu-item index="2" style="padding: 0px;height: 100px;width: 100px">
          <span style="margin: 0 auto;color: dodgerblue;font-weight :bold; font-size: 20px">{{name}}</span>
        </el-menu-item>
        <el-menu-item index="3" style="padding: 0px;height: 64px;width: 80px">
          <el-icon style="font-size: 16px;"><chat-dot-square /></el-icon>
          <span style="margin: 0 auto;font-size: 20px">Message</span>
        </el-menu-item>
        <el-menu-item index="4" style="padding: 0px;height: 64px;width: 80px">
          <el-icon style="font-size: 16px;"><mostly-cloudy /></el-icon>
          <span style="margin: 0 auto;font-size: 20px">Center</span>
        </el-menu-item>
        <el-menu-item index="5" style="padding: 0px;height: 64px;width: 80px">
          <el-icon style="font-size: 16px;"><star /></el-icon>
          <span style="margin: 0 auto;font-size: 20px">Favorite</span>
        </el-menu-item>

        <el-menu-item index="6" style="padding: 0px;height: 64px;width: 80px">
          <el-icon style="font-size: 16px;"><lock /></el-icon>
          <span style="margin: 0 auto;font-size: 20px">security</span>
        </el-menu-item>
        <el-menu-item index="7" style="padding: 0px;height: 64px;width: 80px">
          <el-icon style="font-size: 16px;"><setting /></el-icon>
          <span style="margin: 0 auto;font-size: 20px">setting</span>
        </el-menu-item>
        <el-menu-item index="8" style="padding: 0px;height: 64px;width: 80px" @click="logout">
          <el-icon style="font-size: 16px;"><key /></el-icon>
          <span style="margin: 0 auto;font-size: 20px">logout</span>
        </el-menu-item>
      </el-menu>
    </el-drawer>
    <el-dialog title="登录" v-model="loginVisible" width="384px" center="true" @close="loginDialogClose()" append-to-body="true">
      <el-form :model="form" label-width="20%"  label-position="right">
        <el-form-item  label="用户名" size="large">
          <el-input v-model="form.username" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="密码" size="large">
          <el-input v-model="form.password" style="width: 80%" show-password="true"></el-input>
        </el-form-item>
        <el-form-item size="large">
          <el-button @click="login()" style="width: 80%">登录</el-button>
        </el-form-item>
        <el-form-item size="large">
          <el-button @click="forgetShow" style="margin-right: 0%;width: 40%" type="primary" plain >
            忘记密码
          </el-button >
          <el-button @click="registerShow()" style="margin-left: 0%;width: 40%" type="primary" plain>
            去注册
            <el-icon><right /></el-icon>
          </el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <el-dialog title="忘记密码" v-model="forgetVisible" width="384px" center="true" @close="forgetDialogClose()" append-to-body="true">
      <el-form :model="forgetForm" label-width="20%" label-position="right">
        <el-form-item label="用户名">
          <el-input v-model="forgetForm.username" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="邮箱">
          <el-input v-model="forgetForm.email" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="验证码">
          <el-input v-model="forgetForm.code" style="width: 40%"></el-input>
          <el-button :disabled="forgetGetCodeDisable" @click="forgetGetCode" style="width: 40%"> 获取验证码 </el-button>
          <el-tag v-show="forgetCodeShow" size="small">{{count}}</el-tag>
        </el-form-item>
        <el-form-item>
          <el-button @click="checkReal()" style="width: 80%">验证</el-button>
        </el-form-item>
        <el-form-item>
          <div style="width: 80%">
          如果你忘记了账号或者邮箱而至无法进行身份验证，请联系管理员(dailyspace@163.com)并提供一切有关信息，我们将与48小时内帮助验证身份
          </div>
        </el-form-item>
      </el-form>
    </el-dialog>
    <el-dialog title="密码重置" v-model="chongZhiVisible" width="384px" center="true" @close="chongZhiDialogClose()" append-to-body="true">
      <el-form :model="chongZhiForm" label-width="20%" label-position="right">
        <el-form-item label="密码"  required='true'>
          <el-input v-model="chongZhiForm.passwordFirst" style="width: 80%" show-password="true"></el-input>
        </el-form-item>
        <el-form-item label="再次输入"  required='true'>
          <el-input v-model="chongZhiForm.passwordSecond" style="width: 80%" show-password="true"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="chongZhi()" style="width: 80%">确定</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <el-dialog title="注册" v-model="registerVisible" width="384px" center="true" @close="registerDialogClose()" append-to-body="true">
      <el-form :model="registerForm" label-width="30%" label-position="right">
        <el-form-item label="用户名"  required='true'>
          <el-input v-model="registerForm.username" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="密码"  required='true'>
          <el-input v-model="registerForm.passwordFirst" style="width: 80%" show-password="true"></el-input>
        </el-form-item>
        <el-form-item label="再次输入"  required='true'>
          <el-input v-model="registerForm.passwordSecond" style="width: 80%" show-password="true"></el-input>
        </el-form-item>
        <el-form-item label="昵称"  required='true'>
          <el-input v-model="registerForm.name" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="手机号">
          <el-input v-model="registerForm.phone_num" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="邮箱"  required='true'>
          <el-input v-model="registerForm.email" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="验证码"  required='true'>
          <el-input v-model="registerForm.code" style="width: 40%"></el-input>
          <el-button :disabled="getCodeDisable" @click="getCode" style="width: 40%"> 获取验证码 </el-button>
          <el-tag v-show="codeShow" size="small">{{count}}</el-tag>
        </el-form-item>
        <el-form-item>
          <el-button @click="register()" style="width: 80%" type="primary">注册</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <div style="width:256px; padding-left: 20px; font-size: large ;font-weight: bold; color: blue">DailySpace</div>
    <div style="flex:1px"></div>
    <div>
      <el-button style="margin-right: 20px; height: 50px; width: 50px" @click="HeaderRightButton()">
        <el-icon style="font-size: 16px;"><User /></el-icon>
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
      forgetVisible: false,
      chongZhiVisible: false,
      count: '',
      timer: null,
      getCodeDisable: false,
      forgetGetCodeDisable: false,
      codeShow: false,
      forgetCodeShow: false,
      form: {},
      chongZhiUsername: '',
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
      forgetForm: {
        username: '',
        email: '',
        code: '',
      },
      chongZhiForm: {
        passwordFirst: '',
        passwordSecond: '',
      }
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
    forgetDialogClose(){
      this.forgetVisible = false
      this.forgetForm = {}
    },
    chongZhiDialogClose(){
      this.chongZhiVisible = false
      this.chongZhiForm = {}
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


    async checkUsernameEmail(username, email){
      let user = {
        username: username,
        email: email,
      }
      await request({
        method: 'post',
        url: "/user/checkReal",
        data: user
      }).then(async (res) => {
            if (res.code == -1) {
              ElMessage({
                showClose: true,
                message: '输入信息错误！',
                type: 'error',
              })
              return false
            } else if (res.code == -2) {
              ElMessage({
                showClose: true,
                message: '输入信息错误！',
                type: 'error',
              })
              return false
            } else if (res.code == 1) {
              if (await this.checkCode(this.forgetForm.email, this.forgetForm.code)) {
                ElMessage({
                  showClose: true,
                  message: '验证码错误！',
                  type: 'error',
                })
                return false
              }
              else{
                ElMessage({
                    showClose: true,
                    message: '验证成功！',
                    type: 'success',
                  })
                this.chongZhiUsername = this.forgetForm.username
                this.chongZhiShow()
                return true
              }
            }
          }
        )

    },
    async checkReal() {
      let is_forget_void = false
      for (const key in this.forgetForm) {
        if (this.forgetForm[key] == '') {
          //没填完
          is_forget_void = true
          break;
        }
      }
      if (is_forget_void) {
        ElMessage({
          showClose: true,
          message: '请输入必填栏所需内容',
          type: 'error',
        })
      } else {
        await this.checkUsernameEmail(this.forgetForm.username, this.forgetForm.email)
      }
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
    forgetShow(){
      this.loginDialogClose()
      this.forgetVisible = true
      this.forgetForm ={
        username: '',
        email: '',
        code: '',
      }
    },
    chongZhiShow(){
      this.forgetDialogClose()
      this.chongZhiVisible = true
      this.chongZhiForm ={
        passwordFirst: '',
        passwordSecond: '',
      }
    },
    checkEmail(email) {
      const regEmail = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
      if (email != '' && !regEmail.test(email)) {
        return false
      } else {
        return true
      }
    },
    checkUsername(){
      const regEn = /[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im
      const regCn = /[·！#￥（——）：；“”‘、，|《。》？、【】[\]]/im
      if (regEn.test(this.registerForm.username) || regCn.test(this.registerForm.username)) {
        return false
      }else {
        if(this.registerForm.username.length<5 || this.registerForm.username>16){
          return false
        }
        else{
          return true
        }
      }
    },
    checkName(){
      const regEn = /[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im
      const regCn = /[·！#￥（——）：；“”‘、，|《。》？、【】[\]]/im
      if (regEn.test(this.registerForm.name) || regCn.test(this.registerForm.name)) {
        return false
      }else {
        if(this.registerForm.name.length<1 || this.registerForm.name>16){
          return false
        }
        else{
          return true
        }
      }
    },
    checkPassword(password){
      const pwdRegex = /^(?=.*[0-9])(?=.*[a-zA-Z]).{8,30}$/;
      if(!pwdRegex.test(password)){
        return false
      }
      else{
        return true
      }
    },
    checkPhoneNumber(){
      if(this.registerForm.phone_num!=null && this.registerForm.phone_num!=""){
        const regPhoneNumber = /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/
        if (!regPhoneNumber.test(this.registerForm.phone_num)){
          return false
        }
        else{
          return true
        }
      }
      else{
        return true
      }
    },
    getCode() {
      const TIME_COUNT = 60;
      if ((this.registerForm.email != '') && this.checkEmail(this.registerForm.email)) {
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
    forgetGetCode() {
      const TIME_COUNT = 60;
      if ((this.forgetForm.email != '') && this.checkEmail(this.forgetForm.email)) {
        if (!this.timer) {
          this.count = TIME_COUNT;
          console.log(this.count)
          this.forgetCodeShow = false;
          this.forgetGetCodeDisable = true
          this.timer = setInterval(() => {
            if (this.count > 0 && this.count <= TIME_COUNT) {
              this.forgetCodeShow = true;
              this.count--;
            } else {
              clearInterval(this.timer);
              this.timer = null;
              this.forgetGetCodeDisable = false
              this.forgetCodeShow = false
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
    async checkUserNameRep(username){
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
    async checkCode(email, code) {
      let dataEmailCode = {
        email: email,
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
    chongZhiSuccess(){
      this.chongZhiUsername = ''
      this.chongZhiDialogClose()
    },
    chongZhi(){
      let is_void = false
      for (const key in this.chongZhiForm) {
        if (this.chongZhiForm[key] == '' && key != 'phone_num') {
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
      else{
        if(this.chongZhiForm.passwordFirst != this.chongZhiForm.passwordSecond) {
          ElMessage({
            showClose: true,
            message: '请确定两次密码输入一致！',
            type: 'error',
          })
        }
        else{
          if(!this.checkPassword(this.chongZhiForm.passwordFirst)){
            ElMessage({
              showClose: true,
              message: '密码至少包含字母、数字，8-30位',
              type: 'error',
            })
          }
          else{
            const chognZhiUser ={
              username: this.chongZhiUsername,
              password: this.chongZhiForm.passwordFirst,
            }
            request({
              method: 'post',
              url: "/user/chongZhi",
              data: chognZhiUser
            })
            ElMessage({
              showClose: true,
              message: '重置密码成功！',
              type: 'success',
            })
            this.chongZhiSuccess()
          }
        }
      }
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
      else{//不为空，开始check
        if(!this.checkUsername()){
          ElMessage({
            showClose: true,
            message: '用户名不得包含特殊字符且长度在5-16之间',
            type: 'error',
          })
        }
        else if(await this.checkUserNameRep(this.registerForm.username)){
          ElMessage({
            showClose: true,
            message: '用户名已存在！',
            type: 'error',
          })
        }
        else if(!this.checkPassword(this.registerForm.passwordFirst)){
          ElMessage({
            showClose: true,
            message: '密码至少包含字母、数字，8-30位',
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
        else if(!this.checkName()){
          ElMessage({
            showClose: true,
            message: '昵称不得包含特殊字符且长度在1-16之间',
            type: 'error',
          })
        }
        else if(!this.checkPhoneNumber()){
          ElMessage({
            showClose: true,
            message: '请确定手机号格式正确',
            type: 'error',
          })
        }
        else if(!this.checkEmail(this.registerForm.email)){
          ElMessage({
            showClose: true,
            message: '请确定邮箱格式正确',
            type: 'error',
          })
        }
        else if (await this.checkCode(this.registerForm.email, this.registerForm.code)) {
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
      }
    },
  },
}

</script>


<style scoped>
.label_mid.el-form-item__label{
  font-size: 32px;
}
</style>