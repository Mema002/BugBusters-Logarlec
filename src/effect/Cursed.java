package src.effect;

import java.util.ArrayList;
import java.util.Random;

import src.room.Room;
import src.room.RoomManager;

public class Cursed extends Effect {
    private boolean active;
    private ArrayList<Room> inNeighbours;
    private ArrayList<Room> outNeighbours;

    public Cursed() {
        this.inNeighbours = new ArrayList<Room>();
        this.outNeighbours = new ArrayList<Room>();
    }

    @Override
    public void triggerEffect(Room r) {
        if (!active) {
            Random random = new Random(); //aktivalas nem 100%
            if (random.nextInt(2) == 0) {
                active = true;
                outNeighbours = r.getNeighbours();
                r.getNeighbours().clear();
                inNeighbours = RoomManager.getInNeighbours(r);
                for (Room room: inNeighbours)
                    room.getNeighbours().remove(r);
            }
            else return; //ha nem lett aktiv
        }
        else { //deaktivalas
            active = false;
            r.getNeighbours().addAll(outNeighbours);
            outNeighbours.clear();
            for (Room room : inNeighbours) {
                room.getNeighbours().add(r);
            }
            inNeighbours.clear();
        }
    }
}
