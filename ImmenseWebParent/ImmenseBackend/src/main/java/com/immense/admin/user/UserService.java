package com.immense.admin.user;
import com.immense.common.entity.Role;
import com.immense.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<User> listAllUsers(){
        return (List<User>) userRepository.findAll();

    }
    public List<Role> listRoles(){
        return (List<Role>) roleRepository.findAll();
    }

    public void save(User user) {
        encodePassword(user);
        userRepository.save(user);
    }
    private void encodePassword(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }
    public boolean isEmailUnique(String email){
        User userEmail = userRepository.getUsersByEmail(email);
        return userEmail==null;
    }

    public User get(Integer id) throws UserNotFoundException {
        try {
            return userRepository.findById(id).get();
        }catch (NoSuchElementException ex){
            throw new UserNotFoundException("Could not find any user with ID " + id);
        }

    }
}
