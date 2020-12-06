



import java.util.Scanner;

public class Logic3 {

	private int num_seg = 10;
	private double x = 0;
	private double w;
	private double e = .00001;
	private double dof = 0;
	private double dblW;
	private double dblTotXi [];
	private double dblFirstBaseTerms[];
	private double dblExp[];
	private double dblCoeff;
	private double dblFxi[];
	private double dblFinalTerms[];
	private double dblFinalVal;
	private int[] multipliers;
	
	
	

	public void logic1a(){
		
		Scanner scan = new Scanner( System.in );
		System.out.println("�Qu� valor tiene x?");
		x = scan.nextDouble();
		System.out.println("�Cu�ntos ser�n los grados de libertad?");
		dof = scan.nextDouble();
		
		multipliers = new int[num_seg+1];
		for(int h = 0; h<multipliers.length;h++) {
			if(h%2 == 0) {
				multipliers[h] = 2;
		}else {
				multipliers[h] = 4;}
			
		}
		multipliers[0] = 1;
		multipliers[num_seg] = 1;
		
		output myOut = new output();
		SimpsonIntegration mySimpsonIntegration = new SimpsonIntegration();

		
		
		w = mySimpsonIntegration.computeW(num_seg, x);
		dblTotXi = mySimpsonIntegration.computeXi(w, num_seg);
		dblFirstBaseTerms = mySimpsonIntegration.computeFBT(dblTotXi, dof, num_seg);
		dblExp = mySimpsonIntegration.computeExp(num_seg, dblFirstBaseTerms, dof);
		dblCoeff = mySimpsonIntegration.computeCoeff(dof);
		dblFxi = mySimpsonIntegration.computeFxi(dblExp, dblCoeff, num_seg);
		dblFinalTerms = mySimpsonIntegration.computeFinTerm(w, multipliers, dblFxi, num_seg);
		dblFinalVal = mySimpsonIntegration.computeFinVal(dblFinalTerms, num_seg);
		
		myOut.writeData("out1.txt", "Valor de la integral = " + dblFinalVal);
		
	}
}
