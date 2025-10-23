package com.agendamento.API_AGENDAMENTO.Booking;

import com.agendamento.API_AGENDAMENTO.Erro.RoomIsOccupied;
import com.agendamento.API_AGENDAMENTO.Erro.RoomNotExists;
import com.agendamento.API_AGENDAMENTO.Erro.UserNotExist;
import com.agendamento.API_AGENDAMENTO.Room.RoomEntity;
import com.agendamento.API_AGENDAMENTO.Room.RoomRepository;
import com.agendamento.API_AGENDAMENTO.User.UserEntity;
import com.agendamento.API_AGENDAMENTO.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private BookingMapper bookingMapper;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private UserRepository userRepository;

    public BookingEntity newBooking(BookingDto dto){
        RoomEntity room = roomRepository.findByRoomName(dto.roomName()).orElseThrow(() -> new RoomNotExists());

        UserEntity user = userRepository.findByEmail(dto.emailUser()).orElseThrow(() -> new UserNotExist());

        Boolean RoomOccupied = bookingRepository.existByRoomAndData(room, dto.data(), dto.hour_inicial(), dto.hour_final());

        if (RoomOccupied){
            throw new RoomIsOccupied();
        }

        BookingEntity booking = bookingMapper.toEntity(dto, user, room);

        return bookingRepository.save(booking);
    }
}
