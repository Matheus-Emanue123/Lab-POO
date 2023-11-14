#ifndef FilaDeBanco_HPP
#define FilaDeBanco_HPP

#include "Cliente.hpp"
#include <iostream>

using namespace std;

class FilaBanco {

   private:

    ClienteBanco *cabeca;
    ClienteBanco *cauda;
    int qtd_clientes_banco;

   public:

    FilaBanco();
    FilaBanco(ClienteBanco *d);
    ~FilaBanco();

    void enfileira(ClienteBanco *d);

    void desenfileira();

    void imprime();

    int get_qtd_clientes_banco();

    void enfileira_prioritario(ClienteBanco *d);

    int esta_vazia();

    ClienteBanco* get_cabeca();
    ClienteBanco* get_cauda();

    void set_cabeca(ClienteBanco *c);
    void set_cauda(ClienteBanco *c);

    bool cpf_existe(string cpf);

};
#endif