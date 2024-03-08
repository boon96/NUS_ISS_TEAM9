package com.nus.iss.team9backend.entity;
import jakarta.persistence.*;
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

@Entity
@Table(name = "TBL_BOOKING" )
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(name="check_in_date")
    private ZonedDateTime checkInDate;

    @Column(name="check_out_date")
    private ZonedDateTime checkOutDate;

    @Column(name="total_price")
    private BigDecimal totalPrice;
    /*
    * Foreign keys
    * */
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
