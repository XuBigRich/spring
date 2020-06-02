package top.piao888.spring_transaction.service.impl;

import lombok.Getter;
import lombok.Setter;
import top.piao888.spring_transaction.Dao.AccountDao;
import top.piao888.spring_transaction.service.AccountService;

/**
 * 声明式事务管理:使用原始TransactionProxyFactoryBean方式
 */
public class AccountServiceimpl2 implements AccountService {
    @Setter
    @Getter
    private AccountDao accountDao;
    @Override
    public void transfer(String out, String in, Double money) {
        accountDao.outMoney(out,money);
        //int i=1/0;            //人工 制造 异常 。  测试 添加事务管理后 是否会 会回滚事务
        accountDao.inMoney(in,money);
    }
}
