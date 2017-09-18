package com.linelect.model;

import java.time.LocalDateTime;


public class Event extends NamedEntity {

    private double price;
    private LocalDateTime dateTime;
    private Auditorium auditorium;

    public Event() {
    }

    protected Event(int id, String name, double price, LocalDateTime dateTime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.dateTime = dateTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        if (!super.equals(o)) return false;

        Event event = (Event) o;

        if (Double.compare(event.price, price) != 0) return false;
        if (dateTime != null ? !dateTime.equals(event.dateTime) : event.dateTime != null) return false;
        return auditorium != null ? auditorium.equals(event.auditorium) : event.auditorium == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (auditorium != null ? auditorium.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "price=" + price +
                ", dateTime=" + dateTime +
                ", auditorium=" + auditorium +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
