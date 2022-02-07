package xm;

import xm.solver.ChocoSolver;

import java.io.IOException;

public class ChocoApplication {

    public static void main(String[] args) throws IOException {
        Application.run(new ChocoSolver());
    }
}
