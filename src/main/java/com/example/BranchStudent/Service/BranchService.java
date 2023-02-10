package com.example.BranchStudent.Service;

import com.example.BranchStudent.Model.Branch;
import com.example.BranchStudent.Model.Student;
import com.example.BranchStudent.Repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class BranchService {
    @Autowired
    BranchRepository branchRepository;



    //GET API - Find list of contact number of HOD(s) who has maximum no. of passing students in their branch.

    public List<String> getListOfContact(){

        HashMap<Integer, List<String>> passToHod = new HashMap<>();  // for storing the maximum number of passed student with HOD Name
        int maxPass = 0;    // for storing the maximum passing students numbers
        List<Branch> branches = branchRepository.findAll();
        for(Branch branch : branches){
            int pass = 0;             // to count the number of students passed in each branch
            List<Student> studentList = branch.getStudentList();
            for(Student student : studentList){
                if(student.getMarks() >= 40){
                    pass++;
                }
            }
            if(!passToHod.containsKey(pass)){            // updating the map
                passToHod.put(pass, new ArrayList<>());
            }

            passToHod.get(pass).add(branch.getContactN());

            maxPass = Math.max(maxPass, pass);    // updating the maximum number
        }

        List<String> HODContacts = passToHod.get(maxPass);   // get the contact lists with maximum number key
        return HODContacts;
    }


//GET API = find the grant given to the department containing the maximum absolute number of students who have passed.
    public Integer getGrant(){
        List<Branch> branches = branchRepository.findAll();   // get all the branches
        int maxPass = 0;                                      // to get the overall maximum
        Branch maxPassBranch = null;                          // to get the branch with maximum passing students
        for(Branch branch : branches){
            int pass = 0;
            List<Student> studentList = branch.getStudentList();       // list pf students of each branch
            for(Student student : studentList){
                if(student.getMarks() >= 40){                      // checking student is passed or not
                    pass++;
                }
            }
            if(pass > maxPass){
                maxPass = pass;
                maxPassBranch = branch;           // updating the maxPass and Branch
            }
        }

        return maxPassBranch.getGrantMoney();
    }
}
