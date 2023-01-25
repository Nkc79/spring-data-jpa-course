package com.example.demo;

import com.example.demo.entity.Student;
import com.example.demo.entity.StudentIdCard;
import com.example.demo.repository.StudentIdCardRepository;
import com.example.demo.repository.StudentRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

/**
 * Created with IntelliJ IDEA.
 * com.example.demo
 *
 * @Author: Mahl
 * @Date: 2023/01/21/00:35
 * @Description: spring-data-jpa-course
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, StudentIdCardRepository studentIdCardRepository) {
        return args -> {
            Faker faker = new Faker();
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@gmail.com", firstName, lastName);
            Student student = new Student(
                    firstName,
                    lastName,
                    email,
                    faker.number().numberBetween(17, 40));
            StudentIdCard studentIdCard = new StudentIdCard(
                    "123456789",
                    student);
            studentIdCardRepository.save(studentIdCard);

        };
    }

    private void sorting(StudentRepository studentRepository) {
        //            Sort sort = Sort.by(Sort.Direction.ASC, "firstName");

        Sort sort = Sort.by("firstName").ascending()
                .and(Sort.by("age").descending());

        studentRepository.findAll(sort).forEach(student -> System.out.println(student.getFirstName() + " " + student.getAge()));
    }

    private void generateRandomStudents(StudentRepository studentRepository) {
        Faker faker = new Faker();
        Integer fakeNum = 20;
        for (int i = 0; i < fakeNum; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@gmail.com", firstName, lastName);
            Student student = new Student(
                    firstName,
                    lastName,
                    email,
                    faker.number().numberBetween(17, 40));
            studentRepository.save(student);
        }
    }

}
