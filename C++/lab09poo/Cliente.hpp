#ifndef CLIENTE_HPP
#define CLIENTE_HPP

#include <iostream>
#include <string>
#include "Pessoa.hpp"

using namespace std;

class ClienteBanco: public Pessoa {

   private:

    string numero_da_conta;
    string agencia;
    bool prioridade;
    ClienteBanco* prox;
    static int cont_clientes_banco;

   public:
   
    ClienteBanco();
    ClienteBanco(bool prioridade, string nome, string cpf, string agencia);
    
    string get_numero_da_conta();

    string get_agencia();
    void set_agencia(string agencia);

    bool get_prioridade();
    void set_prioridade(bool prioridade);
    
    ClienteBanco* get_prox();
    void set_prox(ClienteBanco* p);
    
};

#endif