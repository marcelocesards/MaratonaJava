package br.com.maratonaJava.Aula177Java8ComportamentoPorParametro.strategias;

import br.com.maratonaJava.Aula177Java8ComportamentoPorParametro.Carro;

public interface CarroPredicate {
	boolean test(Carro carro);	
}
