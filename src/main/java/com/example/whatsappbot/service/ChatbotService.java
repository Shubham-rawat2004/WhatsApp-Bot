package com.example.whatsappbot.service;

import com.example.whatsappbot.model.ChatRequest;
import com.example.whatsappbot.model.ChatResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Set;

@Service
public class ChatbotService {

    private static final Logger logger = LoggerFactory.getLogger(ChatbotService.class);
    private static final String DEFAULT_RESPONSE = "Sorry, I don't understand";
    private static final String SUCCESS_STATUS = "success";
    private static final Set<String> GREETING_KEYWORDS = Set.of("hi", "hello", "hey");
    private static final Set<String> FAREWELL_KEYWORDS = Set.of("bye", "goodbye", "see you");
    private static final Set<String> WELLBEING_KEYWORDS = Set.of("how are you", "how are you doing", "how do you do");

    public ChatResponse createResponse(ChatRequest request) {
        String reply = generateResponse(request.getMessage());
        return new ChatResponse(reply, SUCCESS_STATUS);
    }

    public String generateResponse(String message) {
        String normalizedMessage = message.trim();
        String lowerCaseMessage = normalizedMessage.toLowerCase(Locale.ROOT);

        logger.debug("Generating response for normalized message '{}'", normalizedMessage);

        if (matchesAny(lowerCaseMessage, GREETING_KEYWORDS)) {
            return "Hello";
        }

        if (matchesAny(lowerCaseMessage, FAREWELL_KEYWORDS)) {
            return "Goodbye";
        }

        if (matchesAny(lowerCaseMessage, WELLBEING_KEYWORDS)
                || containsAllKeywords(lowerCaseMessage, "how", "you")) {
            return "I'm fine!";
        }

        if (containsAnyKeyword(lowerCaseMessage, "help", "support")) {
            return "I can help with simple greetings and basic chatbot questions.";
        }

        if (containsAnyKeyword(lowerCaseMessage, "thanks", "thank you")) {
            return "You're welcome!";
        }

        logger.info("No predefined response configured for message '{}'", normalizedMessage);
        return DEFAULT_RESPONSE;
    }

    private boolean matchesAny(String message, Set<String> phrases) {
        return phrases.stream().anyMatch(message::equals);
    }

    private boolean containsAnyKeyword(String message, String... keywords) {
        for (String keyword : keywords) {
            if (message.contains(keyword)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsAllKeywords(String message, String... keywords) {
        for (String keyword : keywords) {
            if (!message.contains(keyword)) {
                return false;
            }
        }
        return true;
    }
}
