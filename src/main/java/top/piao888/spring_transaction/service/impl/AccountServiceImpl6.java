package top.piao888.spring_transaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import top.piao888.spring_transaction.Dao.AccountDao;
import top.piao888.spring_transaction.domain.Account;
import top.piao888.spring_transaction.service.AccountService;

import java.util.List;

/**
 * @Author： hongzhi.xu
 * @Date: 2021/11/26 9:45 下午
 * @Version 1.0
 */
public class AccountServiceImpl6 implements AccountService {
    @Autowired
    /**
     * 事物管理器里面托管着数据库链接
     */
    private DataSourceTransactionManager dataSourceTransactionManager;

    //TransactionTemplate 是 DefaultTransactionDefinition的子类 TransactionTemplate需要设置事物管理器transactionManager
    //DefaultTransactionDefinition不需要提前在ioc中设置事物管理器
//    @Autowired
    private DefaultTransactionDefinition transactionDefinition;
    @Autowired
    private AccountDao accountDao;

    @Override
    public void transfer(String out, String in, Double money) {
        //创建一个事物
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        //设置事物的隔离级别
        int iso = DefaultTransactionDefinition.ISOLATION_DEFAULT;
        System.out.println("事物的隔离级别:" + iso);
        defaultTransactionDefinition.setIsolationLevel(iso);
        // 设置事物的传播行为
        int behavior = DefaultTransactionDefinition.PROPAGATION_REQUIRES_NEW;
        System.out.println("事物的传播行为:" + behavior);
        defaultTransactionDefinition.setPropagationBehavior(behavior);
        //获取事物的隔离级别
        System.out.println("通过方法取出的隔离级别:" + defaultTransactionDefinition.getIsolationLevel());
        //获取事物的传播行为
        System.out.println("通过方法取出的传播行为:" + defaultTransactionDefinition.getPropagationBehavior());

        //使用事物管理器对事物进行托管管理，获得一个事物相应的状态
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(defaultTransactionDefinition);
        try {
            System.out.println("判断事物是否完成1:" + transactionStatus.isCompleted());
            Account accountList = accountDao.getAccountByName(out);
            System.out.println(accountList);
            accountDao.outMoney(out, money);
            Account accountList1 = accountDao.getAccountByName(out);
            System.out.println(accountList1);
//            int i = 1 / 0;            //人工 制造 异常 。  测试 添加事务管理后 是否会 会回滚事务
            accountDao.inMoney(in, money);
            //提交
            dataSourceTransactionManager.commit(transactionStatus);
            System.out.println("判断事物是否完成2:" + transactionStatus.isCompleted());
            //重新获取到一个事物状态
            TransactionStatus transactionStatus1 = dataSourceTransactionManager.getTransaction(defaultTransactionDefinition);
            System.out.println("判断事物是否完成3:" + transactionStatus1.isCompleted());
            accountDao.inMoney(in, 1d);
            accountDao.inMoney(out, 1d);
            dataSourceTransactionManager.commit(transactionStatus1);
            System.out.println("判断事物是否完成4:" + transactionStatus1.isCompleted());
        } catch (Exception e) {
            e.printStackTrace();
            //最好是放在catch 里面,防止程序异常而事务一直卡在哪里未提交
            dataSourceTransactionManager.rollback(transactionStatus);
        }

    }

    public DataSourceTransactionManager getDataSourceTransactionManager() {
        return dataSourceTransactionManager;
    }

    public void setDataSourceTransactionManager(DataSourceTransactionManager dataSourceTransactionManager) {
        this.dataSourceTransactionManager = dataSourceTransactionManager;
    }

    public TransactionDefinition getTransactionDefinition() {
        return transactionDefinition;
    }

    public void setTransactionDefinition(DefaultTransactionDefinition transactionDefinition) {
        this.transactionDefinition = transactionDefinition;
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
