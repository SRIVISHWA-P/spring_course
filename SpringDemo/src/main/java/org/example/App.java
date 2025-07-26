package org.example;

import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // java based config
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Desktop dt = context.getBean(Desktop.class);
        dt.compile();

        Desktop dt2 = context.getBean(Desktop.class);
        dt.compile();

        Alien obj = context.getBean(Alien.class);
        System.out.println(obj.getAge());
        obj.code();

        //XML based config
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        Alien obj = context.getBean(Alien.class);
//        System.out.println(obj.getAge());
//        obj.code();
//        //Alien obj = (Alien) context.getBean("alien");
//        Computer com = context.getBean(Computer.class);
//        com.compile();

    }
}
