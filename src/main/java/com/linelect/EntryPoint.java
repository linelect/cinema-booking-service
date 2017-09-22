package com.linelect;

import com.linelect.model.*;
import com.linelect.service.AuditoriumService;
import com.linelect.service.EventService;
import com.linelect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EntryPoint {

    @Autowired
    private UserService userService;

    @Autowired
    private EventService eventService;

    @Autowired
    private AuditoriumService auditoriumService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("com.linelect");
        context.start();

        EntryPoint entryPoint = context.getBean(EntryPoint.class);

        Auditorium auditorium = new Auditorium();
        auditorium.setName("Auditorium 1");
        entryPoint.auditoriumService.add(auditorium);
//        entryPoint.auditoriumService.getAll().forEach(System.out::println);
        System.out.println("------------");

        Event event = new Event();
        event.setName("Event 1");
        event.setDateTime(LocalDateTime.now());
        event.setAuditorium(auditorium);
        event.setPrice(100.0);

        entryPoint.eventService.getAll().forEach(System.out::println);
    }

}

