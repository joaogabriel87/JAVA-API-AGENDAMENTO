package com.agendamento.API_AGENDAMENTO.Booking;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record PatchBookingDto(
        @NotBlank String title,
        @NotNull LocalDate data,
        @NotNull LocalTime hour_inicial,
        @NotNull LocalTime  hour_final
) {
}
