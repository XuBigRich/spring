package top.piao888.spring_jdbcTemplate.service;



import top.piao888.spring_jdbcTemplate.domain.UserAuth;

import java.util.List;

public interface UserService {
    //添加用户
    public List<UserAuth> all();

    public void addUser(UserAuth userAuth) ;
    public UserAuth findById(Long id) ;
    public void update(UserAuth user) ;
    public void delete(Long id);

}
