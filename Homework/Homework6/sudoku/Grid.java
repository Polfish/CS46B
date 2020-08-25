package Homework.Homework6.sudoku;

import java.util.*;

public class Grid {
    private int[][] values;

    //
    // DON'T CHANGE THIS.
    //
    // Constructs a Grid instance from a string[] as provided by TestGridSupplier.
    // See TestGridSupplier for examples of input.
    // Dots in input strings represent 0s in values[][].
    //
    public Grid(String[] rows) {
        values = new int[9][9];
        for (int j = 0; j < 9; j++) {
            String row = rows[j];
            char[] charray = row.toCharArray();
            for (int i = 0; i < 9; i++) {
                char ch = charray[i];
                if (ch != '.')
                    values[j][i] = ch - '0';
            }
        }
    }

    //
    // DON'T CHANGE THIS.
    //
    public String toString() {
        String s = "";
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                int n = values[j][i];
                if (n == 0)
                    s += '.';
                else
                    s += (char) ('0' + n);
            }
            s += "\n";
        }
        return s;
    }


    //
    // DON'T CHANGE THIS.
    // Copy ctor. Duplicates its source. You'll call this 9 times in next9Grids.
    //
    Grid(Grid src) {
        values = new int[9][9];
        for (int j = 0; j < 9; j++)
            for (int i = 0; i < 9; i++)
                values[j][i] = src.values[j][i];
    }

    //
    // Finds an empty member of values[][]. Returns an array list of 9 grids that look like the current grid,
    // except the empty member contains 1, 2, 3 .... 9. Returns null if the current grid is full. Don't change
    // this grid. Build 9 new grids.
    //
    //
    // Example: if this grid = 1........
    //                         .........
    //                         .........
    //                         .........
    //                         .........
    //                         .........
    //                         .........
    //                         .........
    //                         .........
    //
    // Then the returned array list would contain:
    //
    // 11.......          12.......          13.......          14.......    and so on     19.......
    // .........          .........          .........          .........                  .........
    // .........          .........          .........          .........                  .........
    // .........          .........          .........          .........                  .........
    // .........          .........          .........          .........                  .........
    // .........          .........          .........          .........                  .........
    // .........          .........          .........          .........                  .........
    // .........          .........          .........          .........                  .........
    // .........          .........          .........          .........                  .........
    //
    public ArrayList<Grid> next9Grids() {
        int xOfNextEmptyCell = 0;
        int yOfNextEmptyCell = 0;

        // Find x,y of an empty cell.
        for (int row = 0; row < values.length; row++) {
            for (int column = 0; column < values[0].length; column++) {
                if (values[row][column] == 0) {
                    xOfNextEmptyCell = row;
                    yOfNextEmptyCell = column;
                }
            }
        }

        // Construct array list to contain 9 new grids.
        ArrayList<Grid> grids = new ArrayList<Grid>();

        // Create 9 new grids as described in the comments above. Add them to grids.
        for (int i = 1; i <= 9; i++) {
            Grid block = new Grid(this);
            block.values[xOfNextEmptyCell][yOfNextEmptyCell] = i;
            grids.add(block);
        }
        return grids;
    }

    //
    // Returns true if this grid is legal. A grid is legal if no row, column, or
    // 3x3 block contains a repeated 1, 2, 3, 4, 5, 6, 7, 8, or 9.
    //
    public boolean isLegal() {
        // Check every row. If you find an illegal row, return false.
        for (int row = 0; row < values.length; row++) {
            for (int column = 0; column < values[0].length; column++) {
                int number = values[row][column];
                for (int i = column + 1; i < values[0].length; i++) {
                    int secondNumber = values[row][i];
                    if (number == secondNumber && number != 0) {
                        return false;
                    }
                }
            }
        }

        // Check every column. If you find an illegal column, return false.
        for (int column = 0; column < values[0].length; column++) {
            for (int row = 0; row < values.length; row++) {
                int number = values[row][column];
                for (int i = row + 1; i < values.length; i++) {
                    int secondNumber = values[i][column];
                    if (number == secondNumber && number != 0) {
                        return false;
                    }
                }
            }
        }

        // Check every block. If you find an illegal block, return false.
        for (int blockStart = 0; blockStart < values.length; blockStart += 3) {
            for (int blockEnd = 0; blockEnd < values[0].length; blockEnd += 3) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int row = blockStart; row < blockStart + 3; row++) {
                    for (int column = blockEnd; column < blockEnd + 3; column++) {
                        if (values[row][column] != 0 && temp.contains(values[row][column])) {
                            return false;
                        }
                        temp.add(values[row][column]);
                    }
                }
            }
        }
        
        // All rows/cols/blocks are legal.
        return true;
    }

    //
    // Returns true if every cell member of values[][] is a digit from 1-9.
    //
    public boolean isFull() {
        for (int[] insideArray : values) {
            for (int number : insideArray) {
                if (number == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    //
    // Returns true if x is a Grid and, for every (i,j),
    // x.values[i][j] == this.values[i][j].
    //
    public boolean equals(Object x) {
        //Original Solution
//        if (x instanceof Grid) {
//            Grid compareGrid = (Grid) x;
//            for (int row = 0; row < this.values.length; row++) {
//                for (int column = 0; column < this.values[0].length; column++) {
//                    if (this.values[row][column] != compareGrid.values[row][column])
//                        return false;
//                }
//            }
//            return true;
//        }
//        return false;

        //Better Solution
        Grid compareGrid = (Grid) x;
        for (int row = 0; row < this.values.length; row++) {
            for (int column = 0; column < this.values[0].length; column++) {
                if (this.values[row][column] != compareGrid.values[row][column])
                    return false;
            }
        }
        return true;
    }
}
