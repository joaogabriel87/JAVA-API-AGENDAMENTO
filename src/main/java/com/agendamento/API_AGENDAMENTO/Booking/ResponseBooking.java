package com.agendamento.API_AGENDAMENTO.Booking;

import com.agendamento.API_AGENDAMENTO.Room.RoomDto;
import com.agendamento.API_AGENDAMENTO.Room.RoomEntity;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record ResponseBooking(
        LocalDate data,
        LocalTime hour_inicial,
        LocalTime  hour_final,
        String title,
        String roomName,
        String userResponsible
) {
}
