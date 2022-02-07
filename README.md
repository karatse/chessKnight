# chessKnight

A simple project to demonstrate use of:

- multi-module projects
- external libraries
- code structure
- inheritance

## [Solver](chessKnightApp/src/main/java/xm/Application.java)

This is a simple implementation of the app that satisfies all the requirements.

## [ChocoSolver](chessKnightChocoApp/src/main/java/xm/ChocoApplication.java)

This implementation uses [Choco](https://choco-solver.org/) to model a constraint problem.

## Tests

Some tests for [Solver](chessKnightApp/src/test/java/xm/solver/SolverTest.java)
and [Board](chessKnightLib/src/test/java/xm/chess/BoardTest.java) classes are provided.