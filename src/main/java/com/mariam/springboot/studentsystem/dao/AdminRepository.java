package com.mariam.springboot.studentsystem.dao;

import com.mariam.springboot.studentsystem.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
