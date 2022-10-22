package com.ywc.controller;


import com.ywc.domain.*;
import com.ywc.service.MenuService;
import com.ywc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;
    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestBody Role role){


        /*根据角色进行查询*/
        List<Role> allRole = roleService.findAllRole(role);

            return new ResponseResult(true,200,"响应成功",allRole);


    }

    /*查询所有的父子菜单信息*/
@RequestMapping("/findAllMenu")
    public ResponseResult findSubMenuListById(){

    //-1表示查询的所有的父子级菜单
    List<Menu> subMenuListById = menuService.findSubMenuListById(-1);

    Map<String, Object> map = new HashMap<>();
    map.put("parentMenuList",subMenuListById);


    return new ResponseResult(true,200,"响应成功",map);



}

/*根据角色Id查询关联的菜单信息id*/
@RequestMapping("/findMenuByRoleId")
public ResponseResult findMenuByRoleId(Integer roleId){

    List<Integer> menuByRoleId = roleService.findMenuByRoleId(roleId);


    return new ResponseResult(true,200,"响应成功",menuByRoleId);





}



/*为角色分配菜单*/
    @RequestMapping("/RoleContextMenu")
    public ResponseResult  RoleContextMenu(@RequestBody RoleMenuVo roleMenuVo){


        roleService.roleContextMenu(roleMenuVo);

    return new ResponseResult(true,200,"响应成功",null);
    }

    @RequestMapping("/deleteRole")
    public  ResponseResult deleteRole(Integer rid)  {

        roleService.deleteRole(rid);

        return new ResponseResult(true,200,"响应成功",null);




    }


}
