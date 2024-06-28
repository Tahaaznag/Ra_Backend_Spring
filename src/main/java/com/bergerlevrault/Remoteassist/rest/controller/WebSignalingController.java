package com.bergerlevrault.Remoteassist.rest.controller;

import com.bergerlevrault.Remoteassist.Dto.WebRTCSignalDto;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSignalingController {

    @MessageMapping("/webrtc/{roomId}")
    @SendTo("/topic/webrtc/{roomId}")
    public WebRTCSignalDto handleWebRTCSignal(@DestinationVariable String roomId, WebRTCSignalDto signal) {
        return signal;
    }
}
