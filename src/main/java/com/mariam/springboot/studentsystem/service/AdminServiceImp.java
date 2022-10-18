package com.mariam.springboot.studentsystem.service;

import com.mariam.springboot.studentsystem.dao.AdminRepository;
import com.mariam.springboot.studentsystem.entity.Admin;
import com.mariam.springboot.studentsystem.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminServiceImp implements AdminService{
    private AdminRepository adminRepository;



    @Autowired
    public AdminServiceImp(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin findById(int adminId) {
        Admin result = adminRepository.findById(adminId).orElseThrow(() -> new NotFoundException("admin id not found "+adminId));
        return result;
    }

    @Override
    public void save(Admin theAdmin) {
        adminRepository.save(theAdmin);
    }

    @Override
    public void deleteById(int adminId) {
        findById(adminId);
        adminRepository.deleteById(adminId);
    }

}
