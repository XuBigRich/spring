package top.piao888.spring_transaction.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import top.piao888.spring_transaction.Dao.AccountDao;
import top.piao888.spring_transaction.Dao.impl.AccountDaoimpl;
import top.piao888.spring_transaction.service.AccountService;
/*
*事务管理：编程式
* */
public class AccountServiceimpl implements AccountService {
    private AccountDao accountDao;
    @Autowired
    private TransactionTemplate transactionTemplate;
    public void transfer(final String out,final String in,final Double money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                    @Override
                    protected void doInTransactionWithoutResult(TransactionStatus status) {
                        accountDao.outMoney(out,money);
                        int i=1/0;            //人工 制造 异常 。  测试 添加事务管理后 是否会 会回滚事务
                        accountDao.inMoney(in,money);
                    }}
        );
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public TransactionTemplate getTransactionTemplate() {
        return transactionTemplate;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }
}
