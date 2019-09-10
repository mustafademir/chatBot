package com.management.openManagement.services;

import com.management.openManagement.dto.NoteDto;
import com.management.openManagement.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public List<User> findAll();

    public Optional<User> findById(Long id);

    public User save(User user);

    public void deleteById(Long id);

    public List<NoteDto> getAllNotesByUser(Long id);
}
