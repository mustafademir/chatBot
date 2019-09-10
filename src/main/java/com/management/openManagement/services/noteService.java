package com.management.openManagement.services;

import com.management.openManagement.jpa.noteJpa;
import com.management.openManagement.models.note;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class noteService implements INoteService,INoteUtilService {
    private final noteJpa noteJpa;

    public noteService(com.management.openManagement.jpa.noteJpa noteJpa) {
        this.noteJpa = noteJpa;
    }

    public List<note> findAll() {
        return noteJpa.findAll();
    }

    public Optional<note> findById(Long id) {
        return noteJpa.findById(id);
    }

    public note save(note stock) {
        return noteJpa.save(stock);
    }

    public void deleteById(Long id) {
        noteJpa.deleteById(id);
    }

    public String saySomeThing(String someThing){
        System.out.println(someThing);
        return someThing;
    }
}
