package org.event_magement.event.services;

import org.event_magement.event.dto.OrganizerDto;

import java.util.List;

public interface OrganizerService {
    OrganizerDto createOrganizer(OrganizerDto organizerDto);
    List<OrganizerDto> getAllOrganizers();
}
