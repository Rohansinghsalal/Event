package org.event_magement.event.services;

import org.event_magement.event.dto.VenueDto;

import java.util.List;

public interface VenueService {
    VenueDto createVenue(VenueDto venueDto);
    List<VenueDto> getAllVenues();
    VenueDto getVenueById(Long id);
}
