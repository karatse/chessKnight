package xm;

import xm.chess.Board;
import xm.chess.Position;
import xm.chess.piece.AbstractPiece;
import xm.chess.piece.KnightPiece;
import xm.solver.ISolver;
import xm.solver.Solver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Create a Java application that should represent an empty chessboard where the user will be able to enter a starting
 * position and an ending position. The application should then calculate a list of all possible paths that one knight
 * piece in the starting position could take to reach the ending position in 3 moves. Some inputs might not have a
 * solution, in this case the program should display a message that no solution has been found. Otherwise, the shortest
 * path (if that exists) should be returned.
 * <p>
 * Please note:
 * <ul>
 * <li>Although a graphical display would be welcome, this is not required.
 * <li>Input can be given by the command line, a text file or whatever you might prefer.
 * <li>Output could also be kept simple: just print out the path in a textual format (i.e. A2 -> B5 etc)
 * <li>Emphasis will be given on the algorithm, general code structure and how the program could be extended.
 * <li>Unit tests would be highly appreciated
 * </ul>
 */
public class Application {

    public static void main(String[] args) throws IOException {
        run(new Solver());
    }

    public static void run(ISolver solver) throws IOException {
        Board board = new Board();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter starting position [A-H][1-8]: ");
        Position starting = board.positionFromNotation(br.readLine());

        System.out.print("Enter ending position [A-H][1-8]: ");
        Position ending = board.positionFromNotation(br.readLine());

        System.out.print("Enter mox moves (e.g.: 3): ");
        int k = Integer.parseUnsignedInt(br.readLine());

        AbstractPiece piece = new KnightPiece(starting);
        Optional<Collection<Position>> path = solver.path(board, piece, ending, k);
        System.out.println(path.map(p -> p.stream()
                        .map(board::notationFromPosition)
                        .collect(Collectors.joining(" -> ")))
                .orElse("no solution has been found."));
    }
}
