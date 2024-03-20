package src.Game;

public class Sliderule extends Item {

    public Sliderule(Room r) {
        super(r);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean useItem(Character c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'useItem'");
    }

    @Override
    public boolean IsUnpaired() {
        return false;
    }

    @Override
    public void setRemainingTime(int i) {
        return;
    }

    @Override
    public void initItem() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initItem'");
    }

    @Override
    public boolean isActive() {
        return false;
    }
    
}
