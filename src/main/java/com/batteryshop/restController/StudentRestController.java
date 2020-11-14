package com.batteryshop.restController;

import com.batteryshop.entity.Student;
import com.batteryshop.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class StudentRestController {

    private final StudentService service;

    @GetMapping
    public String welcome(@RequestParam(name = "name", defaultValue = "Riyaz") String name) {
        return "Welcome " + name;
    }

    @GetMapping("students")
    @PreAuthorize("hasAnyAuthority('READ', 'WRITE')")
    public List<Student> getStudents() {
        return service.getStudents();
    }

    @GetMapping("student/{studentId}")
    @PreAuthorize("hasAuthority('WRITE')")
    public Student getStudent(@PathVariable Integer studentId) {
        return service.getStudent(studentId);
    }

    @PostMapping("students")
    @PreAuthorize("hasAuthority('WRITE')")
    public List<Student> saveStudents(@RequestBody Student[] students) {
        return service.saveStudents(Arrays.stream(students).collect(Collectors.toList()));
    }

    @PostMapping("student")
    @PreAuthorize("hasAuthority('WRITE')")
    public Student saveStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @PutMapping("student/{studentId}")
    @PreAuthorize("hasAuthority('UPDATE')")
    public Student updateStudent(@PathVariable Integer studentId, @RequestBody Student student) {
        return service.updateStudent(studentId, student);
    }

    @DeleteMapping("student/{studentId}")
    @PreAuthorize("hasAuthority('DELETE')")
    public List<Student> deleteStudent(@PathVariable Integer studentId) {
        return service.deleteStudent(studentId);
    }
}
