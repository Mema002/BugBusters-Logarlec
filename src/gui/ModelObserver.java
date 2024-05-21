package src.gui;

import src.character.Character;
import src.dto.ChangeType;
import src.effect.Effect;
import src.item.Item;
import src.room.Room;

public interface ModelObserver {
    public void update(Room room, ChangeType type);
    public void update(Character character, ChangeType type);
    public void update(Item item, ChangeType type);
    public void update(Effect effect, ChangeType type);
}
