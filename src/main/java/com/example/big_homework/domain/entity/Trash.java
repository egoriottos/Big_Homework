package com.example.big_homework.domain.entity;

import com.example.big_homework.domain.valueObj.BaseClass;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trash")
public class Trash extends BaseClass {

    @OneToMany
    private List<Product> products;

    @OneToOne
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trash trash = (Trash) o;
        return Objects.equals(id, trash.id)
                && Objects.equals(products,trash.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
