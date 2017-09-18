package com.linelect;

import com.linelect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class EntryPoint {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("com.linelect");
        context.start();

        EntryPoint entryPoint = context.getBean(EntryPoint.class);
        entryPoint.userService.getAll().forEach(System.out::println);

    }
}
