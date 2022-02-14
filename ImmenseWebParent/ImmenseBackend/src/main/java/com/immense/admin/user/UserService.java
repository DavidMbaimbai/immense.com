package com.immense.admin.user;

import com.immense.admin.user.user.UserRepository;
import com.immense.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> listAllUsers(){
        return (List<User>) userRepository.findAll();

    }

}
