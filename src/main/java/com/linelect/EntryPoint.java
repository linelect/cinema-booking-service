package com.linelect;

import com.linelect.model.User;
import com.linelect.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EntryPoint {

    @Autowired
    private static UserServiceImpl userService;

    public static void main(String[] args) {
//        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext( "spring.xml");
//        ctx.registerShutdownHook();
//
//        UserServiceImpl app = ctx.getBean("UserServiceImpl", UserServiceImpl.class);
        User user = new User();
        user.setName("User1");
        user.setEmail("uaser@gmail.con");
        userService.save(user);
        System.out.printf(userService.getAll().toString());
    }
}
