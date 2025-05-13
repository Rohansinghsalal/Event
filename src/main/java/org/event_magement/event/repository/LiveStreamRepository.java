package org.event_magement.event.repository;

import org.event_magement.event.module.LiveStream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiveStreamRepository extends JpaRepository<LiveStream, Long> {
}

