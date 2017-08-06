package com.qsl.yh;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qsl.yh.service.InfoService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
AbstractApplicationContext aac = new ClassPathXmlApplicationContext("services.xml");
        
        InfoService info = aac.getBean("is",InfoService.class);
        
        info.sayHello();
    }
}
