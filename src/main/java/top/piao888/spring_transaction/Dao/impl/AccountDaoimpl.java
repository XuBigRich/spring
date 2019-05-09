package top.piao888.spring_transaction.Dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import top.piao888.spring_transaction.Dao.AccountDao;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AccountDao.java
 * @Description TODO
 * @createTime 2019年01月23日 17:58:00
 */
public class AccountDaoimpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate1;
    /**
     *
     * @param out :转出账号
     * @param money ：转出金额
     */
    public void outMoney(String out,Double money){
        String sql="update account set money = money - ? where name = ?";
        this.jdbcTemplate1.update(sql,money,out);
    }

    /**
     *
     * @param in  ：转入账号
     * @param money ： 转出金额
     */
    public void inMoney(String in,Double money){
        String sql="update account set money = money + ? where name = ?";
        this.jdbcTemplate1.update(sql,money,in);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate1;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate1 = jdbcTemplate;
    }
}
