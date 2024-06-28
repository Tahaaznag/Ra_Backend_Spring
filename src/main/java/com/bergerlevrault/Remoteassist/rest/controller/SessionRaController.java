package com.bergerlevrault.Remoteassist.rest.controller;

import com.bergerlevrault.Remoteassist.Dto.SessionRaDto;
import com.bergerlevrault.Remoteassist.Entity.SessionRa;
import com.bergerlevrault.Remoteassist.Service.SessionRaService;
import com.bergerlevrault.Remoteassist.utils.ResourcesPath;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        SessionRaDto newSession = sessionRaService.createSession(sessionDto);
        return new ResponseEntity<>(newSession, HttpStatus.CREATED);
    }

    @PostMapping("/join")
    public ResponseEntity<SessionRaDto> joinSession(@RequestParam String roomCode) {
        SessionRaDto session = sessionRaService.joinSession(roomCode);
        return new ResponseEntity<>(session, HttpStatus.OK);
    }

    @GetMapping(ResourcesPath.ALLSESSIONS)
    public ResponseEntity<List<SessionRaDto>> getAllSessions() {
        List<SessionRaDto> sessions =sessionRaService.getAllSessions();
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }

    @GetMapping(ResourcesPath.ACTIVE)
    public ResponseEntity<List<SessionRaDto>> getActiveSessions() {
        List<SessionRaDto> activeSessions = sessionRaService.getActiveSessions();
        return new ResponseEntity<>(activeSessions, HttpStatus.ACCEPTED);
    }
}
