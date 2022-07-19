package com.ekart.ecommerce.repository;

import com.ekart.ecommerce.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    UserRole findUserRoleByRoleName(String roleName);
}


