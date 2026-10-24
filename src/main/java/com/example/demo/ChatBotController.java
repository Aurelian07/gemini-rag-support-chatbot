package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ChatBotController {

    private final ChatBotService chatbotService;

    public ChatBotController(ChatBotService chatbotService) {
        this.chatbotService = chatbotService;
    }

    @GetMapping("/query")
    public Map<String, String> query(@RequestParam String question) {
        return Map.of("answer", chatbotService.answerUserQuery(question));
    }
    @PostMapping("/query")
    public Map<String, String> queryPost(@RequestBody Map<String, String> body) {
        String question = body.get("question");
        return Map.of("answer", chatbotService.answerUserQuery(question));
    }
}

