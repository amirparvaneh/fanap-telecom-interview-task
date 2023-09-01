package com.fanap.telecom.controller;


import com.fanap.telecom.ApiVersion;
import com.fanap.telecom.constants.Messages;
import com.fanap.telecom.model.User;
import com.fanap.telecom.model.dto.BaseResponseDto;
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
    public ResponseEntity<BaseResponseDto<Object>> addUser(@RequestBody UserRequestDto userRequestDto) {
        userService.save(mapper.map(userRequestDto, User.class));
        return ResponseEntity.ok().body(BaseResponseDto.builder()
                .message(Messages.ENTITY_ADDED + userRequestDto.getUserName())
                .build());
    }

    @PostMapping("/{sellerId}")
    public ResponseEntity<BaseResponseDto<Object>> getSellerById(@PathVariable Long sellerId) {
        User user = userService.find(sellerId);
        return ResponseEntity.ok().body(BaseResponseDto.builder()
                .message(Messages.ENTITY_FOUNDED + sellerId)
                .result(user)
                .build());
    }

    @GetMapping
    public ResponseEntity<List<UserResponseAllDto>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUser());
    }

}
