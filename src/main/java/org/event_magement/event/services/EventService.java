package org.event_magement.event.services;

import org.event_magement.event.dto.EventDto;

import java.util.List;

public interface EventService {
    EventDto createEvent(EventDto eventDto);
    List<EventDto> getAllEvents();
    EventDto getEventById(Long id);
}
