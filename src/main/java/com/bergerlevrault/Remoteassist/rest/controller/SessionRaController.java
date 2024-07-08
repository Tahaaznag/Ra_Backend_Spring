package com.bergerlevrault.Remoteassist.rest.controller;

import com.bergerlevrault.Remoteassist.Dto.ChatDto;
import com.bergerlevrault.Remoteassist.Dto.SessionRaDto;
import com.bergerlevrault.Remoteassist.Entity.UserRa;
import com.bergerlevrault.Remoteassist.Service.SessionRaService;
import com.bergerlevrault.Remoteassist.utils.ResourcesPath;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ResourcesPath.SESSION)
public class SessionRaController {

    private final SessionRaService sessionRaService;

    public SessionRaController(SessionRaService sessionRaService) {
        this.sessionRaService = sessionRaService;
    }

    @PostMapping("/create")
    public ResponseEntity<SessionRaDto> createSession(@RequestBody SessionRaDto sessionDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long userId = ((UserRa) authentication.getPrincipal()).getUserId();
        SessionRaDto newSession = sessionRaService.createSession(sessionDto, userId);
        return new ResponseEntity<>(newSession, HttpStatus.CREATED);
    }

    @PostMapping("/join")
    public ResponseEntity<SessionRaDto> joinSession(@RequestParam String roomCode) {
        SessionRaDto session = sessionRaService.joinSession(roomCode);
        return new ResponseEntity<>(session, HttpStatus.OK);
    }
    @GetMapping("/chats")
    public ResponseEntity<List<ChatDto>> getChatsByRoomCode(@RequestParam String roomCode) {
        List<ChatDto> chats = sessionRaService.getChatsBySession(roomCode);
        return new ResponseEntity<>(chats, HttpStatus.OK);
    }

    @GetMapping(ResourcesPath.ALLSESSIONS)
    public ResponseEntity<List<SessionRaDto>> getAllSessions() {
        List<SessionRaDto> sessions = sessionRaService.getAllSessions();
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }

    @GetMapping(ResourcesPath.ACTIVE)
    public ResponseEntity<List<SessionRaDto>> getActiveSessions() {
        List<SessionRaDto> activeSessions = sessionRaService.getActiveSessions();
        return new ResponseEntity<>(activeSessions, HttpStatus.OK);
    }
}