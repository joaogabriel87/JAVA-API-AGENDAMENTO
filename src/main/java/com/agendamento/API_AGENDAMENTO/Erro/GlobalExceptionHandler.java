package com.agendamento.API_AGENDAMENTO.Erro;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<ErroResponse> buildErroResponse(Exception e, HttpStatus status, String path){
            ErroResponse erroResponse = new ErroResponse(
                    LocalDateTime.now(),
                    status.value(),
                    status.getReasonPhrase(),
                    e.getMessage(),
                    path
            );
            return ResponseEntity.status(status).body(erroResponse);
    }

    @ExceptionHandler(BookingNotExist.class)
    public ResponseEntity<ErroResponse> handleBookingNotExist(BookingNotExist e){
        return buildErroResponse(e,HttpStatus.NOT_FOUND,"/booking");
    }
    @ExceptionHandler(RoomExists.class)
    public ResponseEntity<ErroResponse> handleRoomIsExist(RoomExists e){
            return buildErroResponse(e, HttpStatus.CONFLICT, "/room");
    }

    @ExceptionHandler(RoomIsOccupied.class)
    public ResponseEntity<ErroResponse> handleRoomIsOccupied(RoomIsOccupied e){
        return buildErroResponse(e, HttpStatus.BAD_REQUEST, "/booking");
    }

    @ExceptionHandler(RoomNotExists.class)
    public ResponseEntity<ErroResponse> handleRoomNotExist(RoomNotExists e){
        return buildErroResponse(e, HttpStatus.NOT_FOUND, "/room");
    }

    @ExceptionHandler(UserExists.class)
    public ResponseEntity<ErroResponse> handleUserExist(UserExists e){
        return buildErroResponse(e, HttpStatus.CONFLICT, "/user");
    }

    @ExceptionHandler(UserNotExist.class)
    public ResponseEntity<ErroResponse> handleUserNotExist(UserNotExist e){
        return buildErroResponse(e, HttpStatus.NOT_FOUND, "/user");
    }
}
