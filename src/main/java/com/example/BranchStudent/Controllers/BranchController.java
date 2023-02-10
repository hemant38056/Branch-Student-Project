package com.example.BranchStudent.Controllers;

import com.example.BranchStudent.Service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {
    @Autowired
    BranchService branchService;

    @GetMapping("/listOfContact")
    public ResponseEntity<List<String>> getListOfContact(){
        List<String> contactList = branchService.getListOfContact();
        return new ResponseEntity<>(contactList, HttpStatus.OK);
    }


    @GetMapping("/getGrant")
    public ResponseEntity<Integer> getGrant(){
        Integer grantMoney = branchService.getGrant();
        return new ResponseEntity<>(grantMoney, HttpStatus.OK);
    }
}
