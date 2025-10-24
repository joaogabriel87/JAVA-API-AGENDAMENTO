package com.agendamento.API_AGENDAMENTO.Booking;

import com.agendamento.API_AGENDAMENTO.Room.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    @Query("""
    SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END
    FROM BookingEntity b
    WHERE b.room = :room
      AND b.data = :data
      AND (
        (b.hour_inicial < :hourFinal)
        AND (b.hour_final > :hourInicial)
      )
""")
    boolean existByRoomAndData(RoomEntity room, LocalDate data, LocalTime hourInicial, LocalTime hourFinal);

    @Query("SELECT x FROM BookingEntity x WHERE x.room.roomName = :roomName")
    List<BookingEntity> findAllByRoomName(String roomName);
}
