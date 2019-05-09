package top.piao888.student.beanandinterface;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testinterface{
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("student/spring/application.xml");
        OneInterface oneInterface=(OneInterface)context.getBean("oneInterface");
        System.out.println(oneInterface.hello("word"));
    	}

}
