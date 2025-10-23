package com.agendamento.API_AGENDAMENTO.Erro;

public class RoomIsOccupied extends  RuntimeException{
    public RoomIsOccupied(){
        super("A sala já esta ocupada. Consulte os horarios e marque novamente");
    }

    public RoomIsOccupied(String message){
        super(message);
    }
}
