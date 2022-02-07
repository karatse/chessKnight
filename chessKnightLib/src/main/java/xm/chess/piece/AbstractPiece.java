package xm.chess.piece;

import xm.chess.Position;

/**
 * An abstract implementation of a chess piece.
 */
public abstract class AbstractPiece {
    private final Position pos;

    /**
     * Creates a chess piece with a specified location on the board.
     *
     * @param pos the position of the piece
     */
    public AbstractPiece(Position pos) {
        this.pos = pos;
    }

    public Position getPos() {
        return pos;
    }

    /**
     * @return an iterable with all the offsets of the moves that
     * the underlying implementation of the chess piece can perform
     */
    abstract public Iterable<Position> getMoveOffsets();
}
