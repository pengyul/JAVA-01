package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

// 属性注入 byName
@Component
public class Person3 {
    private Cat cat;

    @Autowired
    @Qualifier(value = "Cat123")
    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person3 person3 = context.getBean("person3", Person3.class);
        person3.cat.show();
    }
}
