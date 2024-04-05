package com.nus.iss.team9backend.repository;

import com.nus.iss.team9backend.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomRepository  extends JpaRepository<Room, Long> {

    @Modifying
    @Query(value="UPDATE TBL_Room r SET r.status = 'Unavailable' WHERE r.room_id = :roomId",nativeQuery = true)
    void updateRoomStatus(@Param("roomId") Long roomId);
}
