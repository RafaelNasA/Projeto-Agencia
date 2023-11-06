package model;

import model.Usuario;

public class Destino {
	private int id;
	private Usuario usuario;
	private String origem;
	private String destino;
	private String dataIda;
	private String dataVolta;
	private int qtdQuartos;
	
	public Destino(int id, Usuario usuario, String origem, String destino, String dataIda, String dataVolta,
			int qtdQuartos) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.origem = origem;
		this.destino = destino;
		this.dataIda = dataIda;
		this.dataVolta = dataVolta;
		this.qtdQuartos = qtdQuartos;
	}
	
	public Destino() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getDataIda() {
		return dataIda;
	}

	public void setDataIda(String dataIda) {
		this.dataIda = dataIda;
	}

	public String getDataVolta() {
		return dataVolta;
	}

	public void setDataVolta(String dataVolta) {
		this.dataVolta = dataVolta;
	}

	public int getQtdQuartos() {
		return qtdQuartos;
	}

	public void setQtdQuartos(int qtdQuartos) {
		this.qtdQuartos = qtdQuartos;
	}
	
	
}
