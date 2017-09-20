package com.linelect.model;

public class AuditoriumSeat extends BaseEntity {
    private Auditorium auditorium;
    private int number;
    private int row;
    private SeatType seatType;

    public AuditoriumSeat() {
        this.seatType = SeatType.STANDART;
    }

    public AuditoriumSeat(Auditorium auditorium, int number, int row, SeatType seatType) {
        this.auditorium = auditorium;
        this.number = number;
        this.row = row;
        this.seatType = seatType;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public int getNumber() {
        return number;
    }

    public int getRow() {
        return row;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuditoriumSeat)) return false;

        AuditoriumSeat that = (AuditoriumSeat) o;

        if (number != that.number) return false;
        if (row != that.row) return false;
        if (auditorium != null ? !auditorium.equals(that.auditorium) : that.auditorium != null) return false;
        return seatType == that.seatType;
    }

    @Override
    public int hashCode() {
        int result = auditorium != null ? auditorium.hashCode() : 0;
        result = 31 * result + number;
        result = 31 * result + row;
        result = 31 * result + seatType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AuditoriumSeat{" +
                "auditorium=" + auditorium +
                ", number=" + number +
                ", row=" + row +
                ", seatType=" + seatType +
                ", id=" + id +
                '}';
    }
}
