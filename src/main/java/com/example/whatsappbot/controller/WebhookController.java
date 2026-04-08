package com.example.whatsappbot.controller;

import com.example.whatsappbot.model.ChatRequest;
import com.example.whatsappbot.model.ChatResponse;
import com.example.whatsappbot.service.ChatbotService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);

    private final ChatbotService chatbotService;

    public WebhookController(ChatbotService chatbotService) {
        this.chatbotService = chatbotService;
    }

    @GetMapping("/test")
    public ResponseEntity<Map<String, String>> testWebhookRoute() {
        logger.info("Webhook test endpoint invoked");
        return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "Webhook endpoint is reachable"
        ));
    }

    @PostMapping
    public ResponseEntity<ChatResponse> receiveMessage(@Valid @RequestBody ChatRequest request) {
        logger.info("Received message '{}' from sender '{}'", request.getMessage(), request.getSender());

        ChatResponse response = chatbotService.createResponse(request);

        logger.info("Sending response with status '{}' and reply '{}'", response.getStatus(), response.getReply());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> webhookHealth() {
        logger.debug("Webhook health endpoint invoked");
        return ResponseEntity.ok(Map.of(
                "status", "UP",
                "service", "whatsapp-bot"
        ));
    }
}
