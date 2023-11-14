#include "Pessoa.hpp"

using namespace std;

Pessoa::Pessoa() {}

Pessoa::Pessoa(string nome, string cpf) {
    this->nome = nome;
    this->cpf = cpf;
}

string Pessoa::get_nome() {
    return this->nome;
}

void Pessoa::set_nome(string nome) {
    this->nome = nome;
}

string Pessoa::get_cpf() {
    return this->cpf;
}

void Pessoa::set_cpf(string cpf) {
    this->cpf = cpf;
}