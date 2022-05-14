package com.sailesh.springproject.applestore.dao;

import com.sailesh.springproject.applestore.entity.Role;
import com.sailesh.springproject.applestore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {


}
