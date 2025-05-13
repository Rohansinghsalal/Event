package org.event_magement.event.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizerDto {
    private Long id;
    private String organization;
    private String contactNumber;
    private String email;
}

