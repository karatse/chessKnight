package xm.chess;

/**
 * Representation of a chess board.
 */
public class Board {
    final private int size;

    public Board() {
        size = 8;
    }

    public int getSize() {
        return size;
    }

    /**
     * @param pos the position to be checked
     * @return checks if the position is valid for this board
     */
    public boolean valid(Position pos) {
        return 0 <= pos.col() && pos.col() < size && 0 <= pos.row() && pos.row() < size;
    }

    /**
     * @param position a valid position of the board
     * @return the notational representation of the position
     */
    public String notationFromPosition(Position position) {
        return String.valueOf((char) ('A' + position.col())) + (position.row() + 1);
    }

    /**
     * @param notation a notational representation of a position
     * @return the actual position
     */
    public Position positionFromNotation(String notation) throws IllegalArgumentException {
        if (notation.length() != 2)
            throw new IllegalArgumentException("For input string: \"" + notation + "\"");
        int col = notation.charAt(0) - 'A';
        int row = notation.charAt(1) - '1';
        Position pos = new Position(col, row);
        if (!valid(pos))
            throw new IllegalArgumentException("Position out of bounds for input string: \"" + notation + "\"");
        return pos;
    }
}
