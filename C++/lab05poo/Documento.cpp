#include "Documento.hpp"

Documento::Documento(int id, string arq_nome, int num_pag, int prioridade)
    : id(id), arq_nome(arq_nome), num_pag(num_pag), prioridade(prioridade), prox(nullptr) {

}

int Documento::get_id() {
    return id;
}

string Documento::get_nome() {
    return arq_nome;
}

void Documento::set_nome(string new_nome) {
    this->arq_nome = new_nome;
}

int Documento::get_pag() {
    return num_pag;
}
void Documento::set_pag(int new_pag) {
    this->num_pag = new_pag;
}

int Documento::get_prioridade() {
    return prioridade;
}
void Documento::set_prioridade(int new_prioridade) {
    this->prioridade = new_prioridade;
}

Documento* Documento::get_prox() {
    return prox;
}

void Documento::set_prox(Documento* p) {
    prox = p;
}
