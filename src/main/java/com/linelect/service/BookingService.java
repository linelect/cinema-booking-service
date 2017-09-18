package com.linelect.service;

import com.linelect.model.*;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {
    double getTicketsPrice(Event event, User user);

    double getTicketsPrice(Event event);

    Ticket bookTicket(User user, Event event, int numberOfSeat, int row, SeatType seatType);

    List<Ticket> getPurchasedTicketsForEvent(Event event);
}
