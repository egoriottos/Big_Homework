package com.example.big_homework.domain.valueObj;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
@Data
@Setter
@Getter
@ToString
public class BaseClass {

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="created at",nullable = true)
    private LocalDateTime createdAt = LocalDateTime.now();

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="updated at",nullable = true)
    private LocalDateTime updatedAt;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="dealeted at",nullable = true)
    private LocalDateTime deletedAt;
}
