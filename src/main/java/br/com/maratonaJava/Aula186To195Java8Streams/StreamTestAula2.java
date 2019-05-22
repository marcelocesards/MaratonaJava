package br.com.maratonaJava.Aula186To195Java8Streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.maratonaJava.Pessoa;

public class StreamTestAula2 {
	// Pegar os tres primeiros nomes das pessoas com menos de 25 anos
	// ordenados por nome
	public static void main(String[] args) {

		List<Pessoa> pessoas = Pessoa.bancoDePessoas();

		/*
		 * Intermediates: filter, sorted, map, limit, distinct
		 * Terminal: collect, count, forEach
		 */
		List<String> nomes = pessoas.stream()
				.filter(i -> i.getIdade() < 25)
				.sorted(Comparator.comparing(Pessoa::getNome))
				.limit(3)
				.map(Pessoa::getNome)
				.collect(Collectors.toList());

		System.out.println(nomes);
		
		System.out.println(
				 pessoas.stream()
						.filter(i -> i.getIdade() < 25)
						.map(Pessoa::getNome)
						.count()
				);
	
		pessoas.stream().map(Pessoa::getNome).forEach(System.out::println);
	}
}
