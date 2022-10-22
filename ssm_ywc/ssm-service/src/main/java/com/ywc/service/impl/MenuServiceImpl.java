package com.ywc.service.impl;

import com.ywc.dao.MenuMapper;
import com.ywc.domain.Menu;
import com.ywc.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;


    @Override
    public List<Menu> findSubMenuListById(int pid) {

        List<Menu> subMenuListById = menuMapper.findSubMenuListById(pid);
       return  subMenuListById;


    }

    @Override
    public List<Menu> findAllMenu() {
        List<Menu> allMenu = menuMapper.findAllMenu();
        return allMenu;
    }

    @Override
    public Menu findMenuById(Integer id) {


        return  menuMapper.findMenuById(id);

    }
}
