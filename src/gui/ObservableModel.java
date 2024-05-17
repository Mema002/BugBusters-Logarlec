package src.gui;

import java.util.List;

public class ObservableModel {
    protected List<ModelObserver> observers;

    public void addObserver(ModelObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ModelObserver observer) {
        observers.remove(observer);
    }
}
