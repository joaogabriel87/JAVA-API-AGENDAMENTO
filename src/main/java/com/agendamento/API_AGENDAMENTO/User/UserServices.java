package com.agendamento.API_AGENDAMENTO.User;

import com.agendamento.API_AGENDAMENTO.Erro.UserExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    public UserEntity createUser(UserDto dto){
        UserEntity entity =  userMapper.toEntity(dto);
        if(userRepository.findByEmail(dto.email()).isPresent()){
            throw new UserExists();
        }

        return userRepository.save(entity);
    }
}
