package top.piao888.spring_jdbcTemplate.dao;


import top.piao888.spring_jdbcTemplate.domain.UserAuth;

import java.util.List;


public interface UserMapper {
    public void addUser(UserAuth user);
    public void delete(Long id);
    public UserAuth findById(Long id);
    public void update(UserAuth user);
    public List<UserAuth> all();
}
