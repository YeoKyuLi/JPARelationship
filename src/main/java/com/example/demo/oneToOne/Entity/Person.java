package com.example.demo.oneToOne.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Gender gender;

    public Person(String name)
    {
        this.name = name;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }
}
