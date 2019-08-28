package br.edu.si.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "meuControlador")
public class MeuControlador {

	private String nome;
	private String logradouro;
	private String bairro;
	private String estado;

	public String[] estados() {
		return new String[] { "CE", "SP", "RN", "RJ" };
	}

	public void cadastrar() {
		System.out.println(nome);
		System.out.println(logradouro);
		System.out.println(bairro);
		System.out.println(estado);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
