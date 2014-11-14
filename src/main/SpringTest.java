package main;

import integrity.ValidAction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.Person;

public class SpringTest {
	public static void main(String[] args) throws Exception{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		System.out.println(ctx);
		
		Person p = (Person)ctx.getBean("person");
		p.info();				
		
		ValidAction va = (ValidAction)ctx.getBean("validAction");
		va.valid();
	}
}
