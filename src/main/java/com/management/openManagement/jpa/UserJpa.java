package com.management.openManagement.jpa;

import com.management.openManagement.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpa extends JpaRepository<User,Long> {
}
