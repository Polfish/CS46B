package Homework.Homework5;

public class ComplexSquaredNormFunction implements DoubleFunctionOfTwoInts{
    @Override
    public double fOfXY(int x, int y) {
        double realSquared = Math.pow(Math.pow(x, 2) - Math.pow(y, 2), 2);
        double imaginarySquared = Math.pow((2*x*y), 2);
        double norm = Math.sqrt(realSquared + imaginarySquared);
        return norm;
    }

    @Override
    public String getName() {
        return "Complex Squared Norm Function";
    }
}
