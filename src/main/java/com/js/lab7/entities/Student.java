package com.js.lab7.entities;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView
    private String name;

    @JsonView
    private String surname;

    @JsonView
    private Double average;

}
