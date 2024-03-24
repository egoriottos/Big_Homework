package com.example.big_homework.domain.entity;

import com.example.big_homework.domain.valueObj.BaseClass;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    public Integer id;

    @Embedded
    private BaseClass baseClass;

    @Column(name="имя")
    private String name;

    @OneToOne
    @JoinColumn(name ="trash_id", referencedColumnName = "user_id")
    private Trash trash;

    @OneToOne
    @JoinColumn(name ="history_id", referencedColumnName = "user_id")
    private History history;


}
