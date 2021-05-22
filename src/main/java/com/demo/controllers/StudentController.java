package com.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Student;

@RestController
@RequestMapping("/api")
public class StudentController {
//xyz
    private static final List<Student> STUDENTS = new ArrayList<Student>();
//    HttpHeaders responseHeaders = new HttpHeaders();
    @PostConstruct
    public void init() {
        Student student = new Student();
        student.setId(0);
        student.setName("pcs0");
        student.setStandard(0);
        student.setAddress("NDD");
        STUDENTS.add(student);
        
        student = new Student();
        student.setId(1);
        student.setName("pcs1");
        student.setStandard(1);
        student.setAddress("NDD");
        STUDENTS.add(student);
        
        student = new Student();
        student.setId(2);
        student.setName("pcs2");
        student.setStandard(2);
        student.setAddress("BRD");
        STUDENTS.add(student);
        
        student = new Student();
        student.setId(3);
        student.setName("pcs3");
        student.setStandard(3);
        student.setAddress("AHM");
        STUDENTS.add(student);
        
        student = new Student();
        student.setId(4);
        student.setName("pcs4");
        student.setStandard(4);
        student.setAddress("VVN");
        STUDENTS.add(student);
//        responseHeaders.set("Access-Control-Allow-Origin","*");
//        responseHeaders.set("Access-Control-Allow-Methods","GET,POST,OPTIONS,DELETE,PUT");
    }
    
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, path = "create")
    public ResponseEntity<Boolean> create(@RequestBody Student student)
    {
        STUDENTS.add(student);
        Boolean reponse = true;
        return ResponseEntity.ok()
//                .headers(responseHeaders)
                .body(reponse);
    }
    
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "list")
    public ResponseEntity<List<Student>> list()
    {
        return ResponseEntity.ok()
//                .headers(responseHeaders)
                .body(STUDENTS);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "get/{id}")
    public ResponseEntity<Student> get(@PathVariable("id") int id)
    {
        return ResponseEntity.ok()
//                .headers(responseHeaders)
                .body(STUDENTS.get(id));
    }
    
    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, path = "delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id)
    {
        Boolean reponse = false;
        List<Student> students = STUDENTS.stream().filter(student -> student.getId().equals(id)).collect(Collectors.toList());
        if (students.size() == 1)
        {
            STUDENTS.remove(students.get(0));
            reponse = true;
        }
//        responseHeaders.set("Access-Control-Allow-Origin","*");
        return ResponseEntity.ok()
//                .headers(responseHeaders)
                .body(reponse);
    }
    
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, path = "update/{id}")
    public ResponseEntity<Boolean> updateStudent(@RequestBody Student student,@PathVariable("id") int id)
    {
        Boolean reponse = false;
        if (STUDENTS.size() < id)
        {
            throw new RuntimeException("Student not found. . . ");
        }
        STUDENTS.remove(id);
        STUDENTS.add(student.getId(), student);
        reponse = true;
        return ResponseEntity.ok()
//                .headers(responseHeaders)
                .body(reponse);
    }
}
