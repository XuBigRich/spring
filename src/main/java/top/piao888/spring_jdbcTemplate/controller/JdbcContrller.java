package top.piao888.spring_jdbcTemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.piao888.spring_jdbcTemplate.domain.UserAuth;
import top.piao888.spring_jdbcTemplate.service.UserService;

import java.util.List;
/*
    @RequestParam()  处理 Content-Type: application/x-www-form-urlencoded 编码格式的数据

    @ResponseBody  处理 非 Content-Type: application/x-www-form-urlencoded编码格式的数据

    */

@Controller
@RequestMapping("/jdbc")
public class JdbcContrller {
    @Autowired
    private UserService userService;
    @RequestMapping("/getAll")
    public void getAll() {
        List<UserAuth> a = userService.all();
        System.out.println(a.toString());
    }
    @RequestMapping("/addUser")
    public void addUser(UserAuth userAuth) {
        userService.addUser(userAuth);
    }
    @RequestMapping("/findById")
    public void findById(Long id) {
        UserAuth userAuth = userService.findById(id);
    }
    @RequestMapping("/update")
    public void update(UserAuth user) {
        userService.update(user);
    }
    @RequestMapping("/delete")
    public void delete(Long id) {
        userService.delete(id);
    }

}
