package com.qsl.yh;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qsl.yh.bean.Info;
import com.qsl.yh.service.*;
import com.qsl.yh.service.impl.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("services.xml");
		        
		DbService ds1 = ac.getBean("ds03",DbService.class);
		ds1.showMsg();
		
		DbService ds2 = ac.getBean("ds03",DbService.class);
		ds2.showMsg();
		
		
		DbService ds3 = ac.getBean("ds03",DbService.class);
		Info info = new Info();
		info.setName("Hello");
		info.setIntro("haha");
		ds3.insert(info);
		
		List<Info> infList = ds3.getInfo(0);
		for(Info i:infList){
			System.out.println(i.getId()+"  "+i.getName()+"  "+i.getIntro());
		}
		
		
		ac.close();
    }
}
