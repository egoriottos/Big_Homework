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
public class Trash  {
    @Embedded
    private BaseClass baseClass;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="trash_id")
    public Integer id;

    @OneToMany
    private List<Product> products;

    @OneToOne
    @JoinColumn(name = "history_id")
    private History history;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trash trash = (Trash) o;
        return Objects.equals(baseClass, trash.baseClass) && Objects.equals(id, trash.id) && Objects.equals(products, trash.products) && Objects.equals(user, trash.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseClass, id, products, user);
    }
}
