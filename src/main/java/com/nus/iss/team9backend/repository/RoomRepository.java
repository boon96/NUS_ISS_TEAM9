package com.nus.iss.team9backend.repository;

import com.nus.iss.team9backend.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomRepository  extends JpaRepository<Room, Long> {

    @Query(value="SELECT r FROM TBL_ROOM r " +
            "WHERE r.room_type_id = :roomTypeId " +
            "AND r.status = 'Available'",nativeQuery = true)
    List<Room> findAvailableRoomsOfType(@Param("roomTypeId") Long roomTypeId);
}
