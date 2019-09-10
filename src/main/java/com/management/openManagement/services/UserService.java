package com.management.openManagement.services;

import com.management.openManagement.dto.NoteDto;
import com.management.openManagement.jpa.UserJpa;
import com.management.openManagement.models.User;
import com.management.openManagement.models.note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service("userService")
public class UserService implements IUserService{
    private final UserJpa userJpa;

    public UserService(UserJpa userJpa) {
        this.userJpa = userJpa;
    }
    @Override
    public List<User> findAll() {
        return userJpa.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userJpa.findById(id);
    }

    @Override
    public User save(User user) {
        return userJpa.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userJpa.deleteById(id);
    }

    public String saySomeThing(String someThing){
        System.out.println(someThing);
        return someThing;
    }

    public List<NoteDto> getAllNotesByUser(Long id){
        Optional<User> user = userJpa.findById(id);
        Set<note> notes = user.get().getNotes();
        // return ResponseEntity.ok(notes);   Cannot do this in this way WHY ?
        List<NoteDto> noteDtoList = new ArrayList<>();
        notes.forEach(note -> {
            NoteDto newNoteDto = new NoteDto();
            newNoteDto.setId(note.getId());
            newNoteDto.setContent(note.getContent());
            newNoteDto.setTitle(note.getTitle());
            newNoteDto.setOwner(note.getOwner());
            noteDtoList.add(newNoteDto);
        });
        return noteDtoList;
    }
}
