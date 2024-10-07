package com.example.technicaltestptsisi.repository;

import com.example.technicaltestptsisi.entity.ERole;
import com.example.technicaltestptsisi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole roleName);
}
