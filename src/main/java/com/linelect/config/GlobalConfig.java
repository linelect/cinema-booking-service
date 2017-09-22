package com.linelect.config;

import com.linelect.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class GlobalConfig {

    @Bean(name = "user1")
    public User getUser1() {
        User user = new User();
        user.setId(1);
        user.setName("User 1");
        user.setEmail("user1@gmail.com");
        return user;
    }

    @Bean(name = "user2")
    public User getUser2() {
        User user = new User();
        user.setId(2);
        user.setName("User 2");
        user.setEmail("user2@gmail.com");
        return user;
    }

    @Bean(name = "auditorium1")
    public Auditorium getAuditorium1() {
        Auditorium auditorium = new Auditorium();
        auditorium.setId(1);
        auditorium.setName("Auditorium 1");
        return auditorium;
    }

    @Bean(name = "event1")
    public Event getEvent1() {
        Event event = new Event();
        event.setId(1);
        event.setName("Evcent 1");
        event.setDateTime(LocalDateTime.now());
        event.setAuditorium(getAuditorium1());
        event.setPrice(100.0);
        return event;
    }

    @Bean(name = "auditoriumSeat1")
    public AuditoriumSeat getAuditoriumSeat1() {
        return new AuditoriumSeat(getAuditorium1(), 1, 1, SeatType.STANDART);
    }

    @Bean(name = "ticket1")
    public Ticket getTicket1() {
        Ticket ticket = new Ticket();
        ticket.setId(1);
        ticket.setEvent(getEvent1());
        ticket.setUser(getUser1());
        ticket.setAuditoriumSeat(getAuditoriumSeat1());
        ticket.setPayed(true);
        return ticket;
    }
}
