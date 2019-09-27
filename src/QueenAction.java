// Fry, LVC, 2019


/**
 * Move by one queen within her column.  If rowOffset=0, then no movement.
 *   Add rowOffset, and take remainder mod board size.
 */
public class QueenAction {

    public int col;
    public int rowOffset; // How many rows forward mod size

    public QueenAction(int col, int rowOffset) {
        this.col = col;
        this.rowOffset = rowOffset;
    }

}
