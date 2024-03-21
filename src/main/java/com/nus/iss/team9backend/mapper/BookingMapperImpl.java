package com.nus.iss.team9backend.mapper;

import com.nus.iss.team9backend.dto.BookingDTO;
import com.nus.iss.team9backend.entity.Admin;
import com.nus.iss.team9backend.entity.Booking;
import com.nus.iss.team9backend.entity.Customer;
import com.nus.iss.team9backend.entity.Room;
import com.nus.iss.team9backend.repository.AdminRepository;
import com.nus.iss.team9backend.repository.BookingRepository;
import com.nus.iss.team9backend.repository.CustomerRepository;
import com.nus.iss.team9backend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookingMapperImpl implements BookingMapper {

    @Autowired
    private BookingRepository BookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Booking toEntity(BookingDTO bookingDTO){
        if(bookingDTO==null){
            return null;
        }
        Booking booking = new Booking();
        booking.setBookId(bookingDTO.getBookId());
        booking.setCheckInDate(bookingDTO.getCheckInDate());
        booking.setCheckOutDate(bookingDTO.getCheckOutDate());
        booking.setTotalPrice(bookingDTO.getTotalPrice());

        if(bookingDTO.getCustomerId()!=null){
            Customer customer = customerRepository.findById(bookingDTO.getCustomerId()).orElse(null);
            booking.setCustomer(customer);

        }
        if(bookingDTO.getAdminId()!=null){
            Admin admin = adminRepository.findById(bookingDTO.getAdminId()).orElse(null);
            booking.setAdmin(admin);
        }
        if(bookingDTO.getRoomId()!=null){
            Room room = roomRepository.findById(bookingDTO.getRoomId()).orElse(null);
            booking.setRoom(room);
        }

        return booking;
    }
    @Override
    public BookingDTO toDto(Booking entity){
        if(entity==null){
            return null;
        }
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setBookId(entity.getBookId());
        bookingDTO.setCheckInDate(entity.getCheckInDate());
        bookingDTO.setCheckOutDate(entity.getCheckOutDate());
        bookingDTO.setTotalPrice(entity.getTotalPrice());

        if(entity.getCustomer()!=null){
            bookingDTO.setCustomerId(entity.getCustomer().getCustomerId());

        }
        if(entity.getAdmin()!=null){
            bookingDTO.setAdminId(entity.getAdmin().getAdminId());
        }
        if(entity.getRoom()!=null){
            bookingDTO.setRoomId(entity.getRoom().getRoomId());
        }


        return bookingDTO;
    }

    @Override
    public List<Booking> toEntity(List<BookingDTO> bookingDTOList) {
        if(bookingDTOList==null){
            return null;
        }
        List<Booking> list = new ArrayList<Booking>(bookingDTOList.size());
        for(BookingDTO bookingDTO: bookingDTOList){
            list.add(toEntity(bookingDTO));
        }
        return list;
    }

    @Override
    public List<BookingDTO> toDto(List<Booking> bookingList) {
        if(bookingList==null){
            return null;
        }
        List<BookingDTO> list = new ArrayList<BookingDTO>(bookingList.size());
        for(Booking booking:bookingList){
            list.add(toDto(booking));
        }
        return list;
    }

    @Override
    public void partialUpdate(Booking entity, BookingDTO dto) {
        if(dto==null){
            return;
        }
        if(dto.getCheckInDate()!=null){
            dto.setCheckInDate(dto.getCheckInDate());
        }
        if(dto.getCheckOutDate()!=null){
            dto.setCheckOutDate(dto.getCheckOutDate());
        }
        if(dto.getTotalPrice()!=null){
            dto.setTotalPrice(dto.getTotalPrice());
        }
        if(dto.getCustomerId()!=null){
            dto.setCustomerId(dto.getCustomerId());
        }
        if(dto.getAdminId()!=null){
            dto.setAdminId(dto.getAdminId());
        }
        if(dto.getRoomId()!=null){
            dto.setRoomId(dto.getRoomId());
        }
    }
}
