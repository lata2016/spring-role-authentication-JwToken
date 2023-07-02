package com.dhurata.firstApp.ProductManager.controller;

import com.dhurata.firstApp.ProductManager.model.Role;
import com.dhurata.firstApp.ProductManager.service.RoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    private RoleService roleService;

    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }
    //create an endpoint to save role to the table
    @PostMapping("/createNewRole")
    public Role createNewRole(@RequestBody Role role){
        return roleService.createNewRole(role);
    }

}
