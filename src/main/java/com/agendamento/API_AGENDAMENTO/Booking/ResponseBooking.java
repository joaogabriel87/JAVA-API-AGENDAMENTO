package com.agendamento.API_AGENDAMENTO.Booking;

import com.agendamento.API_AGENDAMENTO.Room.RoomDto;
import com.agendamento.API_AGENDAMENTO.Room.RoomEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ResponseBooking(
        LocalDate data,
        String title,
        String roomName
) {
}
