package com.nus.iss.team9backend.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nus.iss.team9backend.dto.BookingDTO;
import com.nus.iss.team9backend.dto.RoomDTO;
import com.nus.iss.team9backend.entity.Booking;
import com.nus.iss.team9backend.entity.Room;
import com.nus.iss.team9backend.mapper.BookingMapper;
import com.nus.iss.team9backend.mapper.RoomMapper;
import com.nus.iss.team9backend.repository.BookingRepository;
import com.nus.iss.team9backend.repository.RoomRepository;
import com.nus.iss.team9backend.service.BookingService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
    private final EntityManager entityManager;
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    @Autowired
    private ObjectMapper objectMapper;

    public BookingServiceImpl(EntityManager entityManager, BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.entityManager=entityManager;
        this.bookingRepository=bookingRepository;
        this.bookingMapper=bookingMapper;

    }
    @Override
    public BookingDTO save(BookingDTO bookingDTO) {

        Booking booking =bookingMapper.toEntity(bookingDTO);
        booking = bookingRepository.save(booking);
        return bookingMapper.toDto(booking);
    }

}
