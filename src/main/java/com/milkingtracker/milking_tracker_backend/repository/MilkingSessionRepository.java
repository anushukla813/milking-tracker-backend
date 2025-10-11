package com.milkingtracker.milking_tracker_backend.repository;
import com.milkingtracker.milking_tracker_backend.model.MilkingSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MilkingSessionRepository extends JpaRepository<MilkingSession,Long> {
    List<MilkingSession> findAllByOrderByCreatedAtDesc();
}
