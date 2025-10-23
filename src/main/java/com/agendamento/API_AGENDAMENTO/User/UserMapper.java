package com.agendamento.API_AGENDAMENTO.User;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity toEntity(UserDto dto){
        return new UserEntity(
            dto.name(), dto.email(), dto.department()
        );
    }
}
