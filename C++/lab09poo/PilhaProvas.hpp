#ifndef PilhaProvas_HPP
#define PilhaProvas_HPP

#include "Prova.hpp"
#include "Aluno.hpp"
#include <iostream>

using namespace std;

class PilhaProvas {

   private:

    Prova* topo;
    int qtd_provas;

   public:

    PilhaProvas();
    PilhaProvas(Prova *p);
    ~PilhaProvas();

    void *get_topo();

    void empilha(Prova *p);

    void *desempilha();

    bool esta_vazia();

    void imprime_pilha();
};
#endif