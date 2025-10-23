package com.agendamento.API_AGENDAMENTO.Booking;

import com.agendamento.API_AGENDAMENTO.Room.RoomEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record BookingDto(
        @NotBlank String title,
        @NotNull LocalDate data,
        @NotNull LocalTime hour_inicial,
        @NotNull LocalTime  hour_final,
        @NotBlank @Email String emailUser,
        @NotBlank String roomName
        )
{
}
