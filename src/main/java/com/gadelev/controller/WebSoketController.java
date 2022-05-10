package com.gadelev.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gadelev.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class WebSoketController {
    private final SimpMessagingTemplate template;

    private final ObjectMapper mapper;

    @MessageMapping("/message")
    public void receiveMessageFromClient(Message<String> message, Authentication authentication) {
        try {
            MessageDto messageDto = mapper.readValue(message.getPayload(), MessageDto.class);
            template.convertAndSend("/messages", mapper.writeValueAsString(MessageDto.builder()
                    .message(authentication.getName() + ": <br>" + messageDto.getMessage()).build()));
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
