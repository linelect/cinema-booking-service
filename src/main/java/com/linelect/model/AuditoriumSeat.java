package com.linelect.model;

public class AuditoriumSeat extends BaseEntity {


    private Auditorium auditorium;


    private int number;


    private int row;

    private SeatType seatType;

    public AuditoriumSeat(int id, Auditorium auditorium, int number, int row, SeatType seatType) {
        super(id);
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
}
