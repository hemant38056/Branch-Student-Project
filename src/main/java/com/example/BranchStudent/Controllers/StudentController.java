package com.example.BranchStudent.Controllers;

import com.example.BranchStudent.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/getStudentRollNos")
    public ResponseEntity<List<Integer>> getRollNo(){
        List<Integer> listOfRollNo = studentService.getRollNo();
        return new ResponseEntity<>(listOfRollNo, HttpStatus.OK);
    }
}
