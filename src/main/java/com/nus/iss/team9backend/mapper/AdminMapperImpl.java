package com.nus.iss.team9backend.mapper;

import com.nus.iss.team9backend.dto.AdminDTO;
import com.nus.iss.team9backend.entity.Admin;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminMapperImpl implements AdminMapper{
    @Override
    public Admin toEntity(AdminDTO adminDTO){
        if(adminDTO==null){
            return null;
        }
        Admin admin = new Admin();
        admin.setAdminId(admin.getAdminId());
        admin.setAdminId(admin.getAdminId());
        admin.setName(adminDTO.getName());
        admin.setEmailAddress(adminDTO.getEmailAddress());
        admin.setPhoneNumber(adminDTO.getPhoneNumber());
        admin.setPassword(adminDTO.getPassword());

        return admin;
    }

    @Override
    public AdminDTO toDto(Admin entity){
        if(entity==null){
            return null;
        }
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setAdminId(entity.getAdminId());
        adminDTO.setName(entity.getName());
        adminDTO.setEmailAddress(entity.getEmailAddress());
        adminDTO.setPhoneNumber(entity.getPhoneNumber());
        adminDTO.setPassword(entity.getPassword());

        return adminDTO;
    }

    @Override
    public List<Admin> toEntity(List<AdminDTO> adminDTOList){
        if(adminDTOList ==null){
            return null;
        }
        List<Admin> list = new ArrayList<Admin>(adminDTOList.size());
        for(AdminDTO adminDTO: adminDTOList){
            list.add(toEntity(adminDTO));
        }
        return list;
    }

    @Override
    public List<AdminDTO> toDto(List<Admin> adminList){
        if(adminList ==null){
            return null;
        }
        List<AdminDTO> list = new ArrayList<AdminDTO>(adminList.size());
        for(Admin admin: adminList){
            list.add(toDto(admin));
        }
        return list;
    }
    @Override
    public void partialUpdate(Admin entity, AdminDTO dto){
        if(dto==null){
            return;
        }
        if(dto.getName()!=null){
            entity.setName(dto.getName());
        }

        if(dto.getEmailAddress()!=null){
            entity.setEmailAddress(dto.getEmailAddress());
        }

        if(dto.getPhoneNumber()!=null){
            entity.setPhoneNumber(dto.getPhoneNumber());
        }
        if(dto.getPassword()!=null){
            entity.setPassword(dto.getPassword());
        }

    }
}
