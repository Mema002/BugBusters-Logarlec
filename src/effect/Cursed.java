package src.effect;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import src.game.ConsoleApp;
import src.room.Room;
import src.room.RoomManager;

public class Cursed extends Effect {
    private boolean active;
    private ArrayList<Room> inNeighbours;
    private ArrayList<Room> outNeighbours;

    /**
     * Cursed konstruktor
     */
    public Cursed() {
        this.inNeighbours = new ArrayList<Room>();
        this.outNeighbours = new ArrayList<Room>();
    }
    
    /** 
     * Cursed effektus meghivasa
     * Eltunteti a szomszedokat, nem minden hivasra 100%,hogy megtortenik
     * Vagy visszahozza a szomszedokat, 100% esellyel
     * @param r
     */
    @Override
    public void triggerEffect(Room r) {
        if (!active) {
            Random random = new Random(); //aktivalas nem 100%
            if (random.nextInt(2) == 0) {
                active = true;
                ConsoleApp.funcLog("room.getNeighbours()");
                outNeighbours = new ArrayList<>(r.getNeighbours());
                ConsoleApp.funcLog("room.getNeighbours().clear()");
                r.getNeighbours().clear();
                ConsoleApp.funcLog("roomManager.getInNeighbours(Room: room)");
                inNeighbours = RoomManager.getInNeighbours(r);
                for (Room room: inNeighbours){
                    ConsoleApp.funcLog("room.getNeighbours().remove(Room: room)");
                    room.getNeighbours().remove(r); 
                }
                ConsoleApp.returnLog("return");
            }
            else{
                ConsoleApp.returnLog("return null");
                 return; //ha nem lett aktiv
            } 
           
        }
        else { //deaktivalas
            active = false;
            ConsoleApp.funcLog("room.getNeighbours().addAll(ArrayList<Room>: outNeighbours)");
            r.getNeighbours().addAll(outNeighbours);
            ConsoleApp.funcLog("Cursed.outNeighbours.clear()");
            outNeighbours.clear();
            for (Room room : inNeighbours) {
                ConsoleApp.funcLog("room.getNeighbours().add(Room: room)");
                room.getNeighbours().add(r);
            }
            ConsoleApp.funcLog("Cursed.inNeighbours.clear()");
            inNeighbours.clear();
            ConsoleApp.returnLog("return");
        }
    }

    @Override
    public String toString() {
        return "Cursed";
    }

    @Override
    public void clearGas(Room r) {
        return;
    }

    @Override
    public boolean isSticky(Room r) {
        return false;
    }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("images/Cursed.png");
    }
}
