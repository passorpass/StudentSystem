<template>
  <div class="login-container">
    <el-card class="login-card">
      <div class="login-form">
        <h3 class="title">教务管理系统登录</h3>
        <el-form :model="form" ref="loginForm" :rules="rules" label-width="80px">
          <el-form-item label="用户名" prop="username">
            <el-input v-model="form.username" placeholder="请输入用户名"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input type="password" v-model="form.password" placeholder="请输入密码"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm">登录</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data() {
    return {
      form: {
        username: '',
        password: ''
      },
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    // 表单提交
    submitForm() {
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          // 发送登录请求
          this.$axios.post('/admin/login', this.form).then(res => {
            if (res.data.code === 200) {
              // 将 token 存入本地存储中
              localStorage.setItem('token', res.data.data)
              // 跳转到首页
              this.$router.push('/')
            } else {
              this.$message.error(res.data.msg)
            }
          }).catch(() => {
            this.$message.error('登录失败，请重试')
          })
        }
      })
    }
  }
}
</script>

<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  background-color: #f5f5f5;
}
.login-card {
  width: 400px;
}
.login-form {
  padding: 20px;
}
.title {
  text-align: center;
  font-size: 18px;
  margin-bottom: 20px;
}
</style>
