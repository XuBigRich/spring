package top.piao888.student.properties;


import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Properties;


/**
 * Hello world!
 *
 */

public class App {
    public static Properties properties;
    public static void main( String[] args ) {
        properties = new Properties();
        try {
            //之所以找不到 资源 是 资源只能放在resources中才有效  不管路径怎么设置，只要资源不再resources中 程序就认为他不存在
//            properties.load(new ClassPathResource("src/main/assembly/config/develop/aaa.properties").getInputStream());
//            properties.load(new ClassPathResource("../assembly/config/develop/aaa.properties").getInputStream());
            //在配置中(xml中) 设置相对路径 需要前缀classpath: , 而在类中 设置路径 可以以 resources为相对路径，直接写路径，  例子如下：
            properties.load(new ClassPathResource("student/properties/aaa.properties").getInputStream());
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("出错了！");
        }

        Object a=properties.get("brandpoint.bind");
        System.out.println(String.valueOf(a));

    }
}

