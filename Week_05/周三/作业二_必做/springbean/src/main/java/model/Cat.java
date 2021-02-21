package model;

import org.springframework.stereotype.Component;

@Component("Cat123")
public class Cat {
    public void show(){
        System.out.println("这是一只猫");
    }
}
