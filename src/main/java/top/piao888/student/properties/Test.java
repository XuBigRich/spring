package top.piao888.student.properties;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Properties;

public class Test {
    public static Properties properties;
    public static void main(String[] args) {
        try {
            //xml 文件不可以使用properties解析
            properties.load(new ClassPathResource("student/properties/properties.xml").getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Object a=properties.get("brandpoint.bind");
        System.out.println(String.valueOf(a));

    }
}
