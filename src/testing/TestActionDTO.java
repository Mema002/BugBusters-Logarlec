package src.testing;

import src.character.Character;

import java.util.Arrays;

public class TestActionDTO {

    Character character;
    String action;
    String[] params;

    @Override
    public String toString() {
        return "TestActionDTO: Character: " + character + " Action:" + action + " Params:" + Arrays.toString(params);
    }

}
