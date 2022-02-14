package com.immense.admin.user;

import com.immense.admin.user.user.UserRepository;
import com.immense.common.entity.Role;
import com.immense.common.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testCreateNewUserWithOneRole(){
        Role roleAdmin=testEntityManager.find(Role.class, 1);
        User user = new User("davymbaimbai@gmail.com", "J0h@n314vs!", "David", "Mbaimbai");
        user.addRole(roleAdmin);
        User savedUser = userRepository.save(user);
        assertThat(savedUser.getId()).isGreaterThan(0);

    }

    @Test
    public void testCreateNewUserWithTwoRoles(){
        User user = new User("paumbaimbai@gmail.com", "pau2011", "Pauline", "Mbaimbai");
        Role roleEditor = new Role(3);
        Role roleAssistant = new Role(5);
        user.addRole(roleEditor);
        user.addRole(roleAssistant);
        User savedUser = userRepository.save(user);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindAllUsers(){
        Iterable<User> listUsers = userRepository.findAll();
        listUsers.forEach(user -> System.out.println(user));
    }

    @Test
    public void testFindUserById(){
        User user = userRepository.findById(1).get();
        System.out.println(user);
        assertThat(user.getId()).isNotNull();
    }

    @Test
    public void testUpdateUserDetails(){
        User user = userRepository.findById(1).get();
        user.setEnabled(true);
        user.setEmail("tanyambaimbai@gmail.com");
        userRepository.save(user);
    }

    @Test
    public void testUpdateUserRoles(){
        User user = userRepository.findById(2).get();
        Role roleEditor = new Role(3);
        Role roleSalesperson = new Role(2);
        user.getRoles().remove(roleEditor);
        user.addRole(roleSalesperson);
        userRepository.save(user);


    }
    @Test
    public void testDeleteUserById(){
        Integer userId =2;
        userRepository.deleteById(userId);

    }
}
