package com.nus.iss.team9backend.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nus.iss.team9backend.dto.AdminDTO;
import com.nus.iss.team9backend.entity.Admin;
import com.nus.iss.team9backend.mapper.AdminMapper;
import com.nus.iss.team9backend.repository.AdminRepository;
import com.nus.iss.team9backend.service.AdminService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    private final EntityManager entityManager;
    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;
    @Autowired
    private ObjectMapper objectMapper;

    public AdminServiceImpl(EntityManager entityManager, AdminRepository adminRepository, AdminMapper adminMapper) {
        this.entityManager=entityManager;
        this.adminRepository=adminRepository;
        this.adminMapper=adminMapper;

    }

    @Override
    public AdminDTO save(AdminDTO adminDTO) {

        Admin admin =adminMapper.toEntity(adminDTO);
        admin = adminRepository.save(admin);
        return adminMapper.toDto(admin);
    }
}
