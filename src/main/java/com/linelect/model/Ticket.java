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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        if (!super.equals(o)) return false;

        Ticket ticket = (Ticket) o;

        if (payed != ticket.payed) return false;
        if (event != null ? !event.equals(ticket.event) : ticket.event != null) return false;
        if (auditoriumSeat != null ? !auditoriumSeat.equals(ticket.auditoriumSeat) : ticket.auditoriumSeat != null)
            return false;
        return user != null ? user.equals(ticket.user) : ticket.user == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (auditoriumSeat != null ? auditoriumSeat.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (payed ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "event=" + event +
                ", auditoriumSeat=" + auditoriumSeat +
                ", user=" + user +
                ", payed=" + payed +
                ", id=" + id +
                '}';
    }
}
