package com.linelect.model;

import javax.persistence.*;

public class AuditoriumSeat extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "auditorium_id", nullable = false)
    private Auditorium auditorium;

    @Column(name = "number", nullable = false)
    private int number;

    @Column(name = "number", nullable = false)
    private int row;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_type")
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
