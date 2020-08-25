package Homework.Homework5;

public class Complex
{
	private double			real;
	private double			imaginary;


	// Constructs an instance, given its real and imaginary components.
	public Complex(double real, double imaginary)
	{
		this.real = real;
		this.imaginary = imaginary;
	}


	// Constructs an instance that duplicates source.
	public Complex(Complex source)
	{
		this.real = source.getReal();
		this.imaginary = source.getImaginary();
	}


	// Getter method.
	public double getReal()
	{
		return real;
	}


	// Getter method.
	public double getImaginary()
	{
		return imaginary;
	}


	//
	// Constructs and returns a new instance of Complex that represents the sum of its inputs,
	// according to the following formula:
	//
	// (a+bi) plus (c+di) = (a+c) + (b+d)i
	public static Complex add(Complex c1, Complex c2)
	{
		double newReal = c1.getReal() + c2.getReal();
		double newImaginary = c1.getImaginary() + c2.getImaginary();
		return new Complex(newReal, newImaginary);
	}


	//
	// Constructs and returns a new instance of Complex that represents the product of its inputs,
	// according to the following formula:
	//
	// (a+bi) times (c+di) = a*c + a*di + bi*c + bi*di = ac + (ad+bc)i + bd*ii
	// Since ii is -1 by definition, the last term is -bd ==> the result is ac-bd + (ad+bc)i
	//
	public static Complex multiply(Complex c1, Complex c2)
	{
		double newReal = (c1.getReal()*c2.getReal()) - (c1.getImaginary()*c2.getImaginary());
		double newImaginary = (c1.getReal()*c2.getImaginary()) + (c1.getImaginary()*c2.getReal());
		return new Complex(newReal, newImaginary);
	}


	// The "norm" of complex number a+bi is the square root of (a^2 + b^2).
	public double norm()
	{
		double realSquared = Math.pow(real, 2);
		double imaginarySquared = Math.pow(imaginary, 2);
		double norm = Math.sqrt(realSquared + imaginarySquared);
		return norm;
	}
}
