package src.testing;

import java.util.ArrayList;
import java.util.List;

public class TestCase {
    final State startState;
    final State endState;
    final List<TestActionDTO> actions;

    public TestCase(State startState, State endState) {
        this.startState = null;
        this.endState = null;
        this.actions = new ArrayList<>();
    }
}
