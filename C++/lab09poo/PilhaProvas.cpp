#include "PilhaProvas.hpp"

PilhaProvas::PilhaProvas() {
    this->topo = NULL;
    this->qtd_provas = 0;
}

PilhaProvas::PilhaProvas(Prova *p) {
    this->topo = p;
    this->qtd_provas = 1;
}

PilhaProvas::~PilhaProvas() {
    Prova *p = this->topo;
    while (p != NULL) {
        Prova *t = p->get_abaixo();
        delete p;
        p = t;
    }
}

void *PilhaProvas::get_topo() {
    if(this->esta_vazia()) {
        cout << "Pilha vazia!" << endl << endl;
    } else {
        this->topo->imprimeProva();
    }
}

void PilhaProvas::empilha(Prova *p) {
    p->set_abaixo(this->topo);
    this->topo = p;
    this->qtd_provas++;
    cout << "Prova empilhada: " << endl;
    p->imprimeProva();
    cout << "Quantidade: " << this->qtd_provas << endl << endl;
}

void *PilhaProvas::desempilha() {
    if (this->esta_vazia()) {
        cout << "Pilha vazia!" << endl << endl;
    } else {
        Prova *p = this->topo;
        this->topo = p->get_abaixo();
        cout << "Prova desempilhada: " << endl;
        p->imprimeProva();
        delete p;
        this->qtd_provas--;
        if(!this->esta_vazia()){ 
            cout << endl << "Provas empilhadas: " << endl << endl;    
            this->imprime_pilha();
        }
        cout << "Quantidade: " << this->qtd_provas << endl << endl;
    }
}

bool PilhaProvas::esta_vazia() {
    return this->topo == NULL;
}

void PilhaProvas::imprime_pilha() {
    Prova *p = this->topo;
    while (p != NULL) {
        p->imprimeProva();
        p = p->get_abaixo();
    }
    cout << endl;
}