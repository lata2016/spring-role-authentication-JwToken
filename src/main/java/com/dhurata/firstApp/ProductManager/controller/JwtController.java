package com.dhurata.firstApp.ProductManager.controller;

import com.dhurata.firstApp.ProductManager.model.JwtRequest;
import com.dhurata.firstApp.ProductManager.model.JwtResponse;
import com.dhurata.firstApp.ProductManager.service.JwtService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {
    private JwtService jwtService;

    public JwtController (JwtService jwtService){
        this.jwtService = jwtService;
    }
    @PostMapping("/authenticate")
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
       return jwtService.createJwtToken(jwtRequest);

    }
}
