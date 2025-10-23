package com.agendamento.API_AGENDAMENTO.Room;

import com.agendamento.API_AGENDAMENTO.Booking.BookingEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "sala")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sala", unique = true)
    private String roomName;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    List<BookingEntity> bookings;

    public RoomEntity(String roomName) {
        this.roomName = roomName;
    }
}
