package com.example.big_homework.domain.entity;

import com.example.big_homework.domain.valueObj.BaseClass;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Objects;

@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Embedded
    private BaseClass baseClass;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "products")
    private String title;

    @Column(name = "price")
    private Integer price;

    // как правильно обрабатывать владельца в комманде/квери, подсказка: Jackson поможет
    @ManyToOne
    private User owner;
    @ManyToOne()
    private Category category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(baseClass, product.baseClass) && Objects.equals(id, product.id) && Objects.equals(title, product.title) && Objects.equals(price, product.price) && Objects.equals(owner, product.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseClass, id, title, price, owner);
    }
}
