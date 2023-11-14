#include "Prova.hpp"

using namespace std;

int Prova::contProvas=0;

Prova::Prova() {
    this->contProvas++;
    this->codigoDaProva = to_string(contProvas);
}

Prova::Prova(string disciplina, float nota, Aluno aluno) {
    this->disciplina = disciplina;
    this->contProvas++;
    this->codigoDaProva = to_string(contProvas);
    this->nota = nota;
    this->aluno = aluno;
}

string Prova::get_disciplina() {
    return this->disciplina;
}

void Prova::set_disciplina(string disciplina) {
    this->disciplina = disciplina;
}

string Prova::get_codigo() {
    return this->codigoDaProva;
}

void Prova::set_codigo(string codigoDaProva) {
    this->codigoDaProva = codigoDaProva;
}

float Prova::get_nota() {
    return this->nota;
}

void Prova::set_nota(float nota) {
    this->nota = nota;
}

Aluno Prova::get_aluno() {
    return this->aluno;
}

void Prova::set_aluno(Aluno aluno) {
    this->aluno = aluno;
}

Prova* Prova::get_abaixo() {
    return this->abaixo;
}

void Prova::set_abaixo(Prova* p) {
    this->abaixo = p;
}

void Prova::imprimeProva() {
    cout << "Disciplina: " << this->disciplina << endl;
    cout << "Código da prova: " << this->codigoDaProva << endl;
    cout << "Nota: " << this->nota << endl;
    cout << "Aluno: " << endl;
    this->aluno.imprime_dados();
    cout << endl;
}