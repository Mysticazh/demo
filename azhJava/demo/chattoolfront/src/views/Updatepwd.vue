<template>
  <div class="updatepwd">
    <div class="myupdatepwd" align="center">
      <h4>注册</h4>
      <el-form
          :model="updatepwdForm"
          :rules="updatepwdRules"
          ref="updatepwdForm"
          label-width="0px"
      >

        <el-form-item label="" prop="password">
          <el-row>
            <el-col :span="2">
              <span class="el-icon-lock"></span>
            </el-col>
            <el-col :span="22">
              <el-input
                  class="inps"
                  type="password"
                  placeholder="请输入新密码"
                  v-model="updatepwdForm.password"
              ></el-input>
            </el-col>
          </el-row>
        </el-form-item>
        <el-form-item label="" prop="confirmPassword">
          <el-row>
            <el-col :span="2">
              <span class="el-icon-lock"></span>
            </el-col>
            <el-col :span="22">
              <el-input
                  class="inps"
                  type="password"
                  placeholder="请确认新密码"
                  v-model="updatepwdForm.confirmPassword"
              ></el-input>
            </el-col>
          </el-row>
        </el-form-item>
        <el-form-item style="margin-top: 55px">
          <el-button type="primary" round class="submitBtn" @click="submitForm"
          >确认
          </el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>
<script>
import { mapMutations } from "vuex";
import axios from "axios";
import router from "@/router";


export default {
  name: "updatepwd",
  data: function () {
    return {
      updatepwdForm: {
        username: "",
        password: "",
        name:"",
        confirmPassword:"",
      },
      updatepwdRules: {
        password: [{ required: true, message: "请输入密码", trigger: "blur" }],
        confirmPassword: [{ required: true, message: "请确认密码", trigger: "blur" }]
      },
    };
  },
  methods: {
    ...mapMutations(["changeLogin"]),
    submitForm() {
      let params = {
        password: this.updatepwdForm.password,
        confirmPassword:this.updatepwdForm.confirmPassword,
        username:router.query.username
      };
      console.log(params);
      var url = "http://localhost:8081/updatepwd";
      if (!params.password || !params.confirmPassword) {
        return this.$message({
          type: "error",
          message: "密码不能为空！",
        });
      }
      if(params.password!==params.confirmPassword){
        return this.$message({
          type: "error",
          message: "两次密码不一致！",
        });
      }
      else{
        axios.get(url, {
          params: params
        }).then(function (response) {
          const isSuccess = response.data;
          if(isSuccess  === 'SUCCESS'){
            window.alert("注册成功");
            router.push("/");
          }
          if(response.data==="isExist"){
            window.alert("用户已存在！");
          }
          if(response.data==="PWD_NOT_SAME"){
            window.alert("两次密码不一致")
          }
          if(response.data==="error"){
            window.alert("注册失败！");
          }
        }).catch(function (error) {
          console.log(error);
        });
      }
      console.log("用户输入的账号为：", params.username);
      console.log("用户输入的密码为：", params.password);
    },
    cancelForm(){
      router.push('/');
    }
  },
};
</script>
<style >
.updatepwd {
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

.myupdatepwd {
  width: 240px;
  height:280px;
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