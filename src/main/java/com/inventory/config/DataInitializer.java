package com.inventory.config;

import com.inventory.entity.Role;
import com.inventory.entity.User;
import com.inventory.repository.RoleRepository;
import com.inventory.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (roleRepository.count() == 0) {
            Role adminRole = Role.builder().name("ROLE_ADMIN").build();
            Role employeeRole = Role.builder().name("ROLE_EMPLOYEE").build();
            roleRepository.save(adminRole);
            roleRepository.save(employeeRole);

            User admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin123"))
                .fullName("Administrador")
                .email("admin@inventory.com")
                .enabled(true)
                .roles(Set.of(adminRole))
                .build();
            userRepository.save(admin);
        }
    }

}
