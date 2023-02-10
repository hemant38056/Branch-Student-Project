package com.example.BranchStudent.Service;

import com.example.BranchStudent.Model.Branch;
import com.example.BranchStudent.Model.Student;
import com.example.BranchStudent.Repository.BranchRepository;
import com.example.BranchStudent.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    BranchRepository branchRepository;


    //GET API - find the list of roll no of students which belongs to the most recent branch of college in terms of year only .
    public List<Integer> getRollNo(){
        Branch recentBranch = null;                         // to get the recent branch
        List<Branch> branches = branchRepository.findAll(); // finding the all branches in table

        for(Branch branch : branches){
            if(recentBranch == null || branch.getBranchId() < recentBranch.getBranchId()){
                recentBranch = branch;   // update the recent branch
            }
        }


        List<Student> studentList= recentBranch.getStudentList();   // get the student list of recent branch

        List<Integer> studentRollNoList = new ArrayList<>();     // to store the roll numbers of student

        for(Student student : studentList){
            studentRollNoList.add(student.getRollNo());    // adding the roll numbers
        }

        return studentRollNoList;
    }
}
