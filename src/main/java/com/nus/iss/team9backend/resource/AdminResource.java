package com.nus.iss.team9backend.resource;

import com.nus.iss.team9backend.dto.AdminDTO;
import com.nus.iss.team9backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminResource {
    @Autowired //need this autowired if not service wont be connect to spring boot
    private AdminService adminService;

    @PostMapping
    public ResponseEntity<AdminDTO> createAdmin(@RequestBody AdminDTO adminDTO){
        AdminDTO savedAdmin = adminService.save(adminDTO);
        return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);

    }
}
