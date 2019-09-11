package com.management.openManagement.noteApi;

import com.management.openManagement.dto.ChatDto;
import com.management.openManagement.services.AiBotService;
import com.management.openManagement.services.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * @author mustafad
 */

@RestController
@RequestMapping("/aiChat")
public class AiChatApi {

    @Autowired
    private AiBotService aiBotService;

    @Autowired
    private TranslateService translateService;


    @PostMapping
    public ResponseEntity create(@Valid @RequestBody ChatDto chatDto) {
        ChatDto chatResponse = new ChatDto();
        chatResponse.setServerResponse(aiBotService.talk(chatDto.getClientRequest()));
        return ResponseEntity.ok(chatResponse);
    }

    @GetMapping
    public ResponseEntity translate(@Valid @RequestBody String text) {
      String translatedText = translateService.translate(text);
      return ResponseEntity.ok(translatedText);
    }
}
