package top.piao888.ssm;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.piao888.ssm.domain.Logininfo;
import top.piao888.ssm.mapper.LogininfoMapper;

import java.util.List;

public class App {
    Logininfo logininfo=new Logininfo();
    public void addService() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ssm/spring/application.xml");
//加载xml中名为userMapper的bean 标签
        LogininfoMapper logininfoMapper=(LogininfoMapper)context.getBean("logininfoMapper");
        List a=logininfoMapper.selectAll();
        logininfo.setId(1L);
        List b=logininfoMapper.findlogininfo(logininfo);
        System.out.println(a.size());
        System.out.println(b.size());
        context.close();
    }
    public static void main( String[] args )
    {
        App app=new App();
        app.addService();
        System.out.println( "Hello World!" );
    }
}