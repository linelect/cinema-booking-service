package com.linelect;

import com.linelect.dao.InMemoryDataBaseSimulator;
import com.linelect.model.*;
import com.linelect.service.EventService;
import com.linelect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class EntryPoint {

    @Autowired
    private UserService userService;

    @Autowired
    private EventService eventService;

    @Autowired
    @Qualifier("user1")
    private User user1;

    @Autowired
    @Qualifier("user2")
    private User user2;

    @Autowired
    @Qualifier("auditorium1")
    private Auditorium auditorium1;

    @Autowired
    @Qualifier("event1")
    private Event event1;

    @Autowired
    @Qualifier("auditoriumSeat1")
    private AuditoriumSeat auditoriumSeat1;

    @Autowired
    @Qualifier("ticket1")
    private Ticket ticket1;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("com.linelect");
        context.start();

        EntryPoint entryPoint = context.getBean(EntryPoint.class);
        entryPoint.initTestData();
        entryPoint.userService.getAll().forEach(System.out::println);
        entryPoint.eventService.getAll().forEach(System.out::println);

    }

    public void initTestData() {
        InMemoryDataBaseSimulator.getUsers().add(user1);
        InMemoryDataBaseSimulator.getUsers().add(user2);
        InMemoryDataBaseSimulator.getAuditoriums().add(auditorium1);
        InMemoryDataBaseSimulator.getEvents().add(event1);
        InMemoryDataBaseSimulator.getAuditoriumSeats().add(auditoriumSeat1);
        InMemoryDataBaseSimulator.getTickets().add(ticket1);
    }
}

