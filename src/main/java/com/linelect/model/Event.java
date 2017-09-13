package com.linelect.model;

import java.time.LocalDateTime;

public class Event extends NamedEntity {
    private double price;
    private LocalDateTime dateTime;

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
}
