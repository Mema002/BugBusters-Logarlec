package src.testing;

import src.character.Character;
import src.effect.Effect;
import src.item.Item;
import src.room.Room;

import java.util.List;

public class State {
    final List<Room> rooms;
    final List<Character> characters;
    final List<Item> items;
    final List<Effect> effects;

    public State(List<Room> rooms, List<Character> characters, List<Item> items, List<Effect> effects) {
        this.rooms = rooms;
        this.characters = characters;
        this.items = items;
        this.effects = effects;
    }

    @Override
    public String toString() {
        return "State: " + rooms + " " + characters + " " + items + " " + effects;
    }
}
