package com.management.openManagement.services;

import com.management.openManagement.models.note;

import java.util.List;
import java.util.Optional;

public interface INoteService {
    public List<note> findAll();

    public Optional<note> findById(Long id);

    public note save(note stock);

    public void deleteById(Long id);
}
