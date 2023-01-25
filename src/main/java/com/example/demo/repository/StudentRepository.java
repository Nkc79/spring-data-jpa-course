package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByEmail(String email);

    List<Student> findStudentByfirstNameEqualsAndAgeEquals(String firstName, Integer age);

    @Query("select s from Student s where s.firstName = ?1 and s.age >= ?2")
    List<Student> selectByfirstNameAndAgeGreaterThanEqual(String firstName, Integer age);

    @Query(value = "select * from student  where first_name = ?1 and age >= ?2", nativeQuery = true)
    List<Student> selectByfirstNameAndAgeGreaterThanEqualNative(String firstName, Integer age);


    @Transactional
    @Modifying
    @Query("DELETE FROM Student u WHERE u.id = ?1")
    int deleteStudentById(Long id);
}
