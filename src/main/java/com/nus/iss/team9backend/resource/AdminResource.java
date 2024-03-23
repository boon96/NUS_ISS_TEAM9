package com.nus.iss.team9backend.resource;

import com.nus.iss.team9backend.dto.AdminDTO;
import com.nus.iss.team9backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("{id}")
    public ResponseEntity<AdminDTO> getAdmin(@PathVariable("id") Long adminId){
        AdminDTO dto = adminService.get(adminId);
        return ResponseEntity.ok(dto);
    }
    @GetMapping
    public ResponseEntity <List<AdminDTO>> getAllAdmin(){
        List<AdminDTO> list = adminService.getAll();
        return ResponseEntity.ok(list);

    }
    @PutMapping("{id}")
    public ResponseEntity<AdminDTO> updateAdmin(@PathVariable("id") Long adminId,
                                                      @RequestBody AdminDTO adminDTO){
        AdminDTO dto = adminService.update(adminId,adminDTO);
        return ResponseEntity.ok(dto);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable("id") Long adminId){
        adminService.delete(adminId);
        return ResponseEntity.ok("Admin deleted successfully: ");
    }

    @PostMapping("/admin-verify")
    public ResponseEntity<AdminDTO> verifyAdmin(@RequestParam String emailAddress, @RequestParam String password){
        AdminDTO dto = adminService.verifyAdmin(emailAddress,password);
        if(dto!=null){
            return ResponseEntity.ok(dto);
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
