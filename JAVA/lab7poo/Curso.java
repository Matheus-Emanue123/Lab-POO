import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Curso {
	Scanner scanner = new Scanner (System.in);

	private String nome;

	List<Professor> professores;
	List<Aluno> alunos;
	List<Disciplina> disciplinas;
	
	public Curso (String nome) {

		this.nome = nome;
		professores = new ArrayList<Professor> ();
		alunos = new ArrayList<Aluno> ();
		disciplinas = new ArrayList<Disciplina> ();
	}

	public String get_nome() {
		return nome;
	}
	public void set_nome(String nome) {
		this.nome = nome;
	}

	public List<Professor> get_professores() {
		return professores;
	}
	public void set_professores(List<Professor> professores) {
		this.professores = professores;
	}

	public List<Aluno> get_alunos() {
		return alunos;
	}
	public void set_alunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Disciplina> get_disciplinas() {
		return disciplinas;
	}
	public void set_disciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public Pessoa cadastrar_pessoa (Scanner scanner) {

		System.out.print("Digite o nome da pessoa: ");
		String nome = scanner.nextLine();
		
		System.out.print("Digite o endereço da pessoa: ");
		String endereco = scanner.nextLine();
		
		System.out.print("Digite o CPF da pessoa: ");
		String cpf = scanner.nextLine();
		
		System.out.print("Digite o contato da pessoa: ");
		String contato = scanner.nextLine();
		
		System.out.print("Digite o número do rg da pessoa: ");
		String rg= scanner.nextLine();
		
		Pessoa pessoa = new Pessoa(contato, cpf, endereco, nome, rg);
		return pessoa;
	}
	
	public void cadastrar_professor(Scanner scanner) {

		Pessoa pessoa = cadastrar_pessoa(scanner);
		
		System.out.print("Digite a titulação do professor: ");
		String titulacao = scanner.nextLine();
		
		System.out.print("Digite o curso que o professor vai ser cadastrado: ");
		String curso = scanner.nextLine();
		
		Professor professor = new Professor(pessoa.get_contato(),
		                                    pessoa.get_cpf(),
		                                    pessoa.get_endereco(), 
		                                    pessoa.get_nome(),
											pessoa.get_rg(), 
											titulacao,
											curso);
		professores.add(professor);
		
		System.out.println("Professor cadastrado com sucesso!");
	}
	
	public void cadastrar_aluno(Scanner scanner) {
		Pessoa pessoa = cadastrar_pessoa(scanner);
		
		System.out.print("Digite a matricula do aluno que será cadstrado neste curso: ");
		int matricula = scanner.nextInt();
		scanner.nextLine();	
		
		Aluno aluno = new Aluno(pessoa.get_contato(),
		                        pessoa.get_cpf(),
		                        pessoa.get_endereco(), 
		                        pessoa.get_nome(),
		                        pessoa.get_rg(), 
								matricula);
		alunos.add(aluno);
		
		System.out.println("Aluno cadastrado com sucesso!");
	}
	
	public void cadastrar_disciplina(Scanner scanner) {
		int resposta = 0;
		do {
			System.out.println(" 1 - Cadastrar um professor novo para a disciplina");
			System.out.println(" 0 - Cadastrar professor existente");
			resposta = scanner.nextInt();
			scanner.nextLine();
			
			if (resposta == 1) {
				cadastrar_professor(scanner);
			}
			
		} while (resposta != 0);
				
		System.out.print("Digite o nome da disciplina que será cadastrada neste curso: ");
		String nome = scanner.nextLine();
		
		System.out.print("Digite a carga horária da displina que será cadastrado neste curso: ");
		String CH = scanner.nextLine();
		
		System.out.print("Digite o nome do professor da disciplina que será cadastrado neste curso: ");
		String nome_professor = scanner.nextLine();
		
		System.out.print("Digite a titulação do professor da disciplina que será cadastrado neste curso: ");
		String titulacao = scanner.nextLine();
		
		Disciplina disciplina = null;
		
		boolean existe_p = false;
		for (Professor professor : professores) {
			if ((professor.get_nome().equals(nome_professor)) &&
				(professor.get_titulacao().equals(titulacao))) {
					existe_p = true; 

					disciplina = new Disciplina(nome, CH, professor);
					disciplinas.add(disciplina);
					professor.get_disciplinas().add(disciplina);
					
					System.out.println("Aluno cadastrado com sucesso!");
					break;
			}
		}
		
		if (!existe_p) System.out.println("Professor não cadastrado no sistema!\n");
	}
			
	public void cadastrar_aluno_disciplina (Scanner scanner) {
		int resposta = 0;
		do {
			System.out.println("Digite 1 -  Cadastrar novo aluno");
			System.out.println("Digite 0 -  Cadastrar aluno existente");
			resposta = scanner.nextInt();
			scanner.nextLine();
			
			if (resposta == 1) {
				cadastrar_aluno(scanner);
			}
			
		} while (resposta != 0);
					
		System.out.print("Digite a matricula do aluno: ");
		int matricula = scanner.nextInt();
		scanner.nextLine();
		
		do {

			System.out.println("Digite 1 -  Cadastrar nova disciplina");
			System.out.println("Digite 0 -  Cadastrar com uma disciplina existente");
			resposta = scanner.nextInt();
			scanner.nextLine();
			
			if (resposta == 1) {
				cadastrar_disciplina(scanner);
			}
			
		} while (resposta != 0);
					
		System.out.print("Digite o nome da disciplina: ");
		String nome_disciplina = scanner.nextLine();
		
		System.out.print("Digite o nome do professor da disciplina: ");
		String nome_professor = scanner.nextLine();		
			
		boolean existe_a = false;
		boolean existe_d = false;
		
		for (Aluno aluno : alunos) {
			if(aluno.get_matricula() == matricula) {
				existe_a = true;
				for(Disciplina disciplina : disciplinas) {
					if ((disciplina.get_nome().equals(nome_disciplina)) && 
						(disciplina.get_professor().get_nome().equals(nome_professor))) {
						existe_d =true;
						disciplina.get_alunos().add(aluno);
						System.out.println("Aluno cadastrado com sucesso!");
						break;
					} 
				}
			} 
		}
		
		if (!existe_d) System.out.println("Disciplina não cadastrada no sistema!");
		if (!existe_a) System.out.println("Aluno não cadastrado no sistema!");
		
	}

	public void excluir_professor(Scanner scanner)  {
		System.out.println("Digite o nome do professor: ");
		String nome_professor = scanner.nextLine();
		
		System.out.println("Digite a titulação do professor: ");
		String titulacao = scanner.nextLine();
		
		boolean existe_p = false;
		for (Professor professor : professores) {
			if ((professor.get_nome().equals(nome_professor)) &&
				(professor.get_titulacao().equals(titulacao))) {
					existe_p = true; 
					professores.remove(professor);
					
					if (!professor.get_disciplinas().isEmpty()) 
						System.out.println("Para poder excluir um professor que esta cadastrado em uma disciplina, " +
										   "é necessario trocar o professor da disciplina!");
					while(!professor.get_disciplinas().isEmpty()) {
						trocar_p(scanner);
					}
					
					System.out.println("Professor excluido com sucesso!");
					break;
			}
		}
		
		if (!existe_p) System.out.println("Professor nao encontrado, tente cadastrá-lo!\n");	
	}
	
	public void excluir_aluno(Scanner scanner)  {
		System.out.print("Digite a matricula do aluno: ");
		int matricula = scanner.nextInt();
		scanner.nextLine();
		
		boolean existe_a = false;
		
		for (Aluno aluno : alunos) {
			if(aluno.get_matricula() == matricula) {
				existe_a = true;
				alunos.remove(aluno);
				
				for(Disciplina disciplina : aluno.get_disciplinas()) {
					disciplina.get_alunos().remove(aluno);
				}
				
				System.out.println("Aluno jubilado com sucesso!");
				break;
			} 
		}
		
		if (!existe_a) System.out.println("Aluno não encontrado no sistema!");
	}
	
	public void excluir_disciplina(Scanner scanner)  {
		System.out.println("Digite o nome da disciplina: ");
		String nome_disciplina = scanner.nextLine();
		
		System.out.println("Digite o nome do professor dessa disciplina: ");
		String nome_professor = scanner.nextLine();
		
		System.out.println("Digite a titulação do professor dessa disciplina: ");
		String titulacao = scanner.nextLine();
		
		boolean existe_d = false;
		
		for(Disciplina disciplina : disciplinas) {
			if((disciplina.get_nome().equals(nome_disciplina)) &&
			   (disciplina.get_professor().get_nome().equals(nome_professor)) && 
			   (disciplina.get_professor().get_titulacao().equals(titulacao)) ) {
				existe_d = true;
				
				disciplinas.remove(disciplina);
				
				for (Aluno aluno : alunos) {
					aluno.get_disciplinas().remove(disciplina);
				}
				
				for (Professor professor : professores) {
					professor.get_disciplinas().remove(disciplina);
				}	
				
				System.out.println("Disciplina excluida com sucesso!");
				break;
			}
		}
		
		if (!existe_d) System.out.println("Disciplina não cadastrada no sistema!");
	}

	
	public void trocar_p(Scanner scanner) {

		int resposta = 0;

		do {
			System.out.println("Para trocar os professores, ambos devem estar cadastrados!");
			System.out.println(" 1 -  Cadastrar professor");
			System.out.println(" 0 -  Continuar com professores existentes");
			resposta = scanner.nextInt();
			scanner.nextLine();
			
			if (resposta == 1) {
				cadastrar_professor(scanner);
			}
			
		} while (resposta != 0);
					
		System.out.print("Digite o nome do atual professor: ");
		String nome_professorAtual = scanner.nextLine();
		
		System.out.print("Digite a titulacao do atual professor: ");
		String titulacaoAtual = scanner.nextLine();
		
		System.out.print("Digite o nome do novo professor: ");
		String nome_professorNovo = scanner.nextLine();
		
		System.out.print("Digite a titulacao do novo professor: ");
		String titulacaoNovo = scanner.nextLine();
		
		boolean existe_pAtual = false;
		boolean existe_pNovo = true;
		boolean existe_d = true;
		
		for (Professor professor : professores) {
			if ((professor.get_nome().equals(nome_professorAtual)) &&
				(professor.get_titulacao().equals(titulacaoAtual))) {
					existe_pAtual = true; 
					
					existe_pNovo = false;
					for (Professor professor1 : professores) {
						if ((professor1.get_nome().equals(nome_professorNovo)) &&
							(professor1.get_titulacao().equals(titulacaoNovo))) {
								existe_pNovo = true; 
								
								System.out.print("Digite o nome da disciplina: ");
								String nome_disciplina = scanner.nextLine();
								
								existe_d = false;
								for (Disciplina disciplina : disciplinas) {
									if((disciplina.get_nome().equals(nome_disciplina)) &&
									   (disciplina.get_professor().get_nome().equals(nome_professorAtual)) &&
									   (disciplina.get_professor().get_titulacao().equals(titulacaoAtual)) ) {
										existe_d = true;
										
										disciplina.set_professor(professor1);
										professor.get_disciplinas().remove(disciplina);
										
										System.out.println("Professor trocado com sucesso!");
										break;
									}
								}
								break;
						}
					}
					break;
			}
		}
		
		if(!existe_pAtual) System.out.println("Professor atual não cadastrado no sistema");
		if(!existe_pNovo) System.out.println("Professor novo não cadastrado no sistema");
		if(!existe_d) System.out.println("Disciplina não cadastrada no sistema");		
					
	}
	
	public void imprimir_p() {
		System.out.print("Digite o nome do professor: ");
		String nome_professor = scanner.nextLine();
		
		System.out.print("Digite a titulacao do professor: ");
		String titulacao = scanner.nextLine();
		
		boolean existe_p = false;
		for (Professor professor : professores) {
			if ((professor.get_nome().equals(nome_professor)) &&
				(professor.get_titulacao().equals(titulacao))) {
					existe_p = true; 
					professor.imprimir();
					break;
			}
		}
		
		if (!existe_p) System.out.println("Professor não cadastrado no sistema!\n");	
	}
	
	public void imprimir_a() {
		System.out.print("Digite a matricula do aluno: ");
		int matricula = scanner.nextInt();
		scanner.nextLine();
		
		boolean existe_a = false;
		
		for (Aluno aluno : alunos) {
			if(aluno.get_matricula() == matricula) {
				existe_a = true;
				aluno.imprimir();
				break;
			} 
		}
		
		if (!existe_a) System.out.println("Aluno não cadastrado no sistema!\n");
	}

	public void imprimir_d() {
		System.out.print("Digite o nome da disciplina: ");
		String nome_disciplina = scanner.nextLine();
		
		System.out.print("Digite o nome do professor dessa disciplina: ");
		String nome_professor = scanner.nextLine();
		
		System.out.print("Digite a titulacao do professor dessa disciplina: ");
		String titulacao = scanner.nextLine();
		
		boolean existe_d = false;
		
		for(Disciplina disciplina : disciplinas) {
			if((disciplina.get_nome().equals(nome_disciplina)) &&
			   (disciplina.get_professor().get_nome().equals(nome_professor)) && 
			   (disciplina.get_professor().get_titulacao().equals(titulacao)) ) {
				existe_d = true;
				disciplina.imprimir();
				break;
			}
		}
		
		if (!existe_d) System.out.println("Disciplina não cadastrada no sistema!\n");		
	}
	
	
	public void imprimir_lista_p() {
		if (professores.isEmpty()) {
			System.out.println("A lista de professores esta vazia.\n");
	    } else {
			for(Professor professor : professores) {
				professor.imprimir();
				System.out.println("-------------------\n");
			}
	    }
	}
	
	
	public void imprimir_lista_a() {
		if (alunos.isEmpty()) {
			System.out.println("A lista de alunos esta vazia.\n");
	    } else {
			for(Aluno aluno : alunos) {
				aluno.imprimir();
				System.out.println("-------------------\n");
			}
	    }
	}
	
	
	public void imprimir_lista_d() {
		if (disciplinas.isEmpty()) {
			System.out.println("A lista de disciplinas esta vazia.\n");
	    } else {
			for(Disciplina disciplina : disciplinas) {
				disciplina.imprimir();
				System.out.println("-------------------\n");
			}
	    }
	}

	public void imprimir() {
		System.out.println("Nome do curso: " + this.nome);
		
		imprimir_lista_p();
		imprimir_lista_a();
		imprimir_lista_d();
		
	}

}
