package com.idle.worknine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idle.worknine.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
