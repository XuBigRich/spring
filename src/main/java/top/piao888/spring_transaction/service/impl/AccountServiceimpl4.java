package top.piao888.spring_transaction.service.impl;


import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.piao888.spring_transaction.Dao.AccountDao;
import top.piao888.spring_transaction.service.AccountService;

/**
 * 声明式事务管理:使用注解的方式（更高端）
 */
/*
* @Transactional  注解属性详解
*               propagation :事务传播行为
*               isolation   :事务隔离级别
*               readOnly   :是否只读
*               rollbackfor:发生哪些异常回滚
*               norollbackfor:发生哪些异常不回滚
*               timeout     :过期信息
* */
@Transactional(propagation=Propagation.REQUIRED,readOnly = false,isolation = Isolation.DEFAULT)
public class AccountServiceimpl4 implements AccountService {
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
