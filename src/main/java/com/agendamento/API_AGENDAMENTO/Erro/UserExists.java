package com.agendamento.API_AGENDAMENTO.Erro;

public class UserExists extends RuntimeException{
    public UserExists(String message){
        super(message);
    }

    public UserExists(){
        super("Usuario já existe");
    }
}
