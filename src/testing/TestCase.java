package src.testing;

import java.util.ArrayList;
import java.util.List;

public class TestCase {
    final String name;
    final State startState;
    final State endState;
    final List<TestActionDTO> actions;

    public TestCase(String name, State startState, State endState, List<TestActionDTO> actions) {
        this.name = name;
        this.startState = startState;
        this.endState = endState;
        this.actions = actions;
    }

    @Override
    public String toString() {
        return "TestCase: " + "Start" + startState + " End" + endState + " " + actions;
    }
}
