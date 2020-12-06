
import java.util.Arrays;

public class SimpsonIntegration {

	GammaFunction myGamma = new GammaFunction();
	private double w;
	private double dblW;
	private double dblTotXi [];
	private double dblFirstBaseTerms[];
	private double dblExp[];
	private double dblCoeff;
	private double dblFxi[];
	private double dblFinalTerms[];
	private double dblFinalVal;
	int j;
	

		public double computeW(int num_seg, double x) {
			w = x/num_seg;
			return w;
		}

		public double[] computeXi(double w, int num_seg) {
			double[] dblTotXi = new double [num_seg+1];
			for(int j=0;j<11;j++) {
				dblTotXi[j] = w*j;
				
			}
			
			return dblTotXi;
		}

		public double[] computeFBT(double[] dblTotXi, double dof, int num_seg) {
			double [] dblFirstBaseTerms = new double[num_seg+1];
			for(j=0;j<num_seg+1;j++) {
				dblFirstBaseTerms[j] = (1+(((dblTotXi[j]*dblTotXi[j]))/dof));
			}
			return dblFirstBaseTerms;
		}

		public double[] computeExp(int num_seg, double[] dblFirstBaseTerms, double dof) {
			double [] dblExp = new double[num_seg+1];
			for(j=0;j<num_seg+1;j++) {
				dblExp[j] = Math.pow(dblFirstBaseTerms[j], -(dof+1)/2);
			}
			
			return dblExp;
		}

		public double computeCoeff(double dof) {
		dblCoeff =
					(myGamma.callGamma((dof+1)/2))/(
					(Math.pow(dof*Math.PI, (double) 0.5))*(myGamma.callGamma(dof/2)));
		return dblCoeff;
		}


		public double[] computeFxi(double[] dblExp, double dblCoeff, int num_seg) {
			double[] dblFxi = new double [num_seg+1];
			for (j=0;j<num_seg+1;j++) {
				dblFxi[j] = dblExp[j] * dblCoeff;
			}
			
			return dblFxi;
		}

		public double[] computeFinTerm(double w, int[] multipliers, double[] dblFxi, int num_seg) {
			double[] dblFinalTerms = new double [num_seg+1];
			for (j=0;j<num_seg+1;j++) {
				dblFinalTerms[j] = (w/3) * multipliers[j] * dblFxi[j];
			}
			
			return dblFinalTerms;
		}

		public double computeFinVal(double[] dblFinalTerms, int num_seg) {
			for (j=0;j<num_seg+1;j++) {
				dblFinalVal += dblFinalTerms[j];
			}
			System.out.println(dblFinalVal);
			return dblFinalVal;
		}
		
	}


