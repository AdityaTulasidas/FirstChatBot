package com.example.demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private ChatClient chatClient;

    public ChatController(ChatClient chatClient) {
        this.chatClient =  chatClient;
    }

    @PostMapping("/chat")
    public String chat(@RequestBody String message) {
       return chatClient.prompt().user(message).call().content();
    }

}
