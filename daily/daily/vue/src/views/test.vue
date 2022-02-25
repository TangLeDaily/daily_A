<template>
  <el-button type="primary" style="margin-left: 16px" @click="drawer=true">
    open
  </el-button>

  <el-drawer v-model="drawer" title="I am the title" :with-header="false" direction="ltr">
    <span>Hi there!</span>
  </el-drawer>
</template>

<script>

export default {
  name: 'test',
  data() {
    return {
      drawer: false,
    }
  }
}
</script>
