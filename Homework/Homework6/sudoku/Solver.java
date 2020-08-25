package Homework.Homework6.sudoku;

import java.util.*;

public class Solver {
    private Grid problem;
    private ArrayList<Grid> solutions;


    public Solver(Grid problem) {
        this.problem = problem;
    }


    public void solve() {
        solutions = new ArrayList<>();
        solveRecurse(problem);
    }


    //
    // Standard backtracking recursive solver.
    //
    private void solveRecurse(Grid grid) {
        Evaluation eval = evaluate(grid);

        if (eval == Evaluation.ABANDON) {
            // Abandon evaluation of this illegal board.
            return;
        } else if (eval == Evaluation.ACCEPT) {
            // A complete and legal solution. Add it to solutions.
            solutions.add(grid);
        } else {
            // Here if eval == Evaluation.CONTINUE. Generate all 9 possible next grids. Recursively
            // call solveRecurse() on those grids.
            for (Grid g : grid.next9Grids()) {
                solveRecurse(g);
            }
        }
    }

    //
    // Returns Evaluation.ABANDON if the grid is illegal.
    // Returns ACCEPT if the grid is legal and complete.
    // Returns CONTINUE if the grid is legal and incomplete.
    //
    public Evaluation evaluate(Grid grid) {
        if (!grid.isLegal())
            return Evaluation.ABANDON;
        else if (grid.isLegal() && grid.isFull())
            return Evaluation.ACCEPT;
        else
            return Evaluation.CONTINUE;
    }


    public ArrayList<Grid> getSolutions() {
        return solutions;
    }


    public static void main(String[] args) {
        Grid g = TestGridSupplier.getPuzzle1();
        Solver solver = new Solver(g);
        System.out.println("Will solve\n" + g);
        solver.solve();

        // Print out your solution, or test if it equals() the solution in TestGridSupplier.
        if (solver.solutions.get(0).equals(TestGridSupplier.getSolution1()))
            System.out.println("Equal to solution in TestGridSupplier\n");
        else
            System.out.println("Not equal to solution in TestGridSupplier\n");
        System.out.println(solver.solutions.get(0).toString());
    }
}
