package br.com.maratonaJava.Aula177Java8ComportamentoPorParametro;

public class Carro {
	private String nome = "Gol";
	private String cor;
	private int ano;

	public Carro(String nome, String cor, int ano) {
		super();
		this.nome = nome;
		this.cor = cor;
		this.ano = ano;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "carro [nome=" + nome + ", cor=" + cor + ", ano=" + ano + "]";
	}

}
