package src.Game;

public class Camembert extends Item {
    private int remainingTime;

    public Camembert(Room r) {
        super(r);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean useItem(Character c) {
        currentRoom.addEffect(new Cursed(true));
        return true; //?
    }

    @Override
    public boolean IsUnpaired() {
        return false;
    }

    @Override
    public void setRemainingTime(int i) {
        remainingTime = i;
    }

    @Override
    public void initItem() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initItem'");
    }

    private void makeRoomGassy() {

    }

    @Override
    public boolean isActive() {
        return false;
    }
    
}
