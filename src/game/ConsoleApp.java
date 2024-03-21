package src.game;

import src.character.Character;

import static src.game.SingletonLogger.logger;

public class ConsoleApp {
    public boolean writeOutInventory(Character character) {
        logger.info("Current player's id: " + character.getId());
        return true;
    }
}
