package Homework.Homework5;

public class ComplexNormFunction implements DoubleFunctionOfTwoInts{
    @Override
    public double fOfXY(int x, int y) {
        double realSquared = Math.pow(x, 2);
        double imaginarySquared = Math.pow(y, 2);
        double norm = Math.sqrt(realSquared + imaginarySquared);
        return norm;
    }

    @Override
    public String getName() {
        return "Complex Norm Function";
    }
}
