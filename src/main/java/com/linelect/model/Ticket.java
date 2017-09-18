package com.linelect.model;

import java.time.LocalDateTime;


public class Ticket extends BaseEntity {


    private Event event;


    private AuditoriumSeat auditoriumSeat;


    private User user;


    private boolean payed;

    public Ticket() {
    }

    public Ticket(int id, Event event, LocalDateTime dateTime, AuditoriumSeat auditoriumSeat, User user, boolean payed) {
        super(id);
        this.event = event;
        this.auditoriumSeat = auditoriumSeat;
        this.user = user;
        this.payed = payed;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public AuditoriumSeat getAuditoriumSeat() {
        return auditoriumSeat;
    }

    public void setAuditoriumSeat(AuditoriumSeat auditoriumSeat) {
        this.auditoriumSeat = auditoriumSeat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }
}
