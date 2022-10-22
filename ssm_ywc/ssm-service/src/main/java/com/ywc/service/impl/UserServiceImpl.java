package com.ywc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywc.dao.UserMapper;
import com.ywc.domain.User;
import com.ywc.domain.UserVo;
import com.ywc.service.UserService;
import com.ywc.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {



@Autowired
    private UserMapper userMapper;
    @Override
    public PageInfo findAllUserByPage(UserVo userVo) {

        PageHelper.startPage(userVo.getCurrentPage(),userVo.getPageSize());
        List<User> allUserPage = userMapper.findAllUserPage(userVo);
        PageInfo<User> userPageInfo = new PageInfo<>(allUserPage);
        return  userPageInfo;


    }

    @Override
    public User login(User user) throws Exception {

        User user1 = userMapper.login(user);

            if (user1 !=null&& Md5.verify(user.getPassword(),"lagou",user1.getPassword())){
            return  user1;}
            else{
                return null;

                    }



    }
}
