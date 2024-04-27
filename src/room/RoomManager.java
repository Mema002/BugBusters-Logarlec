package src.room;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import src.effect.Effect;
import src.game.ConsoleApp;
import src.item.Item;

public class RoomManager {
    private static List<Room> rooms;

    /**
     * RoomManager konstruktor
     */
    public RoomManager() {
        rooms = new ArrayList<>();
    }

    /**
     * Legeneral count darab szobat
     * @param count
     */
    public void generateRooms(int count) {
        for (int i = 0; i < count; i++) {
            rooms.add(new Room(10, i));
        }
        ConsoleApp.returnLog("return");
    }

    /**
     * Visszater a szobakkal
     * @return rooms
     */
    public List<Room> getRooms() {
        ConsoleApp.returnLog("return");
        return rooms;
    }

    /**
     * Osszevonja a paramul kapott ket szobat
     * A nagyobbik capacity lep ervenybe, effektek es itemek osszevonva
     * @param r1
     * @param r2
     */
    public void mergeRooms(Room r1, Room r2) { //osztódhat ha van benne karakter?
        ConsoleApp.funcLog("room.setCapacity(Math.max(room1.getCapacity(),room2.getCapacity()))");
        ConsoleApp.funcLog("room.getCapacity()");
        ConsoleApp.funcLog("room.getCapacity()");
        r1.setCapacity(Math.max(r1.getCapacity(), r2.getCapacity())); //nagyobbik capacity az uj
        ConsoleApp.funcLog("room2.getNeighbours()");
        for (Room room : r2.getNeighbours()) {
            ConsoleApp.funcLog("room1.getNeighbours.contains(room)");
            if (!r1.getNeighbours().contains(room)) { //ha nem szomszedos akkor az lesz
                ConsoleApp.funcLog("room1.addNeighbour(room)");
                r1.addNeighbour(room);
            }
        }
        ConsoleApp.funcLog("room2.geteffects()");
        for (Effect e : r2.getEffects()) {
            ConsoleApp.funcLog("room1.geteffects().contains(Effect: e)");
            if (!r1.getEffects().contains(e)) { //ha nincs ilyenje akkor kap
                ConsoleApp.funcLog("room1.addEffect(effect: e)");
                r1.addEffect(e);
            }
        }
        ConsoleApp.funcLog("room1.getItems().addAll(room2.getItems())");
        ConsoleApp.funcLog("room1.getItems()");
        r1.getItems().addAll(r2.getItems()); //itemek is atkerulnek
        ConsoleApp.funcLog("roomManager.deleteRoom(room2)");
        deleteRoom(r2);
        ConsoleApp.returnLog("return");
    }

    /**
     * Szetoszt egy szobat kettore
     * A befogadokepesseget felezi, az itemeket-szomszedokat-effektet random osztja szet
     * @param r
     */
    public void splitRoom(Room r) {
        //capacity split
        ConsoleApp.funcLog("room.getId()");
        ConsoleApp.funcLog("room.getCapacity()");
        Room newRoom = new Room(r.getCapacity() / 2, r.getId());
        ConsoleApp.funcLog("room.setCapacity(room.getcapacity()/2)");
        ConsoleApp.funcLog("room.getCapacity()");
        r.setCapacity(r.getCapacity() / 2);

        //item split
        ConsoleApp.funcLog("room.getItems()");
        Collections.shuffle(r.getItems()); //hogy random keruljenek at, ne az eredeti sorrendben
        ConsoleApp.funcLog("room.getItems()");
        ConsoleApp.funcLog("room.getItems()");
        ArrayList<Item> firstHalfItems = new ArrayList<>(r.getItems().subList(0, r.getItems().size() / 2)); //elfelezes
        ConsoleApp.funcLog("room.getItems()");
        ConsoleApp.funcLog("room.getItems()");
        ConsoleApp.funcLog("room.getItems()");
        ArrayList<Item> secondHalfItems = new ArrayList<>(r.getItems().subList(r.getItems().size() / 2, r.getItems().size()));
        ConsoleApp.funcLog("room.getItems()");
        ConsoleApp.funcLog("room.getItems()");
        r.getItems().clear(); 
        r.getItems().addAll(firstHalfItems);
        ConsoleApp.funcLog("room.getItems.addAll(ArrayList<Item>: items)");
        newRoom.getItems().addAll(secondHalfItems);

        //effect split
        ConsoleApp.funcLog("room.geteffects()");
        if (r.getEffects().size() == 2) {
            ConsoleApp.funcLog("room.geteffects()");
            Collections.shuffle(r.getEffects());
            ConsoleApp.funcLog("room.addEffects(room.geteffects().remove(0))");
            ConsoleApp.funcLog("room.geteffects()");
            newRoom.addEffect(r.getEffects().remove(0));
        }

        //neighbour split
        ConsoleApp.funcLog("room.getNeighbours()");
        Collections.shuffle(r.getNeighbours());
        ConsoleApp.funcLog("room.getNeighbours()");
        ConsoleApp.funcLog("room.getNeighbours().size()");
        ArrayList<Room> firstHalfN = new ArrayList<>(r.getNeighbours().subList(0, r.getNeighbours().size() / 2));
        ConsoleApp.funcLog("room.getNeighbours()");
        ConsoleApp.funcLog("room.getNeighbours().size()");
        ConsoleApp.funcLog("room.getNeighbours().size()");
        ArrayList<Room> secondHalfN = new ArrayList<>(r.getNeighbours().subList(r.getNeighbours().size() / 2, r.getNeighbours().size()));
        ConsoleApp.funcLog("room.getNeighbours().clear()");
        ConsoleApp.funcLog("room.getNeighbours().addAll(ArrayList<Room>: rooms)");
        ConsoleApp.funcLog("r.getNeighbours().add(Room: room)");
        r.getNeighbours().clear(); 
        r.getNeighbours().addAll(firstHalfN);
         r.getNeighbours().add(newRoom);
        ConsoleApp.funcLog("room.getNeighbours().addAll(ArrayList<Room>: rooms)");
        ConsoleApp.funcLog("r.getNeighbours().add(Room: room)");
        newRoom.getNeighbours().addAll(secondHalfN); newRoom.getNeighbours().add(r);
        rooms.add(newRoom);
        ConsoleApp.returnLog("return");
    }

    /**
     * Kitorli a paramul kapott szobat
     * @param r
     */
    public void deleteRoom(Room r) {
        rooms.remove(r);
        for (Room room : rooms) {
            ConsoleApp.funcLog("room.getNeighbours().contains(Room: r)");
            if (room.getNeighbours().contains(r)) {
                ConsoleApp.funcLog("room.getNeighbours().remove(Room: r)");
                room.getNeighbours().remove(r);
            }
        }
        ConsoleApp.returnLog("return");
    }

    /**
     * Visszater azokkal a szobakkal, amikbol el lehet jutni a paramul kapott szobaba
     * @param r
     * @return inNeighbour
     */
    public static ArrayList<Room> getInNeighbours(Room r) {
        ArrayList<Room> inNeighbours = new ArrayList<Room>();
        for (Room room : rooms) {
            ConsoleApp.funcLog("room.getNeighbours().contains(Room: r)");
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
        for (Room room : rooms){
            ConsoleApp.funcLog("room.clearItems()");
            room.clearItems();
        }
        ConsoleApp.returnLog("return");
    }

    /**
     * Meghivja az osszes szobara az effektjeiket
     */
    public void triggerAllEffects() {
        for (Room room : rooms) {
            ConsoleApp.funcLog("room.treggerRoomEffects()");
            room.triggerRoomEffects();
        }
        ConsoleApp.returnLog("return");
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = (ArrayList<Room>) rooms;
    }
}
