#ifndef Documento_HPP
#define Documento_HPP

#include <iostream>
#include <string>

using namespace std;

class Documento

{

private:

    int id;
    string arq_nome;
    int num_pag;
    int prioridade; 
    Documento* prox;

public:

    Documento(int id, string arq_nome, int num_pag, int prioridade);

    int get_id();

    string get_nome();
    void set_nome(string new_nome);

    int get_pag();
    void set_pag(int new_pag);

    int get_prioridade(); 
    void set_prioridade(int new_prioridade);

    Documento* get_prox();
    void set_prox(Documento* p);
    
};

#endif
