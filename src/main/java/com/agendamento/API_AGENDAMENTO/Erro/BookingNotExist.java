package com.agendamento.API_AGENDAMENTO.Erro;

public class BookingNotExist extends RuntimeException{
    public BookingNotExist(String message){
        super(message);
    }
    public BookingNotExist(){
        super("Reserva não existente");
    }
}
