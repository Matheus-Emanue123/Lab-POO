#ifndef PROVA_HPP
#define PROVA_HPP

#include <iostream>
#include <string>
#include "Prova.hpp"
#include "Aluno.hpp"

using namespace std;
class Prova{
   private:
    string disciplina;
    string codigoDaProva;
    float nota;
    Aluno aluno;
    static int contProvas;
    Prova* abaixo;

   public:
    Prova();
    Prova(string disciplina, float nota, Aluno aluno);

    string get_disciplina();
    void set_disciplina(string disciplina);

    string get_codigo();
    void set_codigo(string codigoDaProva);

    float get_nota();
    void set_nota(float nota);

    Aluno get_aluno();
    void set_aluno(Aluno aluno);

    Prova* get_abaixo();
    void set_abaixo(Prova* p);

    void imprimeProva();

};

#endif