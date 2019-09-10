package com.management.openManagement.noteApi;

import com.management.openManagement.dto.NoteDto;
import com.management.openManagement.services.INoteService;
import com.management.openManagement.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/user/util/")
public class UserProcessApi {

    @Autowired
    INoteService noteService;

    @Autowired  //Why not recommended ?
            IUserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<NoteDto>> getAllNotesByUser(@PathVariable Long id){
        List<NoteDto> noteDtoList = new ArrayList<>();
        noteDtoList = userService.getAllNotesByUser(id);
        return ResponseEntity.ok(noteDtoList);
    }


}
