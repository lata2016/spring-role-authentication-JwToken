package com.dhurata.firstApp.ProductManager.repository;

import com.dhurata.firstApp.ProductManager.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoleRepository  extends JpaRepository<Role,String> {
}
