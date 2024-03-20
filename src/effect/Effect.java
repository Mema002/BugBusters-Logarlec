package src.effect;

import src.character.Character;

public abstract class Effect {
    protected boolean active;

    public Effect(boolean a) {
        this.active = a;
    }

    public abstract void triggerEffect(Character c);
}
