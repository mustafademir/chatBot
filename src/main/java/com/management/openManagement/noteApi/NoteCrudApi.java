package com.management.openManagement.noteApi;

import com.management.openManagement.dto.NoteDto;
import com.management.openManagement.models.note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class NoteCrudApi {

    @Autowired
    private com.management.openManagement.services.noteService noteService;

    @GetMapping
    public ResponseEntity<List<note>> findAll() {
        return ResponseEntity.ok(noteService.findAll());
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public ResponseEntity<NoteDto> findById(@PathVariable Long id) {
        System.out.println("ASDASDFASDFSDF");
        Optional<note> stock = noteService.findById(id);
        if (!stock.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        NoteDto dt = new NoteDto();
        dt.setId(stock.get().getId());
        dt.setContent(stock.get().getContent());
        dt.setTitle(stock.get().getTitle() + dt.sayHello() + String.valueOf(dt.getContentLength(dt)));

        return ResponseEntity.ok(dt);
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody NoteDto noteDto) {
        note newNote = new note();
        newNote.setId(noteDto.getId());
        newNote.setContent(noteDto.getContent());
        newNote.setTitle(noteDto.getTitle());
        newNote.setOwner(noteDto.getOwner());
        return ResponseEntity.ok(noteService.save(newNote));
    }

    @PutMapping("/{id}")
    public ResponseEntity<note> update(@PathVariable Long id, @Valid @RequestBody NoteDto noteDto) {
        if (!noteService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        note newNote = new note();
        newNote.setId(id);
        newNote.setContent(noteDto.getContent());
        newNote.setTitle(noteDto.getTitle());
        newNote.setOwner(noteDto.getOwner());
        return ResponseEntity.ok(noteService.save(newNote));
    }
}
