package br.com.maratonaJava.factory;

import br.com.maratonaJava.Carro;

public class CarroFactory {
	public static Carro createCarroFake() {
		return new Carro("corvete", "verde", 2000);
	}
}
