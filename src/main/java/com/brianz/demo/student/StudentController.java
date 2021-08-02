package com.brianz.demo.student;

import com.brianz.demo.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
//        throw new ApiRequestException("Oops cannot get all students with custom exception");
        return studentService.getAllStudents();
    }

    @GetMapping(path = "{studentId}")
    public List<StudentCourse> getAllCoursesForStudent(@PathVariable("studentId") UUID studentId) {
        // TODO
        System.out.println(studentId);
        return null;
    }

    @PostMapping
    public void addNewStudent(@RequestBody @Valid Student student) {
        studentService.addNewStudent(student);
    }
}
