#ifndef ALUNO_HPP
#define ALUNO_HPP

#include <iostream>
#include <string>
#include "Aluno.hpp"
#include "Pessoa.hpp"

using namespace std;

class Aluno: public Pessoa {

   private:

    int numero_matricula;
    string curso;
    static int cont_alunos;

   public:
   
    Aluno();
    Aluno(string curso, string nome, string cpf);
    
    int get_numero_matricula();

    string get_curso();
    void set_curso(string curso);

    void imprime_dados();
};

#endif