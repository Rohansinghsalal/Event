package org.event_magement.event.services;

import org.event_magement.event.dto.LiveStreamDto;

import java.util.List;

public interface LiveStreamService {
    LiveStreamDto createLiveStream(LiveStreamDto dto);
    List<LiveStreamDto> getAllLiveStreams();
}
