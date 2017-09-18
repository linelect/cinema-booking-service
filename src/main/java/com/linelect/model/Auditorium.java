package com.linelect.model;

import java.util.List;


public class Auditorium extends NamedEntity {


    private int numberOfSeats;

   private List<AuditoriumSeat> seatList;

    public Auditorium() {
    }

    protected Auditorium(int id, String name, int numberOfSeats) {
        super(id, name);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public List<AuditoriumSeat> getSeatList() {
        return seatList;
    }

    private void initSeatList() {

    }
}
