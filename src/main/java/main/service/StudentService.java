package main.service;

import lombok.Data;
import lombok.Getter;
import main.model.Student;

import java.util.ArrayList;
import java.util.List;

@Getter
public class StudentService {
    private List<Student> students = new ArrayList<>();

    public void add(Student student) {
        students.add(student);
    }

    public void addAll(List<Student> students) {
        this.students.addAll(students);
    }

    public void clear() {
        students.clear();
    }
}
