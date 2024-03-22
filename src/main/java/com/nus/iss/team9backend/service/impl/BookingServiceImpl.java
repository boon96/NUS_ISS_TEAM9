package com.nus.iss.team9backend.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nus.iss.team9backend.dto.BookingDTO;
import com.nus.iss.team9backend.entity.Booking;
import com.nus.iss.team9backend.exception.ResourceNotFoundException;
import com.nus.iss.team9backend.mapper.BookingMapper;
import com.nus.iss.team9backend.repository.BookingRepository;
import com.nus.iss.team9backend.service.BookingService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public BookingDTO get(Long bookingId) {
        Booking booking =bookingRepository.findById(bookingId)
                .orElseThrow(()-> new ResourceNotFoundException("Booking does not exist with the given id: "+ bookingId));
        return bookingMapper.toDto(booking);
    }

    @Override
    public List<BookingDTO> getAll() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream().map(bookingMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookingDTO update(Long bookingId, BookingDTO dto) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(()-> new ResourceNotFoundException("Booking does not exist with the given id: "+ bookingId));

        booking.setCheckInDate(dto.getCheckInDate());
        booking.setCheckOutDate(dto.getCheckOutDate());
        booking.setTotalPrice(dto.getTotalPrice());

        Booking updated = bookingRepository.save(booking);
        return bookingMapper.toDto(updated);
    }

    @Override
    public void delete(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(()-> new ResourceNotFoundException("Booking does not exist with the given id: "+ bookingId));
        bookingRepository.deleteById(bookingId);

    }

}
