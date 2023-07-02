package com.dhurata.firstApp.ProductManager.service;

import com.dhurata.firstApp.ProductManager.model.Role;
import com.dhurata.firstApp.ProductManager.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }
    public Role createNewRole(Role role){
        return roleRepository.save(role);
    }
}
