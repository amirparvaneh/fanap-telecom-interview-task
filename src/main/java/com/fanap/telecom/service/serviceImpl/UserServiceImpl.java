package com.fanap.telecom.service.serviceImpl;

import com.fanap.telecom.constants.ErrorMessage;
import com.fanap.telecom.exception.DuplicateException;
import com.fanap.telecom.exception.NotFoundException;
import com.fanap.telecom.model.User;
import com.fanap.telecom.model.dto.UserResponseAllDto;
import com.fanap.telecom.repository.UserRepo;
import com.fanap.telecom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper mapper;

    @Override
    public void save(User user) {
        if(Objects.nonNull(userRepo.findUserByUserName(user.getUserName()))){
            throw new DuplicateException(ErrorMessage.DUPLICATE_ENTITY + user.getUserName());
        }
        userRepo.save(user);
    }

    @Override
    public void delete(Long userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public User find(Long userId) {
        return userRepo.findById(userId).orElseThrow(() ->
                new NotFoundException(ErrorMessage.ERROR_NOT_FOUND + userId));
    }

    @Override
    public List<UserResponseAllDto> getAllUser() {
        List<User> users = userRepo.findAll();
        return users.stream().map(user -> mapper.map(user,UserResponseAllDto.class)).toList();
    }

    @Override
    public User getUserByUserName(String username) {
        return userRepo.findUserByUserName(username);
    }
}
