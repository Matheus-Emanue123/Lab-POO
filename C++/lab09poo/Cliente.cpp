#include "Cliente.hpp"

using namespace std;

int ClienteBanco::cont_clientes_banco=0;

ClienteBanco::ClienteBanco() {
    this->cont_clientes_banco++;
    this->numero_da_conta = to_string(cont_clientes_banco);
}

ClienteBanco::ClienteBanco(bool prioridade, string nome, string cpf, string agencia): Pessoa(nome, cpf) {
    
    this->prioridade = prioridade;
    this->agencia = agencia;
    this->prox = NULL;
    this->cont_clientes_banco++;
    this->numero_da_conta = to_string(cont_clientes_banco);

}

string ClienteBanco::get_numero_da_conta() {
    return this->numero_da_conta;
}

string ClienteBanco::get_agencia() {
    return this->agencia;
}

void ClienteBanco::set_agencia(string agencia) {
    this->agencia = agencia;
}

bool ClienteBanco::get_prioridade() {
    return this->prioridade;
}

void ClienteBanco::set_prioridade(bool prioridade) {
    this->prioridade = prioridade;
}

ClienteBanco* ClienteBanco::get_prox() {
    return this->prox;
}

void ClienteBanco::set_prox(ClienteBanco* p) {
    this->prox = p;
}