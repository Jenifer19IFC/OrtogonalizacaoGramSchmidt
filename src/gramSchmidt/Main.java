package gramSchmidt;

import java.util.Scanner;

public class Main {

public static void main(String[] args) {
		
	Scanner input = new Scanner(System.in);
	
	Ortogonalizacao orto = new Ortogonalizacao();
	
	double u[] = new double[3];
	double v[] = new double[3];
	double w[] = new double[3];
	
	System.out.println("ELEMENTOS DO VETOR u:\n");
	
	for (int i = 0; i < u.length; i++) {
		System.out.println("Digite o elemento na posição " + i);
		u[i] = input.nextDouble();
	}
	
	System.out.println("ELEMENTOS DO VETOR v:\n");
	
	for (int i = 0; i < v.length; i++) {
		System.out.println("Digite o elemento na posição " + i);
		v[i] = input.nextDouble();
	}
	
	System.out.println("ELEMENTOS DO VETOR w:\n");
	
	for (int i = 0; i < w.length; i++) {
		System.out.println("Digite o elemento na posição " + i);
		w[i] = input.nextDouble();
	}
	
	System.out.println("VETOR u:");
	for (int i = 0; i < u.length; i++) {
		System.out.print(u[i] + " , ");
	}
	System.out.println("\n");
	System.out.println("VETOR v:");
	for (int i = 0; i < v.length; i++) {
		System.out.print(v[i] + " , ");
	}
	System.out.println("\n");
	System.out.println("VETOR w:");
	for (int i = 0; i < w.length; i++) {
		System.out.print(w[i] + " , ");
	}
	System.out.println("\n");
	
	System.out.println("Produto escalar de <u,v> = " + orto.produtoEscalar(u, v) + "\n");
	System.out.println("Produto escalar de <v,w> = " + orto.produtoEscalar(v, w) + "\n");
	System.out.println("Produto escalar de <u,w> = " + orto.produtoEscalar(u, w) + "\n");
	
	System.out.println("São duplas ortogonais:\n");
	
	if(orto.saoOrtogonais(u, v)) {
		for (int i = 0; i < u.length; i++) {
			System.out.print(u[i] + " , ");
		}
		System.out.print(" e  ");
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i] + " , ");
		}
	}
	System.out.println("\n");
	
	if(orto.saoOrtogonais(v, w)) {
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i] + " , ");
		}
		System.out.print(" e  ");
		for (int i = 0; i < w.length; i++) {
			System.out.print(w[i] + " , ");
		}
	}
	System.out.println("\n");
	
	if(orto.saoOrtogonais(u, w)) {
		for (int i = 0; i < u.length; i++) {
			System.out.print(u[i] + " , ");
		}
		System.out.print(" e  ");
		for (int i = 0; i < w.length; i++) {
			System.out.print(w[i] + " , ");
		}
	}
	
	System.out.println("\n");
	
	
	System.out.println("Norma de u = " + Math.round((orto.norma(u))*100.0)/100.0 + "\n");
	System.out.println("Norma de v = " +Math.round((orto.norma(v))*100.0)/100.0 + "\n");
	System.out.println("Norma de w = " + Math.round((orto.norma(w))*100.0)/100.0 + "\n");
	
	System.out.println("São vetores unitários:\n");
	
	if(orto.vetoresUnitarios(u)) {
		for (int i = 0; i < u.length; i++) {
			System.out.print(u[i] + " , ");
		}
	}
	System.out.println("\n");
	if(orto.vetoresUnitarios(v)) {
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i] + " , ");
		}
	}
	System.out.println("\n");
	if(orto.vetoresUnitarios(w)) {
		for (int i = 0; i < w.length; i++) {
			System.out.print(w[i] + " , ");
		}
	}
	System.out.println("\n");
	
	System.out.println("-- Projeções -- \n");
	
	System.out.print("Projeção de v em u --> ");
	double vetorProjecaoVU[] = orto.projecao(v, u);
	for (int i = 0; i < vetorProjecaoVU.length; i++) {
		System.out.print(Math.round((vetorProjecaoVU[i])*100.0)/100.0 + " , ");
	}
	System.out.println("\n");
	System.out.print("Projeção de w em u --> ");
	double vetorProjecaoWU[] = orto.projecao(w, u);
	for (int i = 0; i < vetorProjecaoWU.length; i++) {
		System.out.print(Math.round((vetorProjecaoWU[i])*100.0)/100.0 + " , ");
	}
	System.out.println("\n");
	System.out.print("Projeção de w em v --> ");
	double vetorProjecaoWV[] = orto.projecao(w, v);
	for (int i = 0; i < vetorProjecaoWV.length; i++) {
		System.out.print(Math.round((vetorProjecaoWV[i])*100.0)/100.0 + " , ");
	}
	System.out.println("\n");
	
	//Verifica se a base é ortonormal
	if(orto.aBaseEOrtonormal(u, v, w)) {
		System.out.println("A base é ortonormal!\n");
	}else {
		System.out.println("A base não é ortonormal!\n"
				+ " Agora, aplicando o algoritmo de ortonormalização de Gram-Schmidt...");
		System.out.println("\nA BASE ORTONORMAL É: ");
		orto.ortonormalizacaoGramSchmidt(u, v, w);
		
	}
	
	
	
	
	
	
	}
}
