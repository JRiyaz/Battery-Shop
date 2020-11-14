package com.batteryshop.controller;

import com.batteryshop.entity.Student;
import com.batteryshop.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository repository;

    @GetMapping("/all")
    public String allStudents(Model model) {

        model.addAttribute("students", repository.findAll());
        return "all-students";
    }

    @GetMapping("/add")
    public String addStudent(Model model) {

        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {

        Student savedStudent = repository.save(student);
        return "redirect:/student/all";
    }

    @GetMapping("update")
    public String updateStudent(@RequestParam Integer studentId, Model model) {

        model.addAttribute("student", repository.findById(studentId).get());
        return "update-student";
    }

    @PostMapping("update/{studentId}")
    public String updateStudent(@PathVariable Integer studentId, @ModelAttribute Student student) {

        Student daoStudent = repository.findById(studentId).get();
        daoStudent.setName(student.getName());
        daoStudent.setGender(student.getGender());
        daoStudent.setEmail(student.getEmail());
        daoStudent.setMobile(student.getMobile());
        daoStudent.setGender(student.getGender());
        daoStudent.setGrade(student.getGrade());
        repository.save(daoStudent);
        return "redirect:/student/all?alert=updated-" + studentId;

    }

    @GetMapping("delete")
    public String deleteStudent(@RequestParam Integer studentId) {
        repository.deleteById(studentId);
        return "redirect:/student/all?alert=deleted-" + studentId;
    }
}
