package com.aula.aluno;

public class Aluno {
	private int id;
	private String nome;
	private String ra;
	
	public Aluno(int id, String nome, String ra) {
		this.id = id;
		this.nome = nome;
		this.ra = ra;
	}
	
	public Aluno(String nome, String ra) {
		this.nome = nome;
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public int getId() {
		return id;
	}
	
}
