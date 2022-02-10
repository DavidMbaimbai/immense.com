package com.immense.admin.user;

import com.immense.admin.user.user.RoleRepository;
import com.immense.common.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@EnableJpaRepositories
public class RoleRepositoryTests {
    @Autowired
    private RoleRepository repository;

    @Test
    public void testCreateRole(){
        Role roleAdmin = new Role("Admin", "Manage everything");
        Role savedRole = repository.save(roleAdmin);
        assert(savedRole.getId())>0;

    }
}
