package org.event_magement.event.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    private Long id;
    private String title;
    private String eventType;
    private String category;
    private LocalDateTime startDatetime;
    private LocalDateTime endDatetime;
    private BigDecimal ticketPrice;
    private Long venueId;
    private Long organizerId;
}

