package top.piao888.spring_transaction.service;

public interface AccountService {
    /**
     *
     * @param out
     * @param in
     * @param money
     */
    public void transfer(String out,String in,Double money);
}
