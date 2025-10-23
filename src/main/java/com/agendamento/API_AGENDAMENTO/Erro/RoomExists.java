package com.agendamento.API_AGENDAMENTO.Erro;

public class RoomExists extends RuntimeException{
    public RoomExists(String message){
        super(message);
    }

    public RoomExists(){
        super("Essa sala já existe");
    }
}
