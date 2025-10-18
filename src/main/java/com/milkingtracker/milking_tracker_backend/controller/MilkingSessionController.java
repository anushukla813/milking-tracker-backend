package com.milkingtracker.milking_tracker_backend.controller;
import com.milkingtracker.milking_tracker_backend.model.MilkingSession;
import com.milkingtracker.milking_tracker_backend.repository.MilkingSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/sessions")
@CrossOrigin(origins = "http://localhost:3000")
public class MilkingSessionController {
    @Autowired
    private MilkingSessionRepository sessionRepository;

    @GetMapping
    public List<MilkingSession> getAllSessions() {
        return sessionRepository.findAllByOrderByCreatedAtDesc();
    }

    @PostMapping
    public ResponseEntity<MilkingSession> createSession(@RequestBody MilkingSession session) {


        if (session.getStartTime() == null || session.getEndTime() == null || session.getDuration() == null || session.getMilkQuantity() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            MilkingSession savedSession = sessionRepository.save(session);
            return new ResponseEntity<>(savedSession, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Error saving session:" + e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable Long id) {
        try {
            if (!sessionRepository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            sessionRepository.deleteById(id);
            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
