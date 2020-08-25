package Homework.Homework5;

public class AdditionFunction implements DoubleFunctionOfTwoInts
{
	@Override
	public double fOfXY(int x, int y)
	{
		return x + y;
	}
	
	
	@Override
	public String getName()
	{
		return "Addition";
	}
}
