package xm.solver;

import xm.chess.Board;
import xm.chess.Position;
import xm.chess.piece.AbstractPiece;

import java.util.Collection;
import java.util.Optional;

public interface ISolver {
    Optional<Collection<Position>> path(Board board, AbstractPiece piece, Position target, int k);
}
