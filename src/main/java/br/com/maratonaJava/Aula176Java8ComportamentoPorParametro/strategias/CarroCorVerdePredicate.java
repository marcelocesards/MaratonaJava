package br.com.maratonaJava.Aula176Java8ComportamentoPorParametro.strategias;

import br.com.maratonaJava.Carro;

public class CarroCorVerdePredicate implements CarroPredicate{

	@Override
	public boolean test(Carro carro) {
		// TODO Auto-generated method stub
		return carro.getCor().equals("verde");
	}

}
