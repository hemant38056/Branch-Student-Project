package com.example.BranchStudent.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "branch")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int branchId;

    private String contactN;

    private BranchName branchName;

    private String HODName;

    private int grantMoney;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<Student> studentList = new ArrayList<>();
}
