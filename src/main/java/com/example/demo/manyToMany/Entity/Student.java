package com.example.demo.manyToMany.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "STUDENT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "STUDENT_COURSE",
            joinColumns = {
                    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "COURSE_ID", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private Set<Course> courses  = new HashSet<>();;

//    public Student(String kyuli) {
//        this.name = kyuli;
//    }

//    public  Student(){}
    public  Student(String name)
    {
        this.name = name;
    }
}
