package com.agendamento.API_AGENDAMENTO.Room;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

    Optional<RoomEntity>findByRoomName(String RoomName);
}
