package com.ywc.service;

import com.github.pagehelper.PageInfo;
import com.ywc.domain.User;
import com.ywc.domain.UserVo;

public interface UserService {

    public PageInfo findAllUserByPage(UserVo userVo);

    /*用户登录*/

    public User login(User user) throws Exception;




}
