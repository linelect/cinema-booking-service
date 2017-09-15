package com.linelect.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "auditoriums")
public class Auditorium extends NamedEntity {

    @Column(name = "numberOfSeats")
    private int numberOfSeats;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "auditorium")
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
