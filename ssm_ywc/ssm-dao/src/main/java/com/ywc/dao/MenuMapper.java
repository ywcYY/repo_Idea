package com.ywc.dao;

import com.ywc.domain.Menu;

import java.util.List;

public interface MenuMapper {


    /*查询所有的父子菜单信息*/


    public List<Menu> findSubMenuListById(int pid);

    /*查询所有菜单信息*/

    public List<Menu> findAllMenu();

   Menu findMenuById(Integer id);

}


