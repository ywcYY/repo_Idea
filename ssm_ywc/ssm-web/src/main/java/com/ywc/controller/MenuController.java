package com.ywc.controller;

import com.ywc.domain.Menu;
import com.ywc.domain.ResponseResult;
import com.ywc.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

@RequestMapping("/menu")
public class MenuController {


    @Autowired
    private MenuService menuService;

    public ResponseResult findALlMenu(){

        List<Menu> allMenu = menuService.findAllMenu();


        return  new ResponseResult(true,200,"响应成功",allMenu);


    }

    //會先菜單信息
    public  ResponseResult findAllMenuById(Integer id) {

        /*根据Id的值判断是更新还是新增操作*/

        if (id == 1) {
            List<Menu> subMenuListById = menuService.findSubMenuListById(id);

            Map<String, Object> map = new HashMap<>();
            map.put("menuInfo", null);
            map.put("parentMenuList", subMenuListById);


            return new ResponseResult(true, 200, "响应成功", map);


        } else {

            //修改操作，回显所有的menu信息
            Menu menu =menuService.findMenuById(id);
            List<Menu> subMenuListById = menuService.findSubMenuListById(-1);
            //封装数据
            Map<String, Object> map = new HashMap<>();
            map.put("menuInfo", null);
            map.put("parentMenuList",   subMenuListById);
            return new ResponseResult(true, 200, "响应成功", map);



        }

    }




}
