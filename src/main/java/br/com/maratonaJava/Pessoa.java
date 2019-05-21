package br.com.maratonaJava;

import java.util.Arrays;
import java.util.List;

public class Pessoa {
	private String nome;
	private int idade;
	private double salario;
	public Pessoa(String nome, int idade, double salario) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.salario = salario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public static List<Pessoa> bancoDePessoas(){
		return Arrays.asList(
				new Pessoa("William Suane", 22, 2000),
				new Pessoa("Mercy", 28, 3500),
				new Pessoa("Ana", 19, 8000),
				new Pessoa("Thor", 23, 15000),
				new Pessoa("Hulk", 35, 7800),
				new Pessoa("Flash", 29, 3500),
				new Pessoa("Batman", 37, 4900),
				new Pessoa("Lanterna Verde", 24, 6600)
				);
	}
}
