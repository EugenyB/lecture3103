package main.service;

import com.github.javafaker.Faker;
import main.model.Student;

import java.util.Random;

public class StudentFactory {

    private Faker faker = new Faker();
    private Random random = new Random();

    public Student createRandomStudent() {
        return new Student(Math.abs(random.nextInt()), faker.name().fullName(), random.nextInt(17)+20, random.nextInt(41)+60);
    }
}
