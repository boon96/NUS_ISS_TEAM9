package com.nus.iss.team9backend.service;

import com.nus.iss.team9backend.dto.BookingDTO;

import java.util.List;

public interface BookingService {
    BookingDTO save (BookingDTO bookingDTO);

    BookingDTO get(Long bookingId);

    List<BookingDTO> getAll();

    BookingDTO update (Long bookingId, BookingDTO dto);

    void delete(Long bookingId);
}
