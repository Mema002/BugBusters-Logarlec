package src.room;

import java.util.ArrayList;
import java.util.Collections;

import src.character.Character;
import src.effect.Effect;
import src.game.ConsoleApp;
import src.item.Item;

public class RoomManager {
    private static ArrayList<Room> rooms;

    public RoomManager() {
        rooms = new ArrayList<>();
    }

    public void generateRooms(int count) {
        for (int i = 0; i < count; i++) {
            rooms.add(new Room(10, i));
        }
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void mergeRooms(Room r1, Room r2) { //osztódhat ha van benne karakter?
        ConsoleApp.consoleLog(this, r1, "RoomManager to Room setCapacity");
        r1.setCapacity(Math.max(r1.getCapacity(), r2.getCapacity())); //nagyobbik capacity az uj
        ConsoleApp.consoleLog(this, r1, "RoomManager to Room getNeighbours");
        for (Room room : r2.getNeighbours()) {
            if (!r1.getNeighbours().contains(room)) { //ha nem szomszedos akkor az lesz
                ConsoleApp.consoleLog(this, r1, "RoomManager to Room addNeighbour");
                r1.addNeighbour(room);
            }
        }
        ConsoleApp.consoleLog(this, r1, "RoomManager to Room getEffects");
        for (Effect e : r2.getEffects()) {
            if (!r1.getEffects().contains(e)) { //ha nincs ilyenje akkor kap
                ConsoleApp.consoleLog(this, r1, "RoomManager to Room addEffect");
                r1.addEffect(e);
            }
        }
        r1.getItems().addAll(r2.getItems()); //itemek is atkerulnek
        ConsoleApp.consoleLog(this, this, "RoomManager to RoomManager deleteRoom");
        deleteRoom(r2);
    }

    public void splitRoom(Room r) {
        //capacity split
        Room newRoom = new Room(r.getCapacity() / 2, r.getId());
        ConsoleApp.consoleLog(this, r, "RoomManager to Room setCapacity");
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
            ConsoleApp.consoleLog(this, r, "RoomManager to Room addEffect");
            newRoom.addEffect(r.getEffects().remove(0));
        }
        //else if (r.getEffects().size() == 1) leszarom megtartja ha csak 1 effektje van

        //neighbour split
        Collections.shuffle(r.getNeighbours());
        ArrayList<Room> firstHalfN = new ArrayList<>(r.getNeighbours().subList(0, r.getNeighbours().size() / 2));
        ArrayList<Room> secondHalfN = new ArrayList<>(r.getNeighbours().subList(r.getNeighbours().size() / 2, r.getNeighbours().size()));
        r.getNeighbours().clear(); r.getNeighbours().addAll(firstHalfN); r.getNeighbours().add(newRoom);
        newRoom.getNeighbours().addAll(secondHalfN); newRoom.getNeighbours().add(r);
        rooms.add(newRoom);
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

    public void sortEffects(ArrayList<Effect> e) {

    }

    public void sortNeighbours(ArrayList<Room> r) {

    }

    public void sortCapacity(int i) {

    }

    public void clearRooms() { rooms.clear(); }

    public void clearRoomItems() {
        for (Room room : rooms)
            room.clearItems();
    }

    public void triggerAllEffects() {
        for (Room room : rooms) {
            ConsoleApp.consoleLog(this, room, "RoomManager to Room triggerRoomEffects");
            room.triggerRoomEffects();
        }
    }
}
