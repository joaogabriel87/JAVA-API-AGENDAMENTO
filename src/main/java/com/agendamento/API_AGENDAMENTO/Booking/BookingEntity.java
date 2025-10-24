package com.agendamento.API_AGENDAMENTO.Booking;

import com.agendamento.API_AGENDAMENTO.Room.RoomEntity;
import com.agendamento.API_AGENDAMENTO.User.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "reserva")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity room;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
    private LocalDate  data;
    private LocalTime  hour_inicial;
    private LocalTime  hour_final;
    private String title;


    public BookingEntity(String title, LocalDate data, LocalTime  hour_inicial, LocalTime  hour_final) {
        this.title = title;
        this.data = data;
        this.hour_inicial = hour_inicial;
        this.hour_final = hour_final;
    }
}
