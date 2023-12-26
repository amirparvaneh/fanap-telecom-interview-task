package com.fanap.telecom.service;

import com.fanap.telecom.model.User;
import com.fanap.telecom.model.dto.UserResponseAllDto;

import java.util.List;

public interface UserService extends BaseService<User> {
    List<UserResponseAllDto> getAllUser();

    User getUserByUserName(String username);
}
