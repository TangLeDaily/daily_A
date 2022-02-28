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
        <el-menu-item index="8" style="padding: 0px;">
          <el-icon><key /></el-icon>
          <span style="margin: 0 auto;">logout</span>
        </el-menu-item>
      </el-menu>
    </el-drawer>
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
import { User, More, ArrowLeft ,ArrowRight, Lock, Setting, ChatDotSquare, MostlyCloudy, Star, Key } from "@element-plus/icons-vue";
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
    }
  },
  methods:{
    HeaderRightButton(){
      if (getCookie('username')== null) {
        console.log("登录！！！")
      }
      else{
        this.rightDrawer = true
      }
    }
  }
}

</script>


<style scoped>

</style>