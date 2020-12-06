

public class GammaFunction {
private double dblGammaValue = 1;
private long intGammaValue = 1;
private double gamma;

FraccionIrreducible myFracc = new FraccionIrreducible();

public double callGamma(double x) {
	if (x%1 == 0) {
	long	y = (long) x;
	gamma = computeIntGamma(y);
	}else {
		double numerator = myFracc.getNumerator(x);
		double denumerator = myFracc.getDenumerator(x);
		gamma = computeDblGamma(numerator,denumerator);
	}
	
	
	return gamma;
}

public long computeIntGamma(long y) {
	y = y-1;
	for(int j = 1; j<=y;j++) {
	
		intGammaValue = intGammaValue * j;
	}
	
	return intGammaValue;
	
}

public double computeDblGamma(double numerator, double denumerator) {
	
	int n = (int) ((int) numerator-denumerator);
	int d = 0;
	numerator = numerator - denumerator;
	
	do {
		numerator = numerator * (n-denumerator);
		
		n =(int) ((int) n - denumerator);
		d++;
	}while(n>denumerator);
	denumerator = Math.pow(denumerator, d+1);
		dblGammaValue = (numerator / denumerator)* java.lang.Math.sqrt(Math.PI);
		return dblGammaValue;
}

}
