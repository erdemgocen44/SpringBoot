package com.userservice.Repo;

import com.userservice.domain.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String username);

}
