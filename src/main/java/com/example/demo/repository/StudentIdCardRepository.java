package com.example.demo.repository;

import com.example.demo.entity.StudentIdCard;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 * com.example.demo
 *
 * @Author: Mahl
 * @Date: 2023/01/21/00:35
 * @Description: spring-data-jpa-course
 */

public interface StudentIdCardRepository extends CrudRepository<StudentIdCard, Long> {

}
