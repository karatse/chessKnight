package xm.chess;

/**
 * A position on the board. The indexing of the columns and rows is 0-based.
 */
public record Position(int col, int row) {
    public Position offset(Position offset) {
        return new Position(col + offset.col, row + offset.row);
    }
}
