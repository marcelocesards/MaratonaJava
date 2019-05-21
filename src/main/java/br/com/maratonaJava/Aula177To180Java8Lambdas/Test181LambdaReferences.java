package br.com.maratonaJava.Aula177To180Java8Lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import br.com.maratonaJava.Carro;
import br.com.maratonaJava.factory.CarroFactory;

public class Test181LambdaReferences {

	public static void main(String[] args) {
		List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<String> pessoas = Arrays.asList("William", "TesteStrings", "Mais alguma coisa");
		printAll(pessoas, s -> System.out.println(s));

		List<Carro> carros = CarroFactory.createCarroFakeList();
		System.out.println(carros);
		Collections.sort(carros, (c1, c2) -> c1.getCor().compareTo(c2.getCor()));
		System.out.println(carros);
		//Como naõ é possível aplicar references para o método acima, vamos usar o comparador carro
		//para fazer essa comparação.
		carros = CarroFactory.createCarroFakeList();
		System.out.println(carros);
		
		//referenca a um método estatico.
		Collections.sort(carros, ComparadorCarro::comparePelaCor);
		System.out.println(carros);
		
		//referencia para método de instancia
		//reference to an instance method of a particular object
		ComparadorCarro comparador = new ComparadorCarro();
		carros = CarroFactory.createCarroFakeList();
		System.out.println(carros);
		Collections.sort(carros, comparador::comparePorAno);
		System.out.println("por ano: "+carros);
		
		//reference to an instance method of an arbitrary object of a particular type
		pessoas.sort((p1, p2) -> p1.compareTo(p2));
		pessoas = Arrays.asList("b", "a", "d", "c");
		pessoas.sort(String::compareTo);
		System.out.println(pessoas);
		
		Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
		Function<String, Integer> stringToInteger2 = Integer::parseInt;
		System.out.println(stringToInteger2.apply("10"));
		
		BiPredicate<List<String>, String> contains = (lista, elemento) -> lista.contains(elemento);
		BiPredicate<List<String>, String> contains2 = List::contains;
		
		System.out.println(contains2.test(pessoas, "b"));
		
		//Construtores
		Supplier<ComparadorCarro> comparadorCarro = ComparadorCarro::new;
		System.out.println(comparadorCarro.get());
		
		CarroFunction carroFunction = (n, c, a) -> new Carro(n, c, a);
		Carro carro = carroFunction.apply("marine", "vinho", 1999);
		System.out.println(carro);
		
		CarroFunction carroFunction2 = Carro::new;
		Carro carro2 = carroFunction2.apply("Sub", "prata", 2014);
		System.out.println(carro2);
	}

	private static <T> void printAll(List<T> asList, Consumer<T> consumer) {
		// asList.forEach(s -> consumer.accept(s));
		asList.forEach(consumer::accept);
	}

	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> result = new ArrayList<>();
		for (T e : list)
			result.add(f.apply(e));
		return result;
	}
	
}

interface CarroFunction{
	Carro apply(String nome, String cor, int ano);
}
