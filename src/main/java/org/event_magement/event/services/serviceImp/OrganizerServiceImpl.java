package org.event_magement.event.services.serviceImp;

import lombok.RequiredArgsConstructor;
import org.event_magement.event.dto.OrganizerDto;
import org.event_magement.event.module.Organizer;
import org.event_magement.event.repository.OrganizerRepository;
import org.event_magement.event.services.OrganizerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizerService {

    private final OrganizerRepository organizerRepository;

    @Override
    public OrganizerDto createOrganizer(OrganizerDto dto) {
        Organizer org = new Organizer();
        org.setOrganization(dto.getOrganization());
        org.setContactNumber(dto.getContactNumber());
        org.setEmail(dto.getEmail());

        Organizer saved = organizerRepository.save(org);
        dto.setId(saved.getId());
        return dto;
    }

    @Override
    public List<OrganizerDto> getAllOrganizers() {
        return organizerRepository.findAll().stream()
                .map(o -> new OrganizerDto(o.getId(), o.getOrganization(), o.getContactNumber(), o.getEmail()))
                .collect(Collectors.toList());
    }
}

