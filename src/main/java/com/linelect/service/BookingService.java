package com.linelect.service;

import com.linelect.model.*;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {
    double getTicketsPrice(Event event, LocalDateTime dateTime, User user, List<AuditoriumSeat> seats);

    Ticket bookTicket(Event event, int numberOfSeat, int row, SeatType seatType);

    List<Ticket> getPurchasedTicketsForEvent(Event event);
}
