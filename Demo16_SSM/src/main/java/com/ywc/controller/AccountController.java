package com.ywc.controller;


import com.alibaba.druid.sql.dialect.sqlserver.visitor.MSSQLServerExportParameterVisitor;
import com.ywc.domain.Account;
import com.ywc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    /*查询所有用户*/
@Autowired
private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        //实现查询所有账户
/*
        ArrayList<Account> list = new ArrayList<Account>();
        Account account = new Account();
        account.setId(1);
        account.setMoney(1000d);
        account.setName("张三");


        Account account2 = new Account();
        account2.setId(2);
        account2.setMoney(2000d);
        account2.setName("李四");
        list.add(account);
        list.add(account2);
*/




        List<Account> list = accountService.findAll();
        /*把封装好的list存到model中*/
        model.addAttribute("list",list);
        return "list";/*逻辑视图*/



    }
    @RequestMapping("/save")
    public String save(Account account){
        accountService.save(account);
        //跳转到findAll方法重新查询一次数据库进行数据的遍历展示

        return "redirect:/account/findAll";




    }
    @RequestMapping("/findById")
    public String findById(Integer id,Model model){
        Account account = accountService.findById(id);
     //存到java中
        model.addAttribute("account",account);


        return "update";




    }

    @RequestMapping("/update")
    public String update(Account account){
        accountService.update(account);
        return "redirect:/account/findAll";


    }
    @RequestMapping("/deleteBatch")
    public  String delete(Integer[] ids){

        accountService.deleteBatch(ids);

    return "redirect:/account/findAll";


    }






}
