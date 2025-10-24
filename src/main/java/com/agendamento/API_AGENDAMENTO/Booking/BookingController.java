package com.agendamento.API_AGENDAMENTO.Booking;

import com.agendamento.API_AGENDAMENTO.Room.RoomDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/booking")
@Validated
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private BookingMapper bookingMapper;

    @PostMapping
    public ResponseEntity<ResponseBooking> newBooking(@Valid @RequestBody BookingDto dto){

            BookingEntity booking = bookingService.newBooking(dto);
            ResponseBooking response =  bookingMapper.toResponse(booking);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping()
    public ResponseEntity<List<ResponseBooking>> getAllBookings(@RequestBody RoomDto dto){
        List<ResponseBooking> bookings =  bookingService.viewBooking(dto);
        return ResponseEntity.status(HttpStatus.OK).body(bookings);
    }

    @PatchMapping("/edit/{idBooking}")
    public ResponseEntity<ResponseBooking> editBooking(@PathVariable("idBooking") long id, @Valid @RequestBody PatchBookingDto dto){
        BookingEntity booking = bookingService.editBooking(id,dto);
        ResponseBooking response =  bookingMapper.toResponse(booking);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookingEntity>> getAllBooking(){
        List<BookingEntity> bookings =  bookingService.AllBooking();
        return ResponseEntity.status(HttpStatus.OK).body(bookings);
    }
}
