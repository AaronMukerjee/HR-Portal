package com.hruser.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hruser.main.model.HRUser;

public interface UserRepository extends JpaRepository<HRUser,String> {

}
