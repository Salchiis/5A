
public class FraccionIrreducible {

	public static double getGCD(double numerator, double denominator) {
		if (denominator == 0) {
			return numerator;
		}
		return getGCD(denominator, numerator % denominator);
	}

	public double getDenumerator(double x) {
		String a = "" + x;
		String spilts[] = a.split("\\.");
		int b = spilts[1].length();
		double denominator = (int) Math.pow(10, b);
		double numerator = (int) (x * denominator);
		double gcd = getGCD(numerator, denominator);
		
		return denominator/gcd;
	}
	
	public double getNumerator (double x) {
		String a = "" + x;
		String spilts[] = a.split("\\.");
		int b = spilts[1].length();
		double denominator = (int) Math.pow(10, b);
		double numerator = (int) (x * denominator);
		double gcd = getGCD(numerator, denominator);
		
		return numerator/gcd;
		
	}
}