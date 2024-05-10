package src.dto;

import src.character.Character;

public class RoomChangeDto {
    public Character character;
    public RoomChangeType type;

    public RoomChangeDto(Character character, RoomChangeType type) {
        this.character = character;
        this.type = type;
    }
}
