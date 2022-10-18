package com.mariam.springboot.studentsystem.service;

import com.mariam.springboot.studentsystem.entity.Admin;
import com.mariam.springboot.studentsystem.entity.Student;
import com.mariam.springboot.studentsystem.entity.Teacher;


import java.util.List;

public interface AdminService {
    public List<Admin> findAll();

    public Admin findById(int adminId);

    public void save(Admin theAdmin);

    public void deleteById(int adminId);

}
