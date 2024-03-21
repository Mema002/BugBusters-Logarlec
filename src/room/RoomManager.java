package src.room;

import java.util.ArrayList;
import java.util.Collections;

import src.character.Character;
import src.effect.Effect;
import src.item.Item;

public class RoomManager {
    private static ArrayList<Room> rooms;

    public RoomManager() {
        this.rooms = new ArrayList<>();
    }

    public void mergeRooms(Room r1, Room r2) { //osztódhat ha van benne karakter?
        r1.setCapacity(Math.max(r1.getCapacity(), r2.getCapacity())); //nagyobbik capacity az uj
        for (Room room : r2.getNeighbours()) {
            if (!r1.getNeighbours().contains(room)) //ha nem szomszedos akkor az lesz
                r1.addNeighbour(room);
        }
        for (Effect e : r2.getEffects()) {
            if (!r1.getEffects().contains(e)) //ha nincs ilyenje akkor kap
                r1.addEffect(e);
        }
        r1.getItems().addAll(r2.getItems()); //itemek is atkerulnek
        deleteRoom(r2);
    }

    public void splitRoom(Room r) {
        //capacity split
        Room newRoom = new Room(r.getCapacity() / 2, r.getId());
        r.setCapacity(r.getCapacity() / 2);

        //item split
        Collections.shuffle(r.getItems()); //hogy random keruljenek at, ne az eredeti sorrendben
        ArrayList<Item> firstHalfItems = new ArrayList<>(r.getItems().subList(0, r.getItems().size() / 2)); //elfelezes
        ArrayList<Item> secondHalfItems = new ArrayList<>(r.getItems().subList(r.getItems().size() / 2, r.getItems().size()));
        r.getItems().clear(); r.getItems().addAll(firstHalfItems);
        newRoom.getItems().addAll(secondHalfItems);

        //effect split
        if (r.getEffects().size() == 2) {
            Collections.shuffle(r.getEffects());
            newRoom.addEffect(r.getEffects().remove(0));
        }
        //else if (r.getEffects().size() == 1) leszarom megtartja ha csak 1 effektje van

        //neighbour split
        Collections.shuffle(r.getNeighbours());
        ArrayList<Room> firstHalfN = new ArrayList<>(r.getNeighbours().subList(0, r.getNeighbours().size() / 2));
        ArrayList<Room> secondHalfN = new ArrayList<>(r.getNeighbours().subList(r.getNeighbours().size() / 2, r.getNeighbours().size()));
        r.getNeighbours().clear(); r.getNeighbours().addAll(firstHalfN); r.getNeighbours().add(newRoom);
        newRoom.getNeighbours().addAll(secondHalfN); newRoom.getNeighbours().add(r);
    }

    public void deleteRoom(Room r) {
        rooms.remove(r);
        for (Room room : rooms) {
            if (room.getNeighbours().contains(r))
                room.getNeighbours().remove(r);
        }
    }

    public static ArrayList<Room> getInNeighbours(Room r) {
        ArrayList<Room> inNeighbours = new ArrayList<Room>();
        for (Room room : rooms) {
            if (room.getNeighbours().contains(r)) {
                inNeighbours.add(room);
            }
        }
        return inNeighbours;
    }

    public void sortCharacters(ArrayList<Character> c) {

    }

    public void sortItems(ArrayList<Item> i) {

    }

    public void sortEffects(ArrayList<Effect> e) {

    }

    public void sortNeighbours(ArrayList<Room> r) {

    }

    public void sortCapacity(int i) {

    }
}
