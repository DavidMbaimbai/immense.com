package com.immense.admin.user;

import com.immense.admin.user.user.RoleRepository;
import com.immense.admin.user.user.UserRepository;
import com.immense.common.entity.Role;
import com.immense.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public List<User> listAllUsers(){
        return (List<User>) userRepository.findAll();

    }
    public List<Role> listRoles(){
        return (List<Role>) roleRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
