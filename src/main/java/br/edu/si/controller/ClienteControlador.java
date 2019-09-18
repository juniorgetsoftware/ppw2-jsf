package br.edu.si.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.si.model.Cliente;

@ManagedBean
@ViewScoped
public class ClienteControlador implements Serializable {

	@PostConstruct
	public void init() {
		String idString = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

		if (idString != null) {
			Long id = Long.parseLong(idString);
			int index = clientes.indexOf(new Cliente(id));
			cliente = clientes.get(index);
		}
	}

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

	public String editar() {
		int index = clientes.indexOf(cliente);
		clientes.set(index, cliente);
		cliente = new Cliente();
		return "clientes?faces-redirect=true";
	}

}
