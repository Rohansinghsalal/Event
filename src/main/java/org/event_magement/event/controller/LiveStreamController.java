package org.event_magement.event.controller;

import lombok.RequiredArgsConstructor;
import org.event_magement.event.dto.LiveStreamDto;
import org.event_magement.event.services.LiveStreamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livestreams")
@RequiredArgsConstructor
public class LiveStreamController {

    private final LiveStreamService liveStreamService;

    @PostMapping
    public ResponseEntity<LiveStreamDto> createLiveStream(@RequestBody LiveStreamDto dto) {
        return new ResponseEntity<>(liveStreamService.createLiveStream(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LiveStreamDto>> getAllLiveStreams() {
        return ResponseEntity.ok(liveStreamService.getAllLiveStreams());
    }
}

