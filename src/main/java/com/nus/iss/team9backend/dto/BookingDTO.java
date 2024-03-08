package com.nus.iss.team9backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    private Long bookId;
    private ZonedDateTime checkInDate;
    private ZonedDateTime checkOutDate;
    private BigDecimal totalPrice;
    /*
     * Foreign keys
     * */
    private Long customerId;
    private Long adminId;
    private Long roomId;
}
