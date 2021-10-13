package com.yiwobao.transactionXml.dao;

import com.yiwobao.transactionXml.pojo.Account;
import com.yiwobao.transactionXml.rowMapper.AccountRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao{
    @Override
    public Account findAccountById(Integer id) {
        List<Account> list = getJdbcTemplate().query("select * from account where id = ? ",new AccountRowMapper(),id);
        return list.isEmpty()?null:list.get(0);
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> list =  getJdbcTemplate().query("select * from account where name = ? ",new AccountRowMapper(),name);
        if(list.isEmpty()){
            return null;
        }
        if(list.size()>1){
            throw new RuntimeException("结果集不唯一，不是只有一个账户对象");
        }
        return list.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        getJdbcTemplate().update("update account set money = ? where id = ? ",account.getMoney(),account.getId());
    }
}
