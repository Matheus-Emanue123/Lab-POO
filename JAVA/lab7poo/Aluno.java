import java.util.ArrayList;
import java.util.List;


public class Aluno extends Pessoa {

	private int matricula;
	private List<Disciplina> disciplinas; 

	public Aluno(String contato, String cpf, String endereco, String nome, String rg, int matricula) {
		super(contato, cpf, endereco, nome, rg);

		this.matricula = matricula;
		disciplinas = new ArrayList<Disciplina>();

	}	
	
	public int get_matricula() {
		return matricula;
	}
	public void set_matricula(int matricula) {
		this.matricula = matricula;
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
		System.out.println("Numero de matricula: " + this.matricula + "\n");

		if(disciplinas.isEmpty()) {
			System.out.println("Esse aluno nao esta cadastrado em nenhuma disciplina!"); 
		} else {
			System.out.println("Disciplinas: ");
			for(Disciplina disciplina : disciplinas) {
				System.out.println("Nome da disciplina: " + disciplina.get_nome());
				System.out.println("CH: " + disciplina.get_ch());
				System.out.println("Professor: " + disciplina.get_professor().get_nome());
				System.out.println("----------------\n");
			}
		}
		
	}	
}