package com.linelect.service.impl;

import com.linelect.model.*;
import com.linelect.service.BookingService;

import java.time.LocalDateTime;
import java.util.List;

public class BookingServiceImpl implements BookingService {
    @Override
    public double getTicketsPrice(Event event, LocalDateTime dateTime, User user, List<AuditoriumSeat> seats) {
        return 0;
    }

    @Override
    public Ticket bookTicket(Event event, int numberOfSeat, int row, SeatType seatType) {
        return null;
    }

    @Override
    public List<Ticket> getPurchasedTicketsForEvent(Event event) {
        return null;
    }
}
