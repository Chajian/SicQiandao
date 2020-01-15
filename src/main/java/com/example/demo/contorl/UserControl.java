package com.example.demo.contorl;

import com.example.demo.common.Result;
import com.example.demo.common.ResultCode;
import com.example.demo.data.User;
import com.example.demo.util.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserControl {

    @PostMapping(value = "register")
    public Result Register(String account, String pass, String photo, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(MyBatis.getMyBatis().getQiandao().getUser(account)==null) {
            User user = new User();
            user.setAccount(account);
            user.setPass(pass);
            user.setWecharnummber(photo);
            user.setScore(0);
            user.setWechatname(account);
            MyBatis.getMyBatis().getQiandao().addUser(user);
            MyBatis.getMyBatis().commit();
            return ResultUtil.success(null,ResultCode.success);
        }
        return ResultUtil.fail();
    }

    @PostMapping(value = "login")
    public Result login(String account,String pass,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        Boolean success = MyBatis.getMyBatis().getQiandao().login(account,pass);
        if(success!=null&&success) {
            return ResultUtil.success(MyBatis.getMyBatis().getQiandao().getUser(account).getId(),ResultCode.USER_UID);
        }
        return ResultUtil.fail();
    }

}
