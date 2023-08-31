package com.fanap.telecom.service.serviceImpl;

import com.fanap.telecom.constants.ErrorMessage;
import com.fanap.telecom.exception.NotFoundException;
import com.fanap.telecom.model.User;
import com.fanap.telecom.repository.UserRepo;
import com.fanap.telecom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public void save(User user) {
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
}
