import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static List<Curso> cursos = new ArrayList<Curso>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		
		int resposta = 1;

		while(resposta != 0) {

			System.out.println("---------- M E N U  S I S T E M A  C E F E T - MG V ----------: ");

			System.out.println("1 - Cadastrar um Curso");
			System.out.println("2 - Excluir um Curso");
			System.out.println("3 - Listar um Curso");
			System.out.println("4 - Listar todos os Cursos");	
			System.out.println("5 - Opções de um Curso");	
			System.out.println("0 - Sair");

			resposta = scanner.nextInt();
			scanner.nextLine();
			System.out.println("\n----------------------------");
			
			switch (resposta) {
				case 1: {
					cadastrar_curso(scanner);
					break;
				}
				
				case 2: {
					excluir_curso(scanner);
					break;
				}
				
				case 3: {
					listar_curso(scanner);
					break;
				}
				
				case 4: {
					listar_todos(scanner);
					break;
				}
				
				case 5: {
					opcoes_curso(scanner);
					break;
				}
				
				case 0: {
					System.out.println("ENCERRANDO SISTEMA");
					System.exit(0);
					break;
				}
			}
		}
		scanner.close();		

	}
	
	public static void cadastrar_curso (Scanner scanner) {
		System.out.print("Digite o nome do novo curso: ");
		String nome = scanner.nextLine();
		
		Curso curso = new Curso(nome);	

		cursos.add(curso);
		
		System.out.println("Curso cadastrado!");
	}

	public static void excluir_curso (Scanner scanner) {

		if(cursos.isEmpty()) System.out.println("A lista de cursos esta vazia!");
		else {
			System.out.print("Digite o nome do curso: ");
			String nome = scanner.nextLine();
			
			boolean existe_curso = false;
			for(Curso curso : cursos) {
				if(curso.get_nome().equals(nome)) {
					existe_curso = true;
					cursos.remove(curso);
					System.out.println("Curso removido com sucesso!");
					break;
				}
			}
			
			if(!existe_curso) System.out.println("Curso não cadastrado no sistema!");
		}
	}
	
	public static void listar_curso (Scanner scanner) {
		if(cursos.isEmpty()) System.out.println("A lista de cursos esta vazia!");
		else {
			System.out.print("Digite o nome do curso: ");
			String nome = scanner.nextLine();
			
			boolean existe_curso = false;
			for(Curso curso : cursos) {
				if(curso.get_nome().equals(nome)) {
					existe_curso = true;
					curso.imprimir();
					break;
				}
			}
			
			if(!existe_curso) System.out.println("Curso não cadastrado no sistema!");
		}
	}
	
	public static void listar_todos (Scanner scanner) {
		if(cursos.isEmpty()) System.out.println("A lista de cursos esta vazia!");
		else for(Curso curso : cursos) curso.imprimir();
	}
	
	public static void opcoes_curso (Scanner scanner) {
		if(cursos.isEmpty()) System.out.println("A lista de cursos esta vazia! Cadastre um para ver as opções!");
		else {
			System.out.print("Digite o nome do curso: ");
				String nome = scanner.nextLine();
			
			boolean existe_curso = false;
			for(Curso curso : cursos) {
				if(curso.get_nome().equals(nome)) {
					existe_curso = true;
					menu(curso, scanner);
					break;
				}
			}
			
			if(!existe_curso) System.out.println("Curso não cadastrado no sistema!");
		}
	}
	
 	public static void menu (Curso curso, Scanner scanner) {
		int resposta1 = 1;
		while(resposta1 != 0) {
			System.out.println("---------- M E N U  D O  C U R S O ---------- ");
			System.out.println("01 - Cadastrar Professor");
			System.out.println("02 - Cadastrar Aluno");
			System.out.println("03 - Cadastrar Disciplina");
			System.out.println("04 - Cadastrar Aluno em uma Disciplina");
			System.out.println("05 - Excluir Professor");
			System.out.println("06 - Excluir Aluno");
			System.out.println("07 - Excluir Disciplina");
			System.out.println("08 - Trocar professor de uma Disciplina");
			System.out.println("09 - Imprimir Dados de um Professor");
			System.out.println("10 - Imprimir Dados de um Aluno");
			System.out.println("11 - Imprimir Dados de um Disciplina");
			System.out.println("12 - Imprimir Lista de Professores");
			System.out.println("13 - Imprimir Lista de Alunos");
			System.out.println("14 - Imprimir Lista de Disciplinas");
			System.out.println("0 - Sair");
			resposta1 = scanner.nextInt();
			scanner.nextLine();
			System.out.println("\n----------------------------");
			
			switch (resposta1) {

				case 1: {

					curso.cadastrar_professor(scanner);
					break;
				}
				
				case 2: {

					curso.cadastrar_aluno(scanner);
					break;
				}
				
				case 3: {

					curso.cadastrar_disciplina(scanner);
					break;

				}
				
				case 4: {

					curso.cadastrar_aluno_disciplina(scanner);
					break;
				}
				
				case 5: {

					curso.excluir_professor(scanner);
					break;

				}
				
				case 6: {
					
					curso.excluir_aluno(scanner);
					break;
				}
				
				case 7: {

					curso.excluir_disciplina(scanner);
					break;

				}
				
				case 8: {

					curso.trocar_p(scanner);
					break;

				}
				
				case 9: {

					curso.imprimir_p();
					break;

				}
				
				case 10: {

					curso.imprimir_a();
					break;

				}
				
				case 11: {

					curso.imprimir_d();
					break;

				}
				
				case 12: {

					curso.imprimir_lista_p();
					break;

				}
				
				case 13: {

					curso.imprimir_lista_a();
					break;

				}
				
				case 14: {

					curso.imprimir_lista_d();
					break;

				}			
			}
		}
		scanner.close();	
	}
 	
}