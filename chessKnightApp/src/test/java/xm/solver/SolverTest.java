package xm.solver;

import org.junit.jupiter.api.Test;
import xm.chess.Board;
import xm.chess.Position;
import xm.chess.piece.AbstractPiece;
import xm.chess.piece.KnightPiece;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolverTest {

    @Test
    void path() {
        Board board = new Board();
        AbstractPiece piece = new KnightPiece(new Position(0, 0));
        Position target = new Position(2, 2);
        assertTrue(new Solver().path(board, piece, target, 3).isEmpty());
        assertTrue(new Solver().path(board, piece, target, 4).isPresent());
    }
}