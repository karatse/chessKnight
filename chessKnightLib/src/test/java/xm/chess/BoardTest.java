package xm.chess;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @org.junit.jupiter.api.Test
    void valid() {
        for (int col = 0; col < board.getSize(); col++) {
            for (int row = 0; row < board.getSize(); row++) {
                assertTrue(board.valid(new Position(col, row)));
            }
        }
        assertFalse(board.valid(new Position(0, board.getSize())));
        assertFalse(board.valid(new Position(board.getSize(), 0)));
    }

    @org.junit.jupiter.api.Test
    void notationFromPosition() {
        for (char col = 'A'; col < 'A' + board.getSize(); col++) {
            for (int row = 1; row <= board.getSize(); row++) {
                Position position = new Position(col - 'A', row - 1);
                assertEquals(String.valueOf(col) + row, board.notationFromPosition(position));
            }
        }
    }

    @org.junit.jupiter.api.Test
    void positionFromNotation() {
        for (char col = 'A'; col < 'A' + board.getSize(); col++) {
            for (int row = 1; row <= board.getSize(); row++) {
                Position position = board.positionFromNotation(String.valueOf(col) + row);
                assertEquals(position, new Position(col - 'A', row - 1));
            }
        }
        assertThrows(IllegalArgumentException.class, () -> board.positionFromNotation("A0"));
        assertThrows(IllegalArgumentException.class, () -> board.positionFromNotation("P2"));
    }
}