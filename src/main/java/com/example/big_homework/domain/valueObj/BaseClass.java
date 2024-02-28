package com.example.big_homework.domain.valueObj;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
@NoArgsConstructor
@MappedSuperclass
@Data
public class BaseClass {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseClass baseClass = (BaseClass) o;
        return Objects.equals(id, baseClass.id) && Objects.equals(createdAt, baseClass.createdAt) && Objects.equals(updatedAt, baseClass.updatedAt) && Objects.equals(deletedAt, baseClass.deletedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, deletedAt);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
