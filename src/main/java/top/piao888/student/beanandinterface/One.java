package top.piao888.student.beanandinterface;

import top.piao888.student.beanandinterface.OneInterface;

public class One implements OneInterface {
    private String hello;
    private String xhz;
    private Two two;
    public One(String xhz){
        this.xhz=xhz;
    }
    @Override
    public String hello(String word) {
        return hello+" "+word+" "+"by:"+xhz;
    }
//即使是属性注入 也需要加set/get方法
    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
    //测试spring 注入 One时 注入 Two属性 是否可以单独只注入Two的单个属性
    //结果 是不可以的,但可以通过设置setxxx方法去变相的 给Two属性赋值
    public int getOld() {
        System.out.println("getold");
        return 1;
    }

    public void setOld(int old) {
        setTwo(old);
    }
    public void setTwo(int old){
        System.out.println("setold");
        two=new Two();
        two.setOld(old);
    }

    public Two getTwo() {
        return two;
    }
}
