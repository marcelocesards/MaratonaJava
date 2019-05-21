package br.com.maratonaJava.Aula177To180Java8Lambdas;

import br.com.maratonaJava.Carro;

public class ComparadorCarro {
	public static int comparePelaCor(Carro c1, Carro c2) {
		return c1.getCor().compareTo(c2.getCor());
	}
	
	public int comparePorAno(Carro c1, Carro c2) {
		return ((Integer)c1.getAno()).compareTo(c2.getAno());
	}
}
