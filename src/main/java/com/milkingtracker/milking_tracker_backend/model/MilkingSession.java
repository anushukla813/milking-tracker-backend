package com.milkingtracker.milking_tracker_backend.model;


import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "milking_sessions")
public class MilkingSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_time",nullable = false)
    private Instant startTime;

    @Column(name = "end_time",nullable = false)
    private Instant endTime;

    @Column(name = "duration",nullable = false)
    private Integer duration;

    @Column(name = "milk_quantity",nullable = false)
    private Double milkQuantity;

    @Column(name = "created_at",updatable = false)
    private Instant createdAt = Instant.now();


public MilkingSession(){}
public Long getId(){
    return id;
}

public Instant getStartTime(){
    return startTime;
}
public void setStartTime(Instant startTime){
    this.startTime = startTime;
}
public Instant getEndTime(){
    return endTime;
}
public void setEndTime(Instant endTime){
    this.endTime = endTime;
}

public Integer getDuration(){
    return duration;
}

public void setDuration(Integer duration){
    this.duration = duration;
}
public Double getMilkQuantity(){
    return milkQuantity;
}
public void setMilkQuantity(Double milkQuantity){
    this.milkQuantity = milkQuantity;
}

public Instant getCreatedAt(){
    return createdAt;
}
}