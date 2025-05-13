package org.event_magement.event.module;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Table(name = "livestream")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LiveStream {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String platform;
    private String streamUrl;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    public void setIsActive(Boolean isActive) {
    }

    public Boolean getIsActive() {
        return isActive;
    }
}
