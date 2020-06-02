package top.piao888.spring_transaction.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import top.piao888.spring_transaction.Dao.AccountDao;
import top.piao888.spring_transaction.service.AccountService;

/**
 * 声明式事务管理:使用配置的方式（更高端）
 */
public class AccountServiceimpl3 implements AccountService {
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
