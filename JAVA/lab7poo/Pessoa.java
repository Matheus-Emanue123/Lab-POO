public class Pessoa {
	
	String contato; 
	String cpf;
	String endereco;
	String nome;  
	String rg; 

	public Pessoa (String contato, String cpf, String endereco, String nome, String rg) {

		this.contato = contato;
		this.cpf = cpf;
		this.endereco = endereco;
		this.nome = nome;
		this.rg = rg;
	}

	public String get_contato() {
		return contato;
	}
	public void set_contato(String contato) {
		this.contato = contato;
	}

	public String get_cpf() {
		return cpf;
	}
	public void set_cpf(String cpf) {
		this.cpf = cpf;
	}

	public String get_endereco() {
		return endereco;
	}
	public void set_endereco(String endereco) {
		this.endereco = endereco;
	}

	public String get_nome() {
		return nome;
	}
	public void set_nome(String nome) {
		this.nome = nome;
	}

	public String get_rg() {
		return rg;
	}
	public void set_rg(String rg) {
		this.rg = rg;
	}
	
	public void imprimir() {
		System.out.println("Nome: " + this.nome);
		System.out.println("Endereco: " + this.endereco);
		System.out.println("CPF: " + this.cpf);
		System.out.println("contato: " + this.contato);
		System.out.println("rg: " + this.rg);
	}
}
