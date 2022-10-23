package com.ywc.service.impl;

import com.ywc.dao.AccountDao;
import com.ywc.domain.Account;
import com.ywc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountDao accountDao;

    public List<Account> findAll() {
        List<Account> all = accountDao.findAll();
        return all;
    }

    public void save(Account account){
        accountDao.save(account);

    }

    @Override
    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);

    }

    @Override
    public void deleteBatch(Integer[] ids) {
        accountDao.deleteBatch(ids);
    }


}
