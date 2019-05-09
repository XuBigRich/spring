package top.piao888.ssh.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.piao888.ssh.pojo.UserAuth;
import top.piao888.ssh.repository.UserRepository;
import top.piao888.ssh.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<UserAuth> getall(){
        return userRepository.all();
    }

    public List<UserAuth>  getUserById0(Integer id){
        return userRepository.getPersonById0(id);
    }
    @Override
    public List<UserAuth> getPersonBydname1(String dname) {
        return userRepository.getPersonBydname(dname);
    }

    @Override
    public List<UserAuth> getUserById2(Integer id) {
        return userRepository.getPersonById2(id);
    }

    public void delete(Integer id){
        userRepository.deleteUserById(id);
    }

    @Override
    public List<UserAuth> getPersonById2(Integer id) {
        return userRepository.getPersonById2(id);
    }

    @Override
    public List getPersontwoByIdandname(Integer id, String dname) {
        return userRepository.getPersontwoByIdandname(id,dname);
    }

    @Override
    public List<UserAuth> getPersonlikeBydname(String dname) {
        return userRepository.getPersonlikeBydname(dname);
    }

    @Override
    public List findByDetached() {
        return null;
    }
}
