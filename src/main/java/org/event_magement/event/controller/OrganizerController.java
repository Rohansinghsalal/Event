package org.event_magement.event.controller;

import lombok.RequiredArgsConstructor;
import org.event_magement.event.dto.OrganizerDto;
import org.event_magement.event.services.OrganizerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizers")
@RequiredArgsConstructor
public class OrganizerController {

    private final OrganizerService organizerService;

    @PostMapping
    public ResponseEntity<OrganizerDto> createOrganizer(@RequestBody OrganizerDto dto) {
        return new ResponseEntity<>(organizerService.createOrganizer(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrganizerDto>> getAllOrganizers() {
        return ResponseEntity.ok(organizerService.getAllOrganizers());
    }
}

