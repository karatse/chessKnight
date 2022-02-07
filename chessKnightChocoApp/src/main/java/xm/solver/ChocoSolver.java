package xm.solver;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.IntVar;
import xm.chess.Board;
import xm.chess.Position;
import xm.chess.piece.AbstractPiece;
import xm.util.ChocoPath;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

/**
 * This ISolver uses an external library. But is not fully implemented.
 * The piece might get out of the board.
 */
public class ChocoSolver implements ISolver {
    private static Collection<Position> executeMoves(Solution solution, IntVar[] vs, Position start) {
        if (solution == null) {
            return null;
        }
        ChocoPath path = new ChocoPath(start);
        path.accumulateMoves(solution.getIntVal(vs[0]), new Position(2, 1), new Position(-2, -1));
        path.accumulateMoves(solution.getIntVal(vs[1]), new Position(1, 2), new Position(-1, -2));
        path.accumulateMoves(solution.getIntVal(vs[2]), new Position(-2, 1), new Position(2, -1));
        path.accumulateMoves(solution.getIntVal(vs[3]), new Position(-1, 2), new Position(1, -2));
        return path.getPath();
    }

    @Override
    public Optional<Collection<Position>> path(Board board, AbstractPiece piece, Position target, int k) {
        Position start = piece.getPos();
        int vdiff = target.row() - start.row();
        int hdiff = target.col() - start.col();
        Model model = new Model();
        IntVar[] vs = model.intVarArray("vs", 4, -k, k);
        model.scalar(vs, new int[]{2, 1, -2, -1}, "=", vdiff).post();
        model.scalar(vs, new int[]{1, 2, 1, 2}, "=", hdiff).post();
        model.sum(Arrays.stream(vs).map(model::intAbsView).toArray(IntVar[]::new), "<=", k).post();

        return Optional.ofNullable(model.getSolver().findSolution()).map(s -> executeMoves(s, vs, start));
    }
}
