package br.edu.si.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.si.jsf.FacesUtil;
import br.edu.si.model.Cliente;

@ManagedBean
@ViewScoped
public class ClienteControlador implements Serializable {

	private static final long serialVersionUID = -2437633336322408321L;

	private Long idCliente;
	private Cliente cliente = new Cliente();
	private static List<Cliente> clientes = new ArrayList<>();

	public void prepararParaEditar() {
		if (idCliente != null) {
			int index = clientes.indexOf(new Cliente(idCliente));
			cliente = clientes.get(index);
		}
	}

	public String[] estados() {
		return new String[] { "CE", "SP", "RN", "RJ" };
	}

	public void cadastrar() {
		clientes.add(cliente);
		FacesUtil.addMensagem().info("Cadastrado com sucesso!").para("msg");
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
		FacesUtil.addMensagem().warn("Excluído com sucesso!").para("msg");
		cliente = new Cliente();
	}

	public String editar() {
		int index = clientes.indexOf(cliente);
		clientes.set(index, cliente);
		FacesUtil.addMensagem().info("Editado com sucesso!").para("msg").mantendoMensagemAposRedirect();
		cliente = new Cliente();
		return "clientes?faces-redirect=true";
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

}
