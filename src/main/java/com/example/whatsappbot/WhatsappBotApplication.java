package com.example.whatsappbot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WhatsappBotApplication {

    private static final Logger logger = LoggerFactory.getLogger(WhatsappBotApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WhatsappBotApplication.class, args);
        logger.info("WhatsApp Bot application started successfully");
        System.out.println("Welcome to WhatsappBot");
    }
}
