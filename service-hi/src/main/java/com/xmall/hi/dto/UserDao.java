package com.xmall.hi.dto;

import com.xmall.hi.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
