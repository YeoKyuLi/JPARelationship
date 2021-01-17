package com.example.demo.manyToMany.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COURSE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private Set<Student> students  = new HashSet<>();;

    public Course(String title)
    {
        this.title = title;
    }
}
