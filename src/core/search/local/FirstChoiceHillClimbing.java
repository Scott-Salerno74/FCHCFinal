package core.search.local;

import aima.core.search.framework.NodeFactory;

import java.util.function.ToDoubleFunction;

public class FirstChoiceHillClimbing extends HillClimbingSearch {

    public FirstChoiceHillClimbing(ToDoubleFunction evalFn) {
        super(evalFn);
    }

    public FirstChoiceHillClimbing(ToDoubleFunction evalFn, NodeFactory nodeFactory) {
        super(evalFn, nodeFactory);
    }
}
