package br.com.maratonaJava.factory;

import java.util.Arrays;
import java.util.List;

import br.com.maratonaJava.Carro;

public class CarroFactory {
	public static Carro createCarroFake() {
		return new Carro("corvete", "verde", 2000);
	}

	public static List<Carro> createCarroFakeList() {
		return Arrays.asList(new Carro("corvete", "verde", 2000), new Carro("fusca", "roxo", 1985),
				new Carro("hb20", "prata", 2019));
	}
}
