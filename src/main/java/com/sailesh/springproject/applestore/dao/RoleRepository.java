package com.sailesh.springproject.applestore.dao;

import com.sailesh.springproject.applestore.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {


}
