package org.event_magement.event.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueDto {
    private Long id;
    private String name;
    private String city;
    private Integer capacity;
}
