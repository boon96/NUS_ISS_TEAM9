package com.nus.iss.team9backend.service;

import com.nus.iss.team9backend.dto.AdminDTO;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    AdminDTO save(AdminDTO adminDTO);

    AdminDTO get(Long adminId);

    List<AdminDTO> getAll();

    AdminDTO update (Long adminId, AdminDTO dto);

    void delete(Long adminId);

    AdminDTO verifyAdmin(String emailAddress, String password);
}
