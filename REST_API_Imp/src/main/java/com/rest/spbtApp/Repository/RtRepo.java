package com.rest.spbtApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.spbtApp.entity.Student;

public interface RtRepo extends JpaRepository<Student, Integer> {

}
