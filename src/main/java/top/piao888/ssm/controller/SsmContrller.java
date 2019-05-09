package top.piao888.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.piao888.ssm.domain.Logininfo;
import top.piao888.ssm.mapper.LogininfoMapper;
import top.piao888.ssm.pojo.Item;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
/*
    @RequestParam()  处理 Content-Type: application/x-www-form-urlencoded 编码格式的数据

    @ResponseBody  处理 非 Content-Type: application/x-www-form-urlencoded编码格式的数据

    */

@Controller
@RequestMapping("/ssm")
public class SsmContrller {
    @Autowired
    private LogininfoMapper logininfoMapper;
    @RequestMapping("/getAll")
    public String getAll(HttpServletRequest request){
       List a=  logininfoMapper.selectAll();
         request.setAttribute("aa",a);
         return "ssm/index";
    }
    @RequestMapping("/findlogininfo")
    @ResponseBody  // 与@Controller结合 产生 返回json格式
    public List<Logininfo> findlogininfo(){
        Logininfo logininfo=new Logininfo();
        logininfo.setId(1L);
        System.out.println("连接成功："+logininfoMapper.findlogininfo(logininfo).size());
        return logininfoMapper.findlogininfo(logininfo);
    }
    @GetMapping("/hello")
//    @RequestMapping("/hello")
    public String aaa(Model model){
        Logininfo logininfo=new Logininfo();
        logininfo.setState((byte)1);
        List aa=logininfoMapper.findlogininfo(logininfo);
        model.addAttribute("aa",aa);
//        return "index";
          return "ssm/index";  //转发 只产生了 一次请求   因为 是一次请求 所以 Attribute数据一直跟随请求  进行
    }
    @GetMapping("/world")
    public String bbb(Model model){
        Logininfo logininfo=new Logininfo();
        logininfo.setState((byte)1);
        List aa=logininfoMapper.findlogininfo(logininfo);
        model.addAttribute("aa",aa);
        return "redirect:/index";  // 重定向   产生了两次请求  而在第二次 请求产生时  Attribute 数据 就丢失了  同时也证明了 Attribute生命周期只存在与一次请求
    }
    @GetMapping("/index")
    public void forward(){
        System.out.println("index被执行了");
    }
//    会自动跳转到hh.jsp页面
    @RequestMapping("/hh")
    public void yemian(@RequestParam("id") Integer id,@RequestParam("dname") String dname){
        System.out.println("id"+id+" "+"dname"+dname);
    }
//    他会自动跳转到world.jsp页面  并找到通过Post方式请求发送的  id 与dname
    @PostMapping("/postest")
    public void postest(@RequestParam("id") Integer id,@RequestParam("dname") String dname){
        System.out.println("id"+id+" "+"dname"+dname);
    }
    @PostMapping("/json_test")
    @ResponseBody
//    测试数据 要严格遵守 json格式{"id" : 1,"dname" : "许鸿志" }
    //注意 此处@RequestBody区别于@ResponseBody
    public Item jsonTest(@RequestBody Item item){
        System.out.println(item.getId() +" "+item.getDname());
        return item;
    }

}
