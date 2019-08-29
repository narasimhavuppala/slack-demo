package com.verizon.customer.slackdemo.controller;

import com.verizon.customer.slackdemo.model.Student;
import com.verizon.customer.slackdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    // web and Backends....Mobile apps...Use JSON Format
    public Student getStudent(@PathVariable("id") int id) {
        System.out.println(id);

        return service.getStudent(id);
    }

    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)

    public Student save(@Valid Student obj) throws Exception {
        System.out.println(obj.getId());
        return service.save(obj);

    }

    @PutMapping("/{id}")
    public Student updateStudent(@Valid Student obj,@PathVariable("id") int studentId) throws Exception {
        return service.update(studentId,obj);
    }

    @DeleteMapping("/{id}")
    public boolean deleteStudent(@PathVariable("id") int id) throws Exception {
        return service.delete(id);
    }

    @GetMapping("/{name}/{age}")
    public List<Student> findByNameOrAge(@PathVariable("name") String studentName,@PathVariable("age") int studentAge) throws Exception {
        return service.findByNameOrAge(studentName, studentAge);
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<String> getExceptions(Throwable t) {
        System.out.println(t.getMessage());
        System.out.println("Error Occureded");
        t.printStackTrace();
        return new ResponseEntity<String>("Error occured: "+ t.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
