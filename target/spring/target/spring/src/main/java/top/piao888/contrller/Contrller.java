package top.piao888.contrller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.piao888.domain.Logininfo;
import top.piao888.mapper.LogininfoMapper;

import java.util.List;
@Controller
public class Contrller {
    @Autowired
    private LogininfoMapper logininfoMapper;
    @RequestMapping("/getAll")
    public List<Logininfo> getAll(){
        System.out.println(logininfoMapper.selectAll());
        return logininfoMapper.selectAll();
    }
}
