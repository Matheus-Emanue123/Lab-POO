#ifndef PESSOA_HPP
#define PESSOA_HPP

#include <iostream>
#include <string>
#include "Pessoa.hpp"

using namespace std;

class Pessoa {

   private:

    string nome;
    string cpf;

   public:

    Pessoa();
    Pessoa(string nome, string cpf);
    
    string get_nome();
    void set_nome(string nome);
    string get_cpf();
    void set_cpf(string cpf);
    
};

#endif