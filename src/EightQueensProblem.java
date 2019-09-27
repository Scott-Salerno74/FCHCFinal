import java.util.List;

public class EightQueensProblem implements OptimizationProblem<QueenState, QueenAction> {

    @Override
    public QueenState getInitialState() {
        return null;
    }

    @Override
    public List<QueenAction> getActions(QueenState state) {
        return null;
    }

    @Override
    public QueenState getResult(QueenState state, QueenAction action) {
        return null;
    }

    @Override
    public boolean testGoal(QueenState state) {
        return false;
    }

    @Override
    public double getObjective(QueenState State) {
        return 0;
    }
}
