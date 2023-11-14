import java.util.ArrayList;
import java.util.List;

public class Disciplina {
	private String nome;
	private String CH;
	private Professor professor;
	private List<Aluno> alunos;
	
	public Disciplina(String nome, String CH, Professor professor) {
        this.nome = nome;
        this.CH = CH;
        this.professor = professor;
        alunos = new ArrayList<Aluno>();
    }

	public String get_nome() {
		return nome;
	}
	public void set_nome(String nome) {
		this.nome = nome;
	}

	public String get_ch() {
		return CH;
	}
	public void set_ch(String cH) {
		CH = cH;
	}

	public Professor get_professor() {
		return professor;
	}
	public void set_professor(Professor professor) {
		this.professor = professor;
	}
	
	public List<Aluno> get_alunos() {
		return alunos;
	}
	public void set_alunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public void imprimir () {
		System.out.println("Nome da disciplina: " + this.nome);
		System.out.println("CH: " + this.CH);
		System.out.println("Professor: " + this.get_professor().get_nome());
		System.out.println("Titulacao do professor: " + this.get_professor().get_titulacao());
				
		if (alunos.isEmpty()) {
			System.out.println("Essa disciplinas não possui alunos matriculados!");
		} else {
			System.out.println("Alunos da disciplina: ");
			for(Aluno aluno : alunos) {
				System.out.println("Nome do aluno: " + aluno.get_nome());
				System.out.println("Numero da matricula: " + aluno.get_matricula());
				System.out.println("----------------\n");
			}
		}
	}
}
