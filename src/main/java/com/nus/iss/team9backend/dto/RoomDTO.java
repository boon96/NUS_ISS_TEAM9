package com.nus.iss.team9backend.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO extends RoomTypeDTO{
    private Long roomId;
    private String location;
    private String status;
    private Long roomTypeId;
}
