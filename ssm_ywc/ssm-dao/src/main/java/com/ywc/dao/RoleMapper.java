package com.ywc.dao;

import com.ywc.domain.Role;
import com.ywc.domain.Role_menu_relation;

import java.util.List;

public interface RoleMapper {

    /*查询所有角色*/


    public List<Role> findAllRole(Role role);

    /*根据角色Id查询该角色关联的菜单信息Id   [1,2,3,4]*/


    public List<Integer> findMenuByRoleId(Integer roleId);


    /*根据角色Id清空中间关联表的关系*/

    public void deleteRoleContextMenu(Integer id);


    /*为角色分配菜单信息*/


    public void roleContextMenu(Role_menu_relation role_menu_relation);


    /*删除角色*/
     public void deleteRole(Integer rid);


}
