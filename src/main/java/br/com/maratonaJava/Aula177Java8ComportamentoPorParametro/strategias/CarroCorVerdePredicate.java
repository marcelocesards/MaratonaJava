package br.com.maratonaJava.Aula177Java8ComportamentoPorParametro.strategias;

import br.com.maratonaJava.Aula177Java8ComportamentoPorParametro.Carro;

public class CarroCorVerdePredicate implements CarroPredicate{

	@Override
	public boolean test(Carro carro) {
		// TODO Auto-generated method stub
		return carro.getCor().equals("verde");
	}

}
