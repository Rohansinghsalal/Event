package org.event_magement.event.services.serviceImp;

import lombok.RequiredArgsConstructor;
import org.event_magement.event.dto.LiveStreamDto;
import org.event_magement.event.module.Event;
import org.event_magement.event.module.LiveStream;
import org.event_magement.event.repository.EventRepository;
import org.event_magement.event.repository.LiveStreamRepository;
import org.event_magement.event.services.LiveStreamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LiveStreamServiceImpl implements LiveStreamService {

    private final LiveStreamRepository liveStreamRepository;
    private final EventRepository eventRepository;

    @Override
    public LiveStreamDto createLiveStream(LiveStreamDto dto) {
        Event event = eventRepository.findById(dto.getEventId())
                .orElseThrow(() -> new RuntimeException("Event not found"));

        LiveStream ls = new LiveStream();
        ls.setPlatform(dto.getPlatform());
        ls.setStreamUrl(dto.getStreamUrl());
        ls.setStartTime(dto.getStartTime());
        ls.setEndTime(dto.getEndTime());
        ls.setIsActive(dto.getIsActive());
        ls.setEvent(event);

        LiveStream saved = liveStreamRepository.save(ls);
        dto.setId(saved.getId());
        return dto;
    }

    @Override
    public List<LiveStreamDto> getAllLiveStreams() {
        return liveStreamRepository.findAll().stream()
                .map(l -> new LiveStreamDto(l.getId(), l.getPlatform(), l.getStreamUrl(),
                        l.getStartTime(), l.getEndTime(), l.getIsActive(), l.getEvent().getId()))
                .collect(Collectors.toList());
    }
}

