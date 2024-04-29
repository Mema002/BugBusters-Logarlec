package src.testing;

import src.character.Character;

import java.util.Arrays;

public class TestActionDTO {

    public Character character;
    public String action;
    public String[] params;

    @Override
    public String toString() {
        return "TestActionDTO: Character: " + character + " Action:" + action + " Params:" + Arrays.toString(params);
    }

}
