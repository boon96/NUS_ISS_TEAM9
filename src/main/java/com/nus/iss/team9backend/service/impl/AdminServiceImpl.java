package com.nus.iss.team9backend.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nus.iss.team9backend.dto.AdminDTO;
import com.nus.iss.team9backend.entity.Admin;
import com.nus.iss.team9backend.exception.ResourceNotFoundException;
import com.nus.iss.team9backend.mapper.AdminMapper;
import com.nus.iss.team9backend.repository.AdminRepository;
import com.nus.iss.team9backend.service.AdminService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public AdminDTO get(Long adminId) {
        Admin admin =adminRepository.findById(adminId)
                .orElseThrow(()-> new ResourceNotFoundException("Admin does not exist with the given id: "+ adminId));
        return adminMapper.toDto(admin);
    }

    @Override
    public List<AdminDTO> getAll() {
        List<Admin> admins = adminRepository.findAll();
        return admins.stream().map(adminMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AdminDTO update(Long adminId, AdminDTO dto) {
        Admin admin = adminRepository.findById(adminId).orElseThrow(()-> new ResourceNotFoundException("Admin does not exist with the given id: "+ adminId));
        admin.setPassword(dto.getPassword());
        admin.setEmailAddress(dto.getEmailAddress());
        admin.setName(dto.getName());
        admin.setPhoneNumber(dto.getPhoneNumber());

        Admin updated = adminRepository.save(admin);
        return adminMapper.toDto(updated);
    }

    @Override
    public void delete(Long adminId) {
        Admin admin = adminRepository.findById(adminId).orElseThrow(()-> new ResourceNotFoundException("Admin does not exist with the given id: "+ adminId));
        adminRepository.deleteById(adminId);

    }

    @Override
    public AdminDTO verifyAdmin(String emailAddress, String password) {
        Admin admin = adminRepository.findByEmailAddressAndPassword(emailAddress, password)
                .orElseThrow(() -> new ResourceNotFoundException("Admin does not exist"));
        return adminMapper.toDto(admin);
    }

}
