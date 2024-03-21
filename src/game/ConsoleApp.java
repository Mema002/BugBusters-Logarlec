package src.game;

import src.character.Character;

public class ConsoleApp {
    public boolean writeOutInventory(Character character) {
        character.getInventory().forEach((n) -> System.out.printf("Player's current room: %s, ",n.getCurrentRoom().getId()));
        return true;
    }
}
