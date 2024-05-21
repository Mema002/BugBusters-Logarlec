package src.gui;

import src.dto.ChangeType;
import src.character.Character;

public interface GameLogicObserver {
    public void update();

    public void update(Character character);
}
