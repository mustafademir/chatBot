package com.management.openManagement.noteApi;

import com.management.openManagement.dto.ChatDto;
import com.management.openManagement.services.AiBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * @author mustafad
 */

@RestController
@RequestMapping("/aiChat")
public class AiChatApi {

    @Autowired
    private AiBotService aiBotService;


    @PostMapping
    public ResponseEntity create(@Valid @RequestBody ChatDto chatDto) {
        ChatDto chatResponse = new ChatDto();
        chatResponse.setServerResponse(aiBotService.talk(chatDto.getClientRequest()));
        return ResponseEntity.ok(chatResponse);
    }
}
