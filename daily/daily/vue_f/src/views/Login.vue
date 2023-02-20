<template>
  <el-form ref="formRef" :model="form" label-width="120px">
    <el-form-item label="Activity name">
      <el-input v-model="form.name"></el-input>
    </el-form-item>
  </el-form>
</template>

<script>
import {Edit} from "@element-plus/icons-vue";

export default {
  name: "Login",
  components: {
  },
  data(){
    return{
      form: {},
    }
  },
  methods: {
  }
}
</script>

<style scoped>

</style>