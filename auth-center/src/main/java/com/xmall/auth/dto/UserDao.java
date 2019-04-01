package com.xmall.auth.dto;

import com.xmall.auth.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
    User findByUsername( String username );
}

