package com.revature.SpringBootRefresher.services;

import com.revature.SpringBootRefresher.models.User;
import com.revature.SpringBootRefresher.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    public User registerUser(User user) {
        return userRepo.save(user);
    }

    public User loginUser(User user) {
        User foundUser = userRepo.findByUsername(user.getUsername());
        if (!foundUser.getPassword().equals(user.getPassword())) {
            return null;
        }
        return foundUser;
    }
}
