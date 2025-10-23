package com.agendamento.API_AGENDAMENTO.Erro;

public class RoomNotExists extends RuntimeException{
    public RoomNotExists(){
        super("Sala nao encontrada");
    }

    public RoomNotExists(String message){
        super(message);
    }

}
