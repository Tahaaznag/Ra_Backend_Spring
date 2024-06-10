package com.bergerlevrault.Remoteassist.rest.controller;

import com.bergerlevrault.Remoteassist.Entity.WebRTCMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WebRTCController {

    private static final Logger logger = LoggerFactory.getLogger(WebRTCController.class);

    private Map<String, WebRTCMessage> offerStorage = new HashMap<>();
    private Map<String, WebRTCMessage> answerStorage = new HashMap<>();
    private Map<String, WebRTCMessage> candidateStorage = new HashMap<>();

    @MessageMapping("/webrtc.offer")
    @SendTo("/queue/response")
    public WebRTCMessage handleOffer(@Payload WebRTCMessage message, SimpMessageHeaderAccessor headerAccessor) {
        // Store the offer
        logger.info("Received offer: {}", message.getSdp());
        offerStorage.put(String.valueOf(message.getRoomId()), message);
        // Notify other participants
        headerAccessor.getSessionAttributes().put("roomId", message.getRoomId());
        return message;
    }

    @MessageMapping("/webrtc.answer")
    @SendTo("/queue/response")
    public WebRTCMessage handleAnswer(@Payload WebRTCMessage message, SimpMessageHeaderAccessor headerAccessor) {
        // Store the answer
        logger.info("Received answer: {}", message.getSdp());
        answerStorage.put(String.valueOf(message.getRoomId()), message);
        // Notify other participants
        headerAccessor.getSessionAttributes().put("roomId", message.getRoomId());
        return message;
    }

    @MessageMapping("/webrtc.candidate")
    @SendTo("/queue/response")
    public WebRTCMessage handleCandidate(@Payload WebRTCMessage message, SimpMessageHeaderAccessor headerAccessor) {
        // Store the candidate
        logger.info("Received candidate: {}", message.getCandidate());
        candidateStorage.put(String.valueOf(message.getRoomId()), message);
        // Notify other participants
        headerAccessor.getSessionAttributes().put("roomId", message.getRoomId());
        return message;
    }
}