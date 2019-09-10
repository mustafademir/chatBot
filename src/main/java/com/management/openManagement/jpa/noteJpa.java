package com.management.openManagement.jpa;

import com.management.openManagement.models.note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface noteJpa extends JpaRepository<note,Long> {
}
