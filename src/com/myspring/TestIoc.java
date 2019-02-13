package com.myspring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Fant.J.
 * 2018/3/18 11:11
 */
public class TestIoc {

    @Test
    public void textUser()
    {
        //1.获取spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.由配置文件返回对象
        People p = (People)context.getBean("people");
        System.out.println(p.toString());
    }
}
