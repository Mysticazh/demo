<template>
  <div class="forgetpwd">
    <div class="myforgetpwd" align="center">
      <h4>找回密码</h4>
      <el-form
          :model="forgetpwdForm"
          :rules="forgetpwdRules"
          ref="forgetpwdForm"
          label-width="0px"
      >
        <el-form-item label="" prop="username" style="margin-top: 10px">
          <el-row>
            <el-col :span="2">
              <span class="el-icon-s-custom"></span>
            </el-col>
            <el-col :span="22">
              <el-input
                  class="inps"
                  placeholder="请输入用户名"
                  v-model="forgetpwdForm.username"
              >
              </el-input>
            </el-col>
          </el-row>
        </el-form-item>
        <el-form-item label="" prop="name" style="margin-top: 10px">
          <el-row>
            <el-col :span="2">
              <span class="el-icon-s-custom"></span>
            </el-col>
            <el-col :span="22">
              <el-input
                  class="inps"
                  placeholder="请输入姓名"
                  v-model="forgetpwdForm.name"
              >
              </el-input>
            </el-col>
          </el-row>
        </el-form-item>
        <el-form-item style="margin-top: 55px">
          <el-button type="primary" round class="submitBtn" @click="submitForm"
          >确认

          </el-button>

        </el-form-item>
        <el-button type="primary" round class="submitBtn" @click="cancelForm"
        >返回
        </el-button>
      </el-form>
    </div>
  </div>
</template>
<script>
import { mapMutations } from "vuex";
import axios from "axios";
import router from "@/router";


export default {
  name: "forgetpwd",
  data: function () {
    return {
      forgetpwdForm: {
        username: "",
        name:"",
      },
      forgetpwdRules: {
        username: [{ required: true, message: "请输入账号", trigger: "blur" }],
        name: [{ required: true, message: "请输入姓名", trigger: "blur" }]
      },
    };
  },

  methods: {
    ...mapMutations(["changeLogin"]),
    submitForm() {
      let params = {
        username: this.forgetpwdForm.username,
        name:this.forgetpwdForm.name,
      };
      console.log(params);
      var url = "http://localhost:8081/forgetpwd";
      if (!params.username) {
        return this.$message({
          type: "error",
          message: "账号不能为空！",
        });
      }
      if (!params.name) {
        return this.$message({
          type: "error",
          message: "姓名不能为空！",
        });
      }
      else{
        axios.get(url, {
          params: params
        }).then(function (response) {
          const isSuccess = response.data;
          console.log(response);
          if (isSuccess != "") {
            router.push({
              path:'/updatepwd',
              query:{username: params.username}
            });

          }
          else {
            window.alert("用户不存在")
          }

        }).catch(function (error) {
          console.log(error);
        });
      }
    },
    cancelForm(){
      router.push('/');
    }
  },
};
</script>
<style >
.forgetpwd {
  width: 100vw;
  padding: 0;
  margin: 0;
  height: 100vh;
  font-size: 16px;
  background-position: left top;
  background-color: #242645;
  color: #fff;
  font-family: "Source Sans Pro";
  position: relative;
}

.myforgetpwd {
  width: 240px;
  height:480px;
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  margin: auto;
  padding: 50px 40px 40px 40px;
  box-shadow: -15px 15px 15px rgba(6, 17, 47, 0.7);
  opacity: 1;
  background: linear-gradient(
      230deg,
      rgba(53, 57, 74, 0) 0%,
      rgb(0, 0, 0) 100%
  );
}

.inps input {
  border: none;
  color: #fff;
  background-color: transparent;
  font-size: 12px;

}

.submitBtn {
  background-color: transparent;
  color: #39f;
  width: 200px;
}





</style>