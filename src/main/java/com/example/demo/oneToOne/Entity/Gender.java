package com.example.demo.oneToOne.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "GENDER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean gender; // 0 == man, 1 == woman

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    public Gender(boolean gender)
    {
        this.gender = gender;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }
}
