package com.agendamento.API_AGENDAMENTO.Room;

import com.agendamento.API_AGENDAMENTO.Erro.RoomExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomMapper  roomMapper;

    public RoomEntity createRoom(RoomDto dto){
        RoomEntity entity =  roomMapper.toEntity(dto);
        if(roomRepository.findByRoomName(entity.getRoomName()).isPresent()){
            throw new RoomExists();
        }
        return roomRepository.save(entity);
    }
}
