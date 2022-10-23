package com.ywc.service;

import com.ywc.domain.Account;

import java.util.List;

public interface AccountService {
    public List<Account> findAll();
    public void save(Account account);

    Account findById(Integer id);

    void update(Account account);

    void deleteBatch(Integer[] ids);
}
