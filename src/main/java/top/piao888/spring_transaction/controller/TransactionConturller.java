package top.piao888.spring_transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.piao888.spring_transaction.service.AccountService;

import javax.annotation.Resource;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Conturller.java
 * @Description TODO
 * @createTime 2019年01月24日 11:58:00
 */
@Controller
@RequestMapping("/transaction")
public class TransactionConturller {
    @Autowired
    private AccountService accountService;
    @Resource(name = "accountService2Proxy")
    private AccountService accountService2;
    @Autowired
    private AccountService accountService3;
    @Autowired
    private AccountService accountService4;
    @Autowired
    private AccountService accountService5;
    @Autowired
    private AccountService accountService6;

    @GetMapping("/account")
    public void account(@RequestParam("out") String out, @RequestParam("in") String in, @RequestParam("money") Double money) {
        accountService.transfer(out, in, money);
    }

    @GetMapping("/account2")
    public void account2(@RequestParam("out") String out, @RequestParam("in") String in, @RequestParam("money") Double money) {
        accountService2.transfer(out, in, money);
    }

    @GetMapping("/account3")
    public void account3(@RequestParam("out") String out, @RequestParam("in") String in, @RequestParam("money") Double money) {
        accountService3.transfer(out, in, money);
    }

    @GetMapping("/account4")
    public void account4(@RequestParam("out") String out, @RequestParam("in") String in, @RequestParam("money") Double money) {
        accountService4.transfer(out, in, money);
    }

    @GetMapping("/account5")
    public void account5(@RequestParam("out") String out, @RequestParam("in") String in, @RequestParam("money") Double money) {
        accountService5.transfer(out, in, money);
    }

    @GetMapping("/account6")
    public void account6(@RequestParam("out") String out, @RequestParam("in") String in, @RequestParam("money") Double money) {
        accountService6.transfer(out, in, money);
    }

    public AccountService getAccountService2() {
        return accountService2;
    }

    public void setAccountService2(AccountService accountService2) {
        this.accountService2 = accountService2;
    }
}
