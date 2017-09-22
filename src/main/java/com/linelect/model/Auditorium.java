package com.linelect.model;

import java.util.List;


public class Auditorium extends NamedEntity {

    private List<AuditoriumSeat> seatList;

    public Auditorium() {
    }

    protected Auditorium(int id, String name, int numberOfSeats) {
        super(id, name);
    }

    public int getNumberOfSeats() {
        return this.seatList == null ? 0 : this.seatList.size();
    }

    public List<AuditoriumSeat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<AuditoriumSeat> seatList) {
        this.seatList = seatList;
    }

    @Override
    public String toString() {
        return "Auditorium{" +
                "seatList=" + seatList +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auditorium)) return false;
        if (!super.equals(o)) return false;

        Auditorium that = (Auditorium) o;

        return seatList != null ? seatList.equals(that.seatList) : that.seatList == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (seatList != null ? seatList.hashCode() : 0);
        return result;
    }
}
