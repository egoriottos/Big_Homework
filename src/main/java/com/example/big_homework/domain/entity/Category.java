package com.example.big_homework.domain.entity;

import com.example.big_homework.domain.valueObj.BaseClass;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.List;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "category")
public class Category {
    @Embedded
    private BaseClass baseClass;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="category_id")
    public Integer id;

    private String title;

    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Product> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(baseClass, category.baseClass) && Objects.equals(id, category.id) && Objects.equals(title, category.title) && Objects.equals(products, category.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseClass, id, title, products);
    }
}
