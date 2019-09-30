import java.util.List;

public class EightQueensProblem implements OptimizationProblem<QueenState, QueenAction> {
   private QueenState queenInit = new QueenState(8);
    @Override
    public QueenState getInitialState() {
        return queenInit;
    }

    @Override
    public List<QueenAction> getActions(QueenState state) {
        return state.actionList;
    }

    @Override
    public QueenState getResult(QueenState state, QueenAction action) {
        return state.act(action);
    }

    @Override
    public boolean testGoal(QueenState state) {
        return state.isGoal();
    }

    @Override
    public double getObjective(QueenState State) {
        int temp = Integer.MAX_VALUE - State.heuristic();
        return (double) temp;
    }
}
