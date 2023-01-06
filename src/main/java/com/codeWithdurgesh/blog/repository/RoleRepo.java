package com.codeWithdurgesh.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeWithdurgesh.blog.entities.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

}
