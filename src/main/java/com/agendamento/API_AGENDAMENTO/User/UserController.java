package com.agendamento.API_AGENDAMENTO.User;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
@Validated
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto dto){
            userServices.createUser(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(dto);

    }
}
