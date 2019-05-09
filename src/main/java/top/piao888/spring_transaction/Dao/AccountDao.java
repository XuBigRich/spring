package top.piao888.spring_transaction.Dao;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AccountDao.java
 * @Description TODO
 * @createTime 2019年01月24日 10:57:00
 */
public interface AccountDao {
    /**
     *
     * @param out :转出账号
     * @param money ：转出金额
     */
    public void outMoney(String out,Double money);

    /**
     *
     * @param in  ：转入账号
     * @param money ： 转出金额
     */
    public void inMoney(String in,Double money);
}
