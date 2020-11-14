package com.batteryshop.service;

import com.batteryshop.entity.Student;
import com.batteryshop.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public Student getStudent(Integer studentId) {
        return repository.findById(studentId).get();
    }

    public List<Student> saveStudents(List<Student> students) {
        return repository.saveAll(students);
    }

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public Student updateStudent(Integer studentId, Student student) {
        Student daoStudent = getStudent(studentId);
        daoStudent.setName(student.getName());
        daoStudent.setGender(student.getGender());
        return saveStudent(daoStudent);
    }

    public List<Student> deleteStudent(Integer studentId) {
        repository.delete(getStudent(studentId));
        return getStudents();
    }
}
