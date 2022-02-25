<template>
  <div style="height: 3Rem; line-height: 3rem; border-bottom: 1px solid #ccc; display: flex ">
    <el-button type="primary" style="margin-left: 16px" @click="drawer = true">
      open
    </el-button>
    <el-drawer v-model="drawer" title="I am the title" :with-header="false">
      <span>Hi there!</span>
    </el-drawer>
    <div style="width:200px; padding-left: 1rem; font-weight: bold; color: blue">DailySpace</div>
    <div style="flex:1px"></div>
    <div style="width:200px">bbb</div>
  </div>

</template>

<script>
export default {
  name: "Header"
}

import { ref } from 'vue'
const drawer = ref(false)

</script>


<style scoped>

</style>