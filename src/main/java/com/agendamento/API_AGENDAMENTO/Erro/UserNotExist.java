package com.agendamento.API_AGENDAMENTO.Erro;

public class UserNotExist extends RuntimeException{
    public UserNotExist(String message){
        super(message);
    }

    public UserNotExist(){
        super("Usuario nao encontrado");
    }
}
