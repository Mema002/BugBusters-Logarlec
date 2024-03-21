package src.game;

import src.character.Character;

public class ConsoleApp {
    public boolean writeOutInventory(Character character) {
        character.getInventory().forEach((n) -> System.out.println(n.getCurrentRoom())
        );
        return true;
    }
}
