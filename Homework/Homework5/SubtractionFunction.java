package Homework.Homework5;

public class SubtractionFunction implements DoubleFunctionOfTwoInts{
    @Override
    public double fOfXY(int x, int y) {
        return x - y;
    }

    @Override
    public String getName() {
        return "Subtraction Function";
    }
}
