package Homework.Homework5;

public class RecursiveFunction implements DoubleFunctionOfTwoInts {
    @Override
    public double fOfXY(int x, int y) {
        return recursion(x) + recursion(y);
    }

    public int recursion(int number) {
        if (number > 0) {
            return number + recursion(number - 1);
        }
        else if (number < 0) {
            return number + recursion(number + 1);
        }
        return 1;
    }

    @Override
    public String getName() {
        return "Recursive Function";
    }
}
