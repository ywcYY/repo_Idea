package com.ywc.service;

import com.ywc.domain.Menu;

import java.util.List;

public interface  MenuService {

    public List<Menu> findSubMenuListById(int pid);


    /*查询所有带单信息*/


    public List<Menu> findAllMenu();


    Menu findMenuById(Integer id);

}
