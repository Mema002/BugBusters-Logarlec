package src.dto;

import src.character.Character;

public class CharacterChangeDto {
    public Character character;
    public ChangeType type;

    public CharacterChangeDto(Character character, ChangeType type) {
        this.character = character;
        this.type = type;
    }
}
