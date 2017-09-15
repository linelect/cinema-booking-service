package com.linelect.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "auditoriumSeat_id", nullable = false)
    private AuditoriumSeat auditoriumSeat;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "payed", nullable = false)
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
