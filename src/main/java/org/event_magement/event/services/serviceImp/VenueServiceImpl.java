package org.event_magement.event.services.serviceImp;

import lombok.RequiredArgsConstructor;
import org.event_magement.event.dto.VenueDto;
import org.event_magement.event.module.Venue;
import org.event_magement.event.repository.VenueRepository;
import org.event_magement.event.services.VenueService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VenueServiceImpl implements VenueService {

    private final VenueRepository venueRepository;

    @Override
    public VenueDto createVenue(VenueDto venueDto) {
        Venue venue = new Venue();
        venue.setName(venueDto.getName());
        venue.setCity(venueDto.getCity());
        venue.setCapacity(venueDto.getCapacity());

        Venue savedVenue = venueRepository.save(venue);

        venueDto.setId(savedVenue.getId());
        return venueDto;
    }

    @Override
    public List<VenueDto> getAllVenues() {
        List<Venue> venues = venueRepository.findAll();
        return venues.stream()
                .map(v -> new VenueDto(v.getId(), v.getName(), v.getCity(), v.getCapacity()))
                .collect(Collectors.toList());
    }

    @Override
    public VenueDto getVenueById(Long id) {
        Venue venue = venueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venue not found with id " + id));
        return new VenueDto(venue.getId(), venue.getName(), venue.getCity(), venue.getCapacity());
    }
}

