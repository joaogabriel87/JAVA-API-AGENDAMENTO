package com.agendamento.API_AGENDAMENTO.Booking;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
