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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auditorium)) return false;

        Auditorium that = (Auditorium) o;

        if (numberOfSeats != that.numberOfSeats) return false;
        return seatList != null ? seatList.equals(that.seatList) : that.seatList == null;
    }

    @Override
    public int hashCode() {
        int result = numberOfSeats;
        result = 31 * result + (seatList != null ? seatList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Auditorium{" +
                "numberOfSeats=" + numberOfSeats +
                ", seatList=" + seatList +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
