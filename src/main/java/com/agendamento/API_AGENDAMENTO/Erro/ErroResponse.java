package com.agendamento.API_AGENDAMENTO.Erro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErroResponse {
    private LocalDateTime time;
    private int status;
    private String  error;
    private String message;
    private String path;

}
