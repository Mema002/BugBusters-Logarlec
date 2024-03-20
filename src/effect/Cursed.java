package src.Game;

import java.util.ArrayList;

public class Cursed extends Effect {
    private ArrayList<Room> inNeighbours;
    private ArrayList<Room> outNeighbours;

    public Cursed(boolean a) {
        super(a);
        this.inNeighbours = new ArrayList<Room>();
        this.outNeighbours = new ArrayList<Room>();
    }

    @Override
    public void triggerEffect(Character c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'triggerEffect'");
    }
}
