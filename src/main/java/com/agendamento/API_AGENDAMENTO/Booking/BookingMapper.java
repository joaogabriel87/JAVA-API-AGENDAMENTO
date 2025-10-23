package com.agendamento.API_AGENDAMENTO.Booking;

import com.agendamento.API_AGENDAMENTO.Room.RoomDto;
import com.agendamento.API_AGENDAMENTO.Room.RoomEntity;
import com.agendamento.API_AGENDAMENTO.User.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    public BookingEntity toEntity(BookingDto dto, UserEntity user, RoomEntity room) {
        BookingEntity booking = new BookingEntity(
                dto.title(),
                dto.data(),
                dto.hour_inicial(),
                dto.hour_final()
        );

        booking.setUser(user);
        booking.setRoom(room);

        return booking;
    }

    public ResponseBooking toResponse(BookingEntity booking) {
        return new ResponseBooking(
                booking.getData(),
                booking.getTitle(),
                booking.getRoom().getRoomName()
        );
    }
}
