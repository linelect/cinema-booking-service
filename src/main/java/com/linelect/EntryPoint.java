package com.linelect;

import com.linelect.dao.AuditoriumDAO;
import com.linelect.dao.InMemoryDataBaseSimulator;
import com.linelect.model.*;
import com.linelect.service.AuditoriumService;
import com.linelect.service.EventService;
import com.linelect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired
    private AuditoriumService auditoriumService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("com.linelect");
        context.start();

        EntryPoint entryPoint = context.getBean(EntryPoint.class);

        Auditorium auditorium = new Auditorium();
        auditorium.setName("Auditorium 1");
        auditorium.setNumberOfSeats(30);
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

    public void initTestData() {
        InMemoryDataBaseSimulator.getUsers().add(user1);
        InMemoryDataBaseSimulator.getUsers().add(user2);
        InMemoryDataBaseSimulator.getAuditoriums().add(auditorium1);
        InMemoryDataBaseSimulator.getEvents().add(event1);
        InMemoryDataBaseSimulator.getAuditoriumSeats().add(auditoriumSeat1);
        InMemoryDataBaseSimulator.getTickets().add(ticket1);
    }
}

