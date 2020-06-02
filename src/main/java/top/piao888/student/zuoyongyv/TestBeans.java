package top.piao888.student.zuoyongyv;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeans {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("student/spring/spring-beanscope.xml");
        BeanScope beanScope=(BeanScope)context.getBean("beanScope");
        beanScope.say();
        BeanScope beanScope1=(BeanScope)context.getBean("beanScope");
        beanScope1.say();
//        他解析的是同一个beanScope  输出的hashcode也一样 说明 其为单例模式

        ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("student/spring/spring-beanscope.xml");
        BeanScope beanScope2=(BeanScope)context2.getBean("beanScope");
        beanScope2.say();
//        这个地方的hashcode 不同 是因为 这次解析的容器 与 前面两个 不一样  ，但其依然是单例模式
        ClassPathXmlApplicationContext context3 = new ClassPathXmlApplicationContext("student/spring/spring-beanscope.xml");
        BeanScope beanScope3=(BeanScope)context3.getBean("beanScope1");
        beanScope3.say();
        BeanScope beanScope4=(BeanScope)context3.getBean("beanScope1");
        beanScope4.say();
    }

}
