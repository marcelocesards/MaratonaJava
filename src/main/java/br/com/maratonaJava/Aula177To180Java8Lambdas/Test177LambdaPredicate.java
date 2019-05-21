package br.com.maratonaJava.Aula177To180Java8Lambdas;

import br.com.maratonaJava.Carro;
import br.com.maratonaJava.Aula176Java8ComportamentoPorParametro.strategias.CarroPredicate;
import br.com.maratonaJava.factory.CarroFactory;

public class Test177LambdaPredicate {
	public static void main(String[] args) {
		Carro carro = CarroFactory.createCarroFake();
		CarroPredicate carroPredicate = new CarroPredicate() {
			@Override
			public boolean test(Carro carro) {
				return carro.getCor().equals("verde");
			}
		};
		CarroPredicate carroPredicateLambda = (Carro c) -> c.getCor().equals("verde");
		System.out.println(carroPredicate.test(carro));
		System.out.println(carroPredicateLambda.test(carro));
		//Outro exemplo com runnable
		
		Runnable runnable = () -> System.out.println("dentro do run");
		new Thread(runnable).start();
	}
}
