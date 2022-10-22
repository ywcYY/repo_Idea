package com.ywc.dao;

import com.ywc.domain.User;
import com.ywc.domain.UserVo;
import com.ywc.domain.User_Role_relation;

import javax.naming.Context;
import java.util.List;

public interface UserMapper {



    /*用户分页&多条件组合查询*/

public List<User> findAllUserPage(UserVo userVo);



/*用户登录 （根据用户名·查询具体的用户信息）*/


    public User login(User user);

    /*根据用户Id清空中间表*/

    public void deleteUserContextRole(Integer userid);

    /*分配角色*/
    public void userContextRole(User_Role_relation user_role_relation);

}
