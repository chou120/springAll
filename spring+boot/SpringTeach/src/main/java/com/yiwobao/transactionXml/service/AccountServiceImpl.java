package com.yiwobao.transactionXml.service;

import com.yiwobao.transactionXml.dao.AccountDao;
import com.yiwobao.transactionXml.pojo.Account;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*如果出现异常设置不回滚,noRollbackFor = {Exception.class}  */
@Transactional(readOnly = false,propagation = Propagation.REQUIRED,noRollbackFor = {Exception.class})
public class AccountServiceImpl implements AccountService{

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public void transfer(String sourceName, String targeName, Float money) {
        // 1.根据名称查询两个账户
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targeName);
        // 2.修改两个账户的金额
        source.setMoney(source.getMoney() - money);// 转出账户减钱
        target.setMoney(target.getMoney() + money);// 转入账户加钱
        // 3.更新两个账户
        accountDao.updateAccount(source);
        //模拟异常
        int i = 1 / 0;
        accountDao.updateAccount(target);
    }
}
