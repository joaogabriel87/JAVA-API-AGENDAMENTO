package com.agendamento.API_AGENDAMENTO.Room;

import org.springframework.stereotype.Component;

@Component
public class RoomMapper {

    public RoomEntity toEntity(RoomDto dto){
        return new RoomEntity(
            dto.room()
        );
    }
}
