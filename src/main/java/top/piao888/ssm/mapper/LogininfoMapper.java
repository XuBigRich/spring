package top.piao888.ssm.mapper;

import java.util.List;
import top.piao888.ssm.domain.Logininfo;

public interface LogininfoMapper {
    int deleteByPrimaryKey(Long id);
    int insert(Logininfo record);
    Logininfo selectByPrimaryKey(Long id);
    List<Logininfo> selectAll();
    int updateByPrimaryKey(Logininfo record);
    List findlogininfo(Logininfo record);
    List fuzzylogininfo(Logininfo record);
}