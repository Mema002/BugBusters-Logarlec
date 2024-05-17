package src.dto;

import src.room.Room;

public class RoomChangeDto {
    public Room room;
    public ChangeType type;

    public RoomChangeDto(Room room, ChangeType type) {
        this.room = room;
        this.type = type;
    }
}
