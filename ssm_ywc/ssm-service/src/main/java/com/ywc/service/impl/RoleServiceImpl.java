package com.ywc.service.impl;

import com.ywc.dao.RoleMapper;
import com.ywc.domain.Role;
import com.ywc.domain.RoleMenuVo;
import com.ywc.domain.Role_menu_relation;
import com.ywc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> findAllRole(Role role) {
        List<Role> allRole = roleMapper.findAllRole(role);


        return  allRole;


    }

    @Override
    public List<Integer> findMenuByRoleId(Integer roleId) {

        List<Integer> menuByRoleId = roleMapper.findMenuByRoleId(roleId);

        return  menuByRoleId;


    }

    @Override
    public void roleContextMenu(RoleMenuVo roleMenuVo) {



        //1.清空中间表的所有关联关系
roleMapper.deleteRoleContextMenu(roleMenuVo.getRoleId());


        //2.为角色分配菜单

        for (Integer integer : roleMenuVo.getMenuIdList()) {
            Role_menu_relation role_menu_relation = new Role_menu_relation();
            role_menu_relation.setMenuId(integer);
            role_menu_relation.setRoleId(roleMenuVo.getRoleId());



            role_menu_relation.setCreatedTime(new Date());
            role_menu_relation.setUpdatedTime(new Date());

            role_menu_relation.setCreatedBy("system");
            role_menu_relation.setUpdatedby("system");
            roleMapper.roleContextMenu(role_menu_relation);

        }




    }

    @Override
    public void deleteRole(Integer rid) {
        //调用根据roleId清空中间表关系

        roleMapper.deleteRoleContextMenu(rid);
        roleMapper.deleteRole(rid);
    }
}
