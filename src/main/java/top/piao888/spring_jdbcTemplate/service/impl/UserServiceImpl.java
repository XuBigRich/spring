package top.piao888.spring_jdbcTemplate.service.impl;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import top.piao888.spring_jdbcTemplate.dao.UserMapper;
import top.piao888.spring_jdbcTemplate.domain.UserAuth;
import top.piao888.spring_jdbcTemplate.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    @Getter
    @Setter
    private UserMapper userMapper;
    @Override
    public List<UserAuth>  all() {
        return userMapper.all();
    }
    public void addUser(UserAuth userAuth) {
        userMapper.addUser(userAuth);
    }
    public UserAuth findById(Long id) {
        UserAuth userAuth = userMapper.findById(id);
        return userAuth;
    }
    public void update(UserAuth user) {
        userMapper.update(user);
    }
    public void delete(Long id) {
        userMapper.delete(id);
    }

    public void myinit(){
        System.out.println("初始化。。。。");
    }
    public void mydestcry(){
        System.out.println("销毁关闭连接");
    }
}
