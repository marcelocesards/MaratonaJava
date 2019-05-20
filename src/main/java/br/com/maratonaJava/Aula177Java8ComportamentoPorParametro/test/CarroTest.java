package br.com.maratonaJava.Aula177Java8ComportamentoPorParametro.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import br.com.maratonaJava.Aula177Java8ComportamentoPorParametro.Carro;
import br.com.maratonaJava.Aula177Java8ComportamentoPorParametro.strategias.CarroCorVerdePredicate;
import br.com.maratonaJava.Aula177Java8ComportamentoPorParametro.strategias.CarroPredicate;

public class CarroTest {
	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<Carro> carros = Arrays.asList(createCarro("porche", "verde", 2011),
				createCarro("porche", "vermelho", 1995), createCarro("porche", "preto", 2017));

		System.out.println(filtrarCarroVerde(carros));
		System.out.println(filtrarCarroPorCor(carros, "vermelho"));
		System.out.println(filtrarCarros(carros, new CarroCorVerdePredicate()));

		System.out.println(filtrarCarros(carros, carro -> carro.getAno() < 2000));
		System.out.println(filtrar(carros, carro -> carro.getAno() < 2000));
		System.out.println(filtrar(numeros, numero -> numero > 5));
		System.out.println(filtrar(numeros, new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				// TODO Auto-generated method stub
				return t % 2 == 0;
			}
		}));
	}

	private static Carro createCarro(String string, String string2, int i) {
		return new Carro(string, string2, i);
	}

	private static List<Carro> filtrarCarroVerde(List<Carro> carros) {
		List<Carro> result = new ArrayList<>();
		for (Carro carro : carros) {
			if (carro.getCor().equals("verde"))
				result.add(carro);
		}
		return result;
	}

	private static List<Carro> filtrarCarroPorCor(List<Carro> carros, String cor) {
		List<Carro> result = new ArrayList<>();
		for (Carro carro : carros) {
			if (carro.getCor().equals(cor))
				result.add(carro);
		}
		return result;
	}

	public static List<Carro> filtrarCarros(List<Carro> carros, CarroPredicate carroPredicate) {
		List<Carro> result = new ArrayList<>();
		for (Carro carro : carros)
			if (carroPredicate.test(carro))
				result.add(carro);
		return result;
	}
	
	public static <T> List<T> filtrar(List<T> objetos, Predicate<T> predicate) {
		List<T> result = new ArrayList<>();
		for (T objeto : objetos)
			if (predicate.test(objeto))
				result.add(objeto);
		return result;
	}
}
