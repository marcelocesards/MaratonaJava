package br.com.maratonaJava.Aula177To180Java8Lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;

public class Test178LambdaConsumer {

	public static void main(String[] args) {
		List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<String> pessoas = Arrays.asList("William", "TesteStrings", "Mais alguma coisa");
		printAll(pessoas, s -> System.out.println(s));
		printAll(asList, System.out::println);
		printAllNumbers(asList, System.out::println);

		List<Integer> list = map(pessoas, new Function<String, Integer>() {

			@Override
			public Integer apply(String t) {
				return t.length();
			}

		});
		System.out.println(list);
		list = map(pessoas, s -> s.length());
		System.out.println(list);
		list = map(pessoas, String::length);
		System.out.println(list);
	}

	private static <T> void printAll(List<T> asList, Consumer<T> consumer) {
		// asList.forEach(s -> consumer.accept(s));
		asList.forEach(consumer::accept);
	}

	private static void printAllNumbers(List<Integer> asList, IntConsumer consumer) {
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
