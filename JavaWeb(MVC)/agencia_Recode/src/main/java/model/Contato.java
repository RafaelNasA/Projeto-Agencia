package model;

public class Contato {
	private int id;
	private String nome;
	private String email;
	private String assunto;
	private String conteudo;
	
	public Contato(int id, String nome, String email, String assunto, String conteudo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.assunto = assunto;
		this.conteudo = conteudo;
	}
	
	public Contato() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
}
