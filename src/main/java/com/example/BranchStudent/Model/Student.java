package com.example.BranchStudent.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rollNo;

    private String name;
    private BranchName branchName;

    private int marks;

    @ManyToOne
    @JoinColumn
    private Branch branch;

}
