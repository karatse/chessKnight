package xm.util;

import xm.chess.Position;

public class ChocoPath extends Path<Position> {
    public ChocoPath(Position last) {
        super(last);
    }

    public void addOffset(Position offset) {
        Position next = getLast().offset(offset);
        path.add(next);
    }

    public void accumulateMoves(int v, Position p, Position n) {
        while (v > 0) {
            addOffset(p);
            v--;
        }
        while (v < 0) {
            addOffset(n);
            v++;
        }
    }
}
