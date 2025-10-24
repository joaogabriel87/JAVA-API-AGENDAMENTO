package com.agendamento.API_AGENDAMENTO.Booking;

import com.agendamento.API_AGENDAMENTO.Erro.BookingNotExist;
import com.agendamento.API_AGENDAMENTO.Erro.RoomIsOccupied;
import com.agendamento.API_AGENDAMENTO.Erro.RoomNotExists;
import com.agendamento.API_AGENDAMENTO.Erro.UserNotExist;
import com.agendamento.API_AGENDAMENTO.Room.RoomEntity;
import com.agendamento.API_AGENDAMENTO.Room.RoomRepository;
import com.agendamento.API_AGENDAMENTO.User.UserEntity;
import com.agendamento.API_AGENDAMENTO.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public List<ResponseBooking> viewBooking(String roomName){
        List<BookingEntity> bookings = bookingRepository.findAllByRoomName(roomName);
        if (bookings.isEmpty()){
            throw  new RoomNotExists();
        }

        return bookings.stream().map(bookingMapper::toResponse).toList();
    }

    public BookingEntity editBooking(Long id,PatchBookingDto patch){
        BookingEntity booking = bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotExist());

        Boolean RoomOccupied = bookingRepository.existByRoomAndData(booking.getRoom(), patch.data(), patch.hour_inicial(), patch.hour_final());

        if (RoomOccupied){
            throw new RoomIsOccupied();
        }
        booking.setTitle(patch.title());
        booking.setData(patch.data());
        booking.setHour_inicial(patch.hour_inicial());
        booking.setHour_final(patch.hour_final());
        return bookingRepository.save(booking);

    }

    public List<BookingEntity> AllBooking(){
        return bookingRepository.findAll();
    }
}
