// Mike Fry, LVC, 2019

import java.util.Random;
import java.util.ArrayList;

/**
 * The state of a chessboard with one queen per column, any square size.
 */
public class QueenState{
    private static Random random = new Random();  // Initialize only once!

    int[] rowByCol;  // Row of each queen, indexed by columns

    public ArrayList<QueenAction> actionList = null;

    public QueenState(int size) {  // Random queens
        rowByCol = new int[size];
        shuffle();
        actionList = new ArrayList<QueenAction>();
        for (int col = 0; col < size; ++col) {
            for (int ofs = 1; ofs < size; ++ofs) {  // 0 ofs not action.
                actionList.add(new QueenAction(col, ofs));
            }
        }
    }

    public QueenState(QueenState qs) {  // Copy constructor
        this(qs.size());
        for (int col = 0; col < this.size(); ++col) {
            this.rowByCol[col] = qs.rowByCol[col];
        }
    }

    public int size() {
        return this.rowByCol.length;
    }

    public QueenState act(QueenAction qa) {  // Returns successor.
        QueenState newq = new QueenState(this);
        newq.rowByCol[qa.col] += qa.rowOffset;
        newq.rowByCol[qa.col] %= size();
        return newq;
    }

    private void shuffle() {  // Shuffles this board. One Q per column.
        int sz = this.size();
        for (int i = 0; i < sz; ++i) rowByCol[i] = random.nextInt(sz);
    }

    public ArrayList<QueenAction> getActions() {
        return actionList;
    }

    public ArrayList<QueenState> getSuccessors() {  // All successor states.
        ArrayList<QueenAction> qas = this.getActions();
        ArrayList<QueenState> succs= new ArrayList<>();
        for (QueenAction action : qas) {
            succs.add(this.act(action));
        }
        return succs;
    }

    public int heuristic() {  // Number of queen pairs that can attack.
        int atkCount = 0;
        for (int col1 = 0; col1 < size()-1; ++col1)
            for (int col2 = col1+1; col2 < size(); ++col2) {
                int u = col2 - col1;
                int v = Math.abs(this.rowByCol[col2] - this.rowByCol[col1]);
                if (u == v | v == 0) ++atkCount;
            }
        return atkCount;
    }

    public int fitness() {
        return (this.size() * (this.size()-1)) / 2 - heuristic();
    }

    public boolean isGoal() { return heuristic() == 0; }

    public boolean equals(Object obj) {
        QueenState qs;
        if (obj instanceof QueenState) qs = (QueenState) obj; else return false;
        for (int i = 0; i < size(); ++i) {
            if (rowByCol[i] != qs.rowByCol[i]) return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int row = 0; row < this.size(); ++row) {
            for (int col = 0; col < this.size(); ++col) {
                s.append((rowByCol[col] == row) ? "  Q" : " - ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
