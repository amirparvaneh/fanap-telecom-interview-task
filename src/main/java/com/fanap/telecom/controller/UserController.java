package com.fanap.telecom.controller;


import com.fanap.telecom.ApiVersion;
import com.fanap.telecom.service.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ApiVersion.VERSION_1 + "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;
    
}
