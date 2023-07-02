package com.dhurata.firstApp.ProductManager.service;

import com.dhurata.firstApp.ProductManager.model.Role;
import com.dhurata.firstApp.ProductManager.model.User;
import com.dhurata.firstApp.ProductManager.repository.RoleRepository;
import com.dhurata.firstApp.ProductManager.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerNewUser (User user){
        return userRepository.save(user);
    }
    public void initRolesAndUser(){
        //admin role
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role here");
        roleRepository.save(adminRole);

        //user role
        Role userRole = new Role();
        userRole.setRoleName("User ");
        userRole.setRoleDescription("User role here");
        roleRepository.save(userRole);

        //register user as admin
        User adminUser = new User();
        adminUser.setUserFirstName("dhurata");
        adminUser.setUserLastName("Har");
        adminUser.setUserName("dhurata123");
       // adminUser.setUserPassword("123");
        adminUser.setUserPassword(getEncoderPassword("123"));//encode password

        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userRepository.save(adminUser);

        //register user
        User simpleUser = new User();
        simpleUser.setUserFirstName("adea");
        simpleUser.setUserLastName("Har");
        simpleUser.setUserName("adea");
        // simpleUser.setUserPassword("adea22");
        simpleUser.setUserPassword(getEncoderPassword("adea"));

        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        simpleUser.setRole(userRoles);
        userRepository.save(simpleUser);

    }
    public String getEncoderPassword (String password){
        return passwordEncoder.encode(password);
    }

}
