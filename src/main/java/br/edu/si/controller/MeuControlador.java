package br.edu.si.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.si.model.Cliente;

@ManagedBean(name = "meuControlador")
@ViewScoped
public class MeuControlador {

	private Cliente cliente = new Cliente();
	private static List<Cliente> clientes = new ArrayList<>();

	public String[] estados() {
		return new String[] { "CE", "SP", "RN", "RJ" };
	}

	public void cadastrar() {
		clientes.add(cliente);
		cliente = new Cliente();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> clientes() {
		return clientes;
	}

	public void excluir() {
		clientes.remove(cliente);
		cliente = new Cliente();
	}

	public void editar() {
		int index = clientes.indexOf(cliente);
		clientes.set(index, cliente);
		cliente = new Cliente();
	}

}
