package com.yiwobao.annotation.dao;

import com.yiwobao.annotation.pojo.Account;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有
     * @return
     */
    public List<Account> findAllAccount();

    /**
     * 查询一个
     * @return
     */
    public Account findAccountById(Integer id);

    /**
     * 保存
     */
    public void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    public void updateAccount(Account account);

    /**
     * 删除
     * @param id
     */
    public void deleteAccount(Integer id);

}
