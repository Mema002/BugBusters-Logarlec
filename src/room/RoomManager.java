package src.room;

import java.util.ArrayList;
import java.util.Collections;

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
        ConsoleApp.returnLog("return");
    }

    public ArrayList<Room> getRooms() {
        ConsoleApp.returnLog("return ArrayList<> rooms");
        return rooms;
    }

    public void mergeRooms(Room r1, Room r2) { //osztódhat ha van benne karakter?
        ConsoleApp.funcLog("RoomManager to Room setCapacity");
        ConsoleApp.funcLog("RoomManager to Room getCapacity");
        ConsoleApp.funcLog("RoomManager to Room getCapacity");
        r1.setCapacity(Math.max(r1.getCapacity(), r2.getCapacity())); //nagyobbik capacity az uj
        ConsoleApp.funcLog("RoomManager to Room getNeighbours");
        for (Room room : r2.getNeighbours()) {
            ConsoleApp.funcLog("RoomManager to Room getNeighbours");
            if (!r1.getNeighbours().contains(room)) { //ha nem szomszedos akkor az lesz
                ConsoleApp.funcLog("RoomManager to Room addNeighbour");
                r1.addNeighbour(room);
            }
        }
        ConsoleApp.funcLog("RoomManager to Room getEffects");
        for (Effect e : r2.getEffects()) {
            ConsoleApp.funcLog("RoomManager to Room getEffects");
            if (!r1.getEffects().contains(e)) { //ha nincs ilyenje akkor kap
                ConsoleApp.funcLog("RoomManager to Room addEffect");
                r1.addEffect(e);
            }
        }
        ConsoleApp.funcLog("RoomManager to Room getItems");
        ConsoleApp.funcLog("RoomManager to Room getItems");
        r1.getItems().addAll(r2.getItems()); //itemek is atkerulnek
        ConsoleApp.funcLog("RoomManager to RoomManager deleteRoom");
        deleteRoom(r2);
        ConsoleApp.returnLog("return");
    }

    public void splitRoom(Room r) {
        //capacity split
        ConsoleApp.funcLog("RoomManager to Room getCapacity");
        ConsoleApp.funcLog("RoomManager to Room getId");
        Room newRoom = new Room(r.getCapacity() / 2, r.getId());
        ConsoleApp.funcLog("RoomManager to Room getCapacity");
        ConsoleApp.funcLog("RoomManager to Room setCapacity");
        r.setCapacity(r.getCapacity() / 2);

        //item split
        ConsoleApp.funcLog("RoomManager to Room getItems");
        Collections.shuffle(r.getItems()); //hogy random keruljenek at, ne az eredeti sorrendben
        ConsoleApp.funcLog("RoomManager to Room getItems");
        ConsoleApp.funcLog("RoomManager to Room getItems");
        ArrayList<Item> firstHalfItems = new ArrayList<>(r.getItems().subList(0, r.getItems().size() / 2)); //elfelezes
        ConsoleApp.funcLog("RoomManager to Room getItems");
        ConsoleApp.funcLog("RoomManager to Room getItems");
        ConsoleApp.funcLog("RoomManager to Room getItems");
        ArrayList<Item> secondHalfItems = new ArrayList<>(r.getItems().subList(r.getItems().size() / 2, r.getItems().size()));
        ConsoleApp.funcLog("RoomManager to Room getItems");
        ConsoleApp.funcLog("RoomManager to Room getItems");
        r.getItems().clear(); r.getItems().addAll(firstHalfItems);
        ConsoleApp.funcLog("RoomManager to Room getItems");
        newRoom.getItems().addAll(secondHalfItems);

        //effect split
        if (r.getEffects().size() == 2) {
            ConsoleApp.funcLog("RoomManager to Room getEffects");
            Collections.shuffle(r.getEffects());
            ConsoleApp.funcLog("RoomManager to Room getEffects");
            ConsoleApp.funcLog("RoomManager to Room addEffect");
            newRoom.addEffect(r.getEffects().remove(0));
        }
        //else if (r.getEffects().size() == 1) leszarom megtartja ha csak 1 effektje van

        //neighbour split
        ConsoleApp.funcLog("RoomManager to Room getNeighbours");
        Collections.shuffle(r.getNeighbours());
        ConsoleApp.funcLog("RoomManager to Room getNeighbours");
        ConsoleApp.funcLog("RoomManager to Room getNeighbours");
        ArrayList<Room> firstHalfN = new ArrayList<>(r.getNeighbours().subList(0, r.getNeighbours().size() / 2));
        ConsoleApp.funcLog("RoomManager to Room getNeighbours");
        ConsoleApp.funcLog("RoomManager to Room getNeighbours");
        ConsoleApp.funcLog("RoomManager to Room getNeighbours");
        ArrayList<Room> secondHalfN = new ArrayList<>(r.getNeighbours().subList(r.getNeighbours().size() / 2, r.getNeighbours().size()));
        ConsoleApp.funcLog("RoomManager to Room getNeighbours");
        ConsoleApp.funcLog("RoomManager to Room getNeighbours");
        ConsoleApp.funcLog("RoomManager to Room getNeighbours");
        r.getNeighbours().clear(); r.getNeighbours().addAll(firstHalfN); r.getNeighbours().add(newRoom);
        ConsoleApp.funcLog("RoomManager to Room getNeighbours");
        ConsoleApp.funcLog("RoomManager to Room getNeighbours");
        newRoom.getNeighbours().addAll(secondHalfN); newRoom.getNeighbours().add(r);
        rooms.add(newRoom);
        ConsoleApp.returnLog("return");
    }

    public void deleteRoom(Room r) {
        rooms.remove(r);
        for (Room room : rooms) {
            ConsoleApp.funcLog("RoomManager to Room getNeighbours");
            if (room.getNeighbours().contains(r)) {
                ConsoleApp.funcLog("RoomManager to Room getNeighbours");
                room.getNeighbours().remove(r);
            }
        }
        ConsoleApp.returnLog("return");
    }

    public static ArrayList<Room> getInNeighbours(Room r) {
        ArrayList<Room> inNeighbours = new ArrayList<Room>();
        for (Room room : rooms) {
            ConsoleApp.funcLog("RoomManager to Room getNeighbours");
            if (room.getNeighbours().contains(r)) {
                inNeighbours.add(room);
            }
        }
        ConsoleApp.returnLog("return inNeighbours");
        return inNeighbours;
    }

    public void sortEffects(ArrayList<Effect> e) {

    }

    public void sortNeighbours(ArrayList<Room> r) {

    }

    public void sortCapacity(int i) {

    }

    public void clearRooms() {
        rooms.clear();
    }

    public void clearRoomItems() {
        for (Room room : rooms)
            room.clearItems();
    }

    public void triggerAllEffects() {
        for (Room room : rooms) {
            ConsoleApp.funcLog("RoomManager to Room triggerRoomEffects");
            room.triggerRoomEffects();
        }
        ConsoleApp.returnLog("return");
    }
}
