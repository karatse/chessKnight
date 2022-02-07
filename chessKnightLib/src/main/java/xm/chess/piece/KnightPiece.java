package xm.chess.piece;

import xm.chess.Position;

import java.util.List;

/**
 * Implements the knight piece of chess.
 */
public class KnightPiece extends AbstractPiece {

    final Iterable<Position> moveOffsets = List.of(
            new Position(+2, +1), // 2 up   1 right
            new Position(+1, +2), // 1 up   2 right
            new Position(-1, +2), // 1 down 2 right
            new Position(-2, +1), // 2 down 1 right
            new Position(-2, -1), // 2 down 1 left
            new Position(-1, -2), // 2 down 1 left
            new Position(+1, -2), // 1 up   2 left
            new Position(+2, -1)  // 2 up   1 left
    );

    public KnightPiece(Position pos) {
        super(pos);
    }

    @Override
    public Iterable<Position> getMoveOffsets() {
        return moveOffsets;
    }
}
