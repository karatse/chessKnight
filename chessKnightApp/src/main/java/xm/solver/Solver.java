package xm.solver;

import xm.chess.Board;
import xm.chess.Position;
import xm.chess.piece.AbstractPiece;
import xm.util.Path;

import java.util.*;

public class Solver implements ISolver {
    @Override
    public Optional<Collection<Position>> path(Board board, AbstractPiece piece, Position target, int k) {
        if (piece.getPos().equals(target)) {
            return Optional.of(List.of(target));
        }

        List<Path<Position>> queue = new Vector<>();
        Set<Position> visit = new HashSet<>();

        visit.add(piece.getPos());
        queue.add(new Path<>(piece.getPos()));

        while (!queue.isEmpty()) {
            Path<Position> t = queue.remove(0);

            for (Position offset : piece.getMoveOffsets()) {
                Position next = t.getLast().offset(offset);
                if (board.valid(next) && !visit.contains(next)) {
                    List<Position> path = t.getPath();
                    if (next.equals(target)) {
                        path.add(next);
                        return Optional.of(path);
                    }
                    if (path.size() < k) {
                        visit.add(next);
                        queue.add(new Path<>(next, path));
                    }
                }
            }
        }
        return Optional.empty();
    }
}
