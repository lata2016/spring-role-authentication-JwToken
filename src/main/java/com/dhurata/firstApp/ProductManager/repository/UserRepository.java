package com.dhurata.firstApp.ProductManager.repository;

import com.dhurata.firstApp.ProductManager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUserName(String userName);
}
