import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa {

	private String titulacao;
	private String curso;
	private List<Disciplina> disciplinas;

	public Professor(String contato, String cpf, String endereco, String nome, String rg, String titulacao, String curso) {
		super(contato, cpf, endereco, nome, rg);

		this.titulacao = titulacao;
		this.curso = curso;

		disciplinas = new ArrayList<Disciplina> ();
	}
	
	public String get_titulacao() {
		return titulacao;
	}
	public void set_titulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	public String get_curso() {
		return curso;
	}
	public void set_curso(String curso) {
		this.curso = curso;
	}
	
	public List<Disciplina> get_disciplinas() {
		return disciplinas;
	}
	public void set_disciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	@Override
	public void imprimir() {
		super.imprimir();
		System.out.println("Titulacao: " + this.titulacao);
		System.out.println("Curso: " + this.curso + "\n");
		
		if(disciplinas.isEmpty()) {
			System.out.println("Este professor não ministra nenhuma disciplina!"); 
		} else {
			System.out.println("Disciplinas: ");
			for(Disciplina disciplina : disciplinas) {
				System.out.println("Nome da disciplina: " + disciplina.get_nome());
				System.out.println("CH: " + disciplina.get_ch());
				System.out.println("----------------\n");
			}
		}	
	}
}
