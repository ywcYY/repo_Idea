package com.ywc.controller;

import com.github.pagehelper.PageInfo;
import com.ywc.domain.ResponseResult;
import com.ywc.domain.User;
import com.ywc.domain.UserVo;
import com.ywc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody UserVo userVo){

        PageInfo allUserByPage = userService.findAllUserByPage(userVo);
        return new ResponseResult(true,200,"响应成功",allUserByPage);


    }

@RequestMapping("/login")
    public ResponseResult login(User user, HttpServletRequest request) throws Exception {

    User login = userService.login(user);

    if(login != null ){

        //保存用户id及access——token到session中
        HttpSession session = request.getSession();
        String s = UUID.randomUUID().toString();

        session.setAttribute("access_token",s);
        session.setAttribute("user_id",login.getId());
        //将信息反映给前台
        Map<String, Object> map = new HashMap<>();
        map.put("access_token",s);
        map.put("user_id",login.getId());
        return new ResponseResult(true,200,"响应成功",map);



    }else{


        return new ResponseResult(false,100,"失败",null);
    }


}




}
