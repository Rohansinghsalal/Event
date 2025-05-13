package org.event_magement.event.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiveStreamDto {
    private Long id;
    private String platform;
    private String streamUrl;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean isActive;
    private Long eventId;
}

