package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

// 属性注入 byType
@Component
public class Person2 {
    private Cat cat;

    @Autowired
    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person2 person2 = context.getBean("person2", Person2.class);
        person2.cat.show();
    }
}
