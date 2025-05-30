package main.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {
    private int id;
    private String name;
    private int age;
    private double rating;
}
