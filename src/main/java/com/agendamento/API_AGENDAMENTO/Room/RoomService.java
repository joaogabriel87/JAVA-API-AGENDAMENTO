package com.agendamento.API_AGENDAMENTO.Room;

import com.agendamento.API_AGENDAMENTO.Booking.ResponseBooking;
import com.agendamento.API_AGENDAMENTO.Erro.RoomExists;
import com.agendamento.API_AGENDAMENTO.Erro.RoomNotExists;
import com.agendamento.API_AGENDAMENTO.Erro.UserNotExist;
import com.agendamento.API_AGENDAMENTO.User.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomMapper  roomMapper;
    @Autowired
    private UserRepository userRepository;

    public RoomEntity createRoom(RoomDto dto){
        if(userRepository.findByEmail(dto.emailUser()).isEmpty()){
            throw new UserNotExist();
        }
        RoomEntity entity =  roomMapper.toEntity(dto);
        if(roomRepository.findByRoomName(entity.getRoomName()).isPresent()){
            throw new RoomExists();
        }
        return roomRepository.save(entity);
    }

}
