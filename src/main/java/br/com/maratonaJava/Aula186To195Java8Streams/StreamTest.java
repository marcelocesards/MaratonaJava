package br.com.maratonaJava.Aula186To195Java8Streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.maratonaJava.Pessoa;

public class StreamTest {
	// Pegar os tres primeiros nomes das pessoas com menos de 25 anos
	// ordenados por nome
	public static void main(String[] args) {

		java7();
		
		java8();
	}
	
	private static void java8() {
		List<Pessoa> pessoas = Pessoa.bancoDePessoas();

		//pessoas.sort((pessoa1, pessoa2) -> pessoa1.getNome().compareTo(pessoa2.getNome()));

		List<String> nomes = pessoas
			.stream()
			.filter(i -> i.getIdade() < 25)
			.sorted(Comparator.comparing(Pessoa::getNome))
			.limit(3)
			.map(Pessoa::getNome)
			.collect(Collectors.toList());
		
		System.out.println(nomes);
	}

	private static void java7() {
		List<Pessoa> pessoas = Pessoa.bancoDePessoas();

		ordenarPorNome(pessoas);

		List<String> nomesPessoasMenoresDe25 = selecionaTresMenores25(pessoas);
		
		System.out.println(nomesPessoasMenoresDe25);
	}

	private static List<String> selecionaTresMenores25(List<Pessoa> pessoas) {
		List<String> nomes = new ArrayList<String>();
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getIdade() < 25)
				nomes.add(pessoa.getNome());
			if (nomes.size() >= 3)
				break;
		}
		return nomes;
	}

	private static void ordenarPorNome(List<Pessoa> pessoas) {
		Collections.sort(pessoas, new Comparator<Pessoa>() {
			@Override
			public int compare(Pessoa arg0, Pessoa arg1) {
				return arg0.getNome().compareTo(arg1.getNome());
			}

		});
	}
}
