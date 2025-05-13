package org.event_magement.event.services.serviceImp;

import lombok.RequiredArgsConstructor;
import org.event_magement.event.dto.EventDto;
import org.event_magement.event.module.Event;
import org.event_magement.event.module.Organizer;
import org.event_magement.event.module.Venue;
import org.event_magement.event.repository.EventRepository;
import org.event_magement.event.repository.OrganizerRepository;
import org.event_magement.event.repository.VenueRepository;
import org.event_magement.event.services.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;
    private final OrganizerRepository organizerRepository;

    @Override
    public EventDto createEvent(EventDto eventDto) {
        Event event = new Event();
        event.setTitle(eventDto.getTitle());
        event.setEventType(eventDto.getEventType());
        event.setCategory(eventDto.getCategory());
        event.setStartDatetime(eventDto.getStartDatetime());
        event.setEndDatetime(eventDto.getEndDatetime());
        event.setTicketPrice(eventDto.getTicketPrice());

        Venue venue = venueRepository.findById(eventDto.getVenueId())
                .orElseThrow(() -> new RuntimeException("Venue not found"));
        event.setVenue(venue);

        Organizer organizer = organizerRepository.findById(eventDto.getOrganizerId())
                .orElseThrow(() -> new RuntimeException("Organizer not found"));
        event.setOrganizer(organizer);

        Event savedEvent = eventRepository.save(event);
        eventDto.setId(savedEvent.getId());
        return eventDto;
    }

    @Override
    public List<EventDto> getAllEvents() {
        return eventRepository.findAll().stream().map(e ->
                new EventDto(
                        e.getId(), e.getTitle(), e.getEventType(), e.getCategory(),
                        e.getStartDatetime(), e.getEndDatetime(), e.getTicketPrice(),
                        e.getVenue().getId(), e.getOrganizer().getId()
                )).collect(Collectors.toList());
    }

    @Override
    public EventDto getEventById(Long id) {
        Event e = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        return new EventDto(
                e.getId(), e.getTitle(), e.getEventType(), e.getCategory(),
                e.getStartDatetime(), e.getEndDatetime(), e.getTicketPrice(),
                e.getVenue().getId(), e.getOrganizer().getId()
        );
    }
}

