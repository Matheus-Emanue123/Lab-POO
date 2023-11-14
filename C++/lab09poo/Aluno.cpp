#include "Aluno.hpp"
#include "Pessoa.hpp"

using namespace std;

int Aluno::cont_alunos=0;

Aluno::Aluno() {

    this->cont_alunos++;
    this->numero_matricula = this->cont_alunos;
}

Aluno::Aluno(string curso, string nome, string cpf): Pessoa(nome, cpf) {

    this->curso = curso;
    this->cont_alunos++;
    this->numero_matricula = this->cont_alunos;
    
}

int Aluno::get_numero_matricula() {
    return this->numero_matricula;
}

string Aluno::get_curso() {
    return this->curso;
}

void Aluno::set_curso(string curso) {
    this->curso = curso;
}

void Aluno::imprime_dados() {
    cout << "Nome: " << this->get_nome() << endl;
    cout << "CPF: " << this->get_cpf() << endl;
    cout << "Curso: " << this->get_curso() << endl;
    cout << "Número de matrícula: " << this->get_numero_matricula() << endl;
}