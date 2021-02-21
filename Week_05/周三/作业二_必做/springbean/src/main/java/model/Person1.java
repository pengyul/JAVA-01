package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

// 构造器注入
@Component
public class Person1 {
    private Cat cat;
    @Autowired
    public Person1(Cat cat){
        this.cat = cat;
    }
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person1 person1 = context.getBean("person1", Person1.class);
        person1.cat.show();
    }
}
