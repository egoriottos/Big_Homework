package com.example.big_homework.domain.entity;

import com.example.big_homework.domain.valueObj.BaseClass;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Bean;

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
@Table(name = "history")
public class History  {
    @Embedded
    private BaseClass baseClass;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    public Integer id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User owner;

//    @OneToOne
//    @JoinColumn(name ="trash", referencedColumnName = "history_id")
    @OneToOne(mappedBy = "history")
    private Trash trash;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        History history = (History) o;
        return Objects.equals(baseClass, history.baseClass) && Objects.equals(id, history.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseClass, id);
    }
}
