package com.example.rest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_seq_gen")
    @SequenceGenerator(name = "school_seq_gen", sequenceName = "school_id_seq")
    @Column(unique = true, nullable = false)
    private Integer id;
    @Column(length = 50)
    private String name;
    // Specifies a many-valued association with one-to-many multiplicity
    @OneToMany(mappedBy = "school")
    @JsonManagedReference
    private List<Student> students;
}
