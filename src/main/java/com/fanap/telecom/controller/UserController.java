package com.fanap.telecom.controller;


import com.fanap.telecom.ApiVersion;
import com.fanap.telecom.model.User;
import com.fanap.telecom.model.dto.UserRequestDto;
import com.fanap.telecom.model.dto.UserResponseAllDto;
import com.fanap.telecom.service.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ApiVersion.VERSION_1 + "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody UserRequestDto userRequestDto){
        userService.save(mapper.map(userRequestDto, User.class));
        return ResponseEntity.ok("created user with username : " + userRequestDto.getUserName());
    }

    @GetMapping
    public ResponseEntity<List<UserResponseAllDto>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }
    
}
