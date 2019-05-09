package top.piao888.spring_transaction.service.impl;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import top.piao888.spring_transaction.Dao.AccountDao;
import top.piao888.spring_transaction.service.AccountService;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AccountServiceimpl5.java
 * @Description TODO
 * @createTime 2019年03月22日 16:53:00
 */

public class AccountServiceimpl5 implements AccountService {
    private AccountDao accountDao;
    @Override

    public void transfer(final String out,final String in,final Double money) {
        accountDao.outMoney(out,money);
        int i=1/0;            //人工 制造 异常 。  测试 添加事务管理后 是否会 会回滚事务
        accountDao.inMoney(in,money);
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

}
