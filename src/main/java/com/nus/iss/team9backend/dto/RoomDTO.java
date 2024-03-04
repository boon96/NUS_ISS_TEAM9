package com.nus.iss.team9backend.dto;
import com.nus.iss.team9backend.entity.RoomType;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    private Long roomId;
    private String location;
    private String status;
    private Long roomTypeId;
}
