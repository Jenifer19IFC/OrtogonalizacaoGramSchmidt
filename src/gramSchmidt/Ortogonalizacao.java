package gramSchmidt;

public class Ortogonalizacao {
	
	public double produtoEscalar(double[] vet1, double[] vet2) {
		double soma = 0;
		
		soma = (vet1[0] * vet2[0]) + (vet1[1] * vet2[1]) + (vet1[2] * vet2[2]);
		
		return soma;
	}
	
	//Porduto interno de todos = 0.
	public boolean saoOrtogonais(double vet1[], double vet2[]) {
		int aux = 3;
		if(produtoEscalar(vet1, vet2) == 0) {
			return true;
		}
		return false;
	}
	
	public double norma(double vet1[]) {
		double norma = 0;
		
		norma = (Math.sqrt((vet1[0] * vet1[0]) + (vet1[1] * vet1[1]) + (vet1[2] * vet1[2])));
		
		return norma;
	}
	
	public boolean vetoresUnitarios(double vet1[]) {
		if(norma(vet1) == 1) {
			return true;
		}
		return false;
	}
	
	public double[] projecao(double vet1[], double vet2[]) {
		
		double[] proj = new double[3];
		
		double prodE = produtoEscalar(vet1, vet2);
		double norma = norma(vet2);
		double normaAoQuadrado = norma * norma;
		double resultado1 =  prodE/normaAoQuadrado;
		
		for (int i = 0; i < proj.length; i++) {
			proj[i] = resultado1 * vet2[i];
		}
		
		return proj;
	}
	
	public boolean aBaseEOrtonormal(double vet1[], double vet2[], double vet3[]) {
		if(saoOrtogonais(vet1, vet2) && saoOrtogonais(vet1, vet3) && saoOrtogonais(vet2, vet3)) {
			if(vetoresUnitarios(vet1) && vetoresUnitarios(vet2) && vetoresUnitarios(vet3)) {
				return true;
			}
		}
		return false;
	}
	
	public void ortonormalizacaoGramSchmidt(double vet1[], double vet2[], double vet3[]) {
		
			double x1[] = new double[3];
			double x2[] = new double[3];
			double x3[] = new double[3];
			
			// x1 = u1
			for (int i = 0; i < x1.length; i++) {
				x1[i] = vet1[i];
			}
			System.out.println("\n");
			/*for (int i = 0; i < x1.length; i++) {
				System.out.println("X1 = "+ x1[i] + " ");
			}*/
			
			//x2 = v2 - proj u2 por x1
			double projecao[] = projecao(vet2,x1);
				
			for (int i = 0; i < x2.length; i++) {
				x2[i] = vet2[i] - projecao[i];
			}
			System.out.println();
			/*for (int i = 0; i < x2.length; i++) {
				System.out.println("X2 = " + x2[i] + " ");
			}*/
			
			double projV3sobreX1[] = new double[3];
			double projV3sobreX2[] = new double[3];
			
			projV3sobreX1 = projecao(vet3, x1);
			projV3sobreX2 = projecao(vet3, x2);
			
			for (int i = 0; i < x3.length; i++) {
				x3[i] = vet3[i] - projV3sobreX1[i] - projV3sobreX2[i];
			}
			System.out.println();
			
			/*for (int i = 0; i < x3.length; i++) {
				System.out.println("X3 = " + x3[i] + " ");
			}*/
			
			double u1[] = new double[3];
			double u2[] = new double[3];
			double u3[] = new double[3];
			
			double normaX1 = norma(x1);
			double normaX2 =  norma(x2);;
			double normaX3 =  norma(x3);;
			
			for (int i = 0; i < u1.length; i++) {
				u1[i] = x1[i] / normaX1;
			}
			for (int i = 0; i < u2.length; i++) {
				u2[i] = x2[i] / normaX2;
			}
			for (int i = 0; i < u3.length; i++) {
				u3[i] = x3[i] / normaX3;
			}
			
			System.out.println("\n");
			
			for (int i = 0; i < u1.length; i++) {
				System.out.print("U1 = " + Math.round((u1[i])*100.0)/100.0 + " , ");
			}	
			System.out.println("\n");
			
			for (int i = 0; i < u2.length; i++) {
				System.out.print("U2 = " + Math.round((u2[i])*100.0)/100.0 + " , ");
			}	
			System.out.println("\n");
			
			
			for (int i = 0; i < u3.length; i++) {
				System.out.print("U3 = " + Math.round((u3[i])*100.0)/100.0 + " , ");
			}	
	}

}
