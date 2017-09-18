package com.linelect.dao;

import com.linelect.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryDataBaseSimulator {

    private static List<User> users = new ArrayList<>();
    private static List<Event> events = new ArrayList<>();
    private static List<Auditorium> auditoriums = new ArrayList<>();
    private static List<Ticket> tickets = new ArrayList<>();
    private static List<AuditoriumSeat> auditoriumSeats = new ArrayList<>();

    public static List<User> getUsers() {
        return users;
    }

    public static List<Event> getEvents() {
        return events;
    }

    public static List<Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public static List<Ticket> getTickets() {
        return tickets;
    }

    public static List<AuditoriumSeat> getAuditoriumSeats() {
        return auditoriumSeats;
    }

}
