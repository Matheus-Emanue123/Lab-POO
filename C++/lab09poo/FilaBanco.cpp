#include "FilaBanco.hpp"

FilaBanco::FilaBanco() {

    cabeca = NULL;
    cauda = NULL;
    this->qtd_clientes_banco = 0;

}

FilaBanco::FilaBanco(ClienteBanco *d) {

    this->qtd_clientes_banco = 0;
    cabeca = d;
    cauda = cabeca;

}

FilaBanco::~FilaBanco() {

    ClienteBanco *aux = cabeca;
    while (aux != NULL) {
        cabeca = cabeca->get_prox();
        delete aux;
        aux = cabeca;
    }
}

void FilaBanco::enfileira(ClienteBanco *d) {

    if (esta_vazia()) {
        cabeca = d;
        cauda = cabeca;
    } else {

        cauda->set_prox(d);
        cauda = d;

    }

    cout << "Há " << this->qtd_clientes_banco << " clientes na frente de " << d->get_nome() << "!" << endl << endl;
    this->qtd_clientes_banco++;

}

void FilaBanco::desenfileira() {

    if (esta_vazia()) {

        cout << "Fila vazia!" << endl << endl;
    } else {

        ClienteBanco *aux = cabeca;

        cabeca = cabeca->get_prox();

        this->qtd_clientes_banco--;

        cout << "Cliente " << aux->get_nome() << " desenfileirado!" << endl;
        cout << "Restam " << this->qtd_clientes_banco << " clientes na fila!" << endl << endl;

        delete aux;
    }
}

void FilaBanco::imprime() {

    ClienteBanco *aux = cabeca;

    if(esta_vazia()) { 

        cout << "Fila vazia!" << endl << endl;
        return;

    }

    int i = 0;
    string teste;
    cin.ignore(1000, '\n');

    while (aux != NULL) {

        i++;
        cout << "Cliente " << i << ": " << endl;
        cout << "Nome: " << aux->get_nome() << endl;
        cout << "Prioritário: " << (!aux->get_prioridade() ? "Nao" : "Sim") << endl;
        cout << "CPF: " << aux->get_cpf() << endl;
        cout << "Agencia: " << aux->get_agencia() << endl;
        cout << "Número: " << aux->get_numero_da_conta() << endl;
        cout << endl;
        aux = aux->get_prox();
        cout << "Pressione a tecla 'enter' para " << (aux != NULL ? "ver o próximo cliente..." : "sair...") << endl;
        getline(cin, teste);
    }
    cout << endl;
}

int FilaBanco::get_qtd_clientes_banco() {
    return this->qtd_clientes_banco;
}

void FilaBanco::enfileira_prioritario(ClienteBanco *d) {

    d->set_prioridade(true);
    int i = 0;

    if (esta_vazia()) {
        cabeca = d;
        cauda = cabeca;
    } else {

        ClienteBanco *aux = cabeca;
        ClienteBanco *ant = NULL;
        while (aux != NULL && aux->get_prioridade() == true) {
            i++;
            ant = aux;
            aux = aux->get_prox();
        }
        if (ant == NULL) {

            d->set_prox(cabeca);
            cabeca = d;
        } else {

            d->set_prox(aux);
            ant->set_prox(d);
        }
    }
    cout << "Existem " << i << " clientes há serem atendidos antes de " << d->get_nome() << "!" << endl << endl;
    this->qtd_clientes_banco++;
}

int FilaBanco::esta_vazia() {
    return cabeca == NULL;
}

ClienteBanco *FilaBanco::get_cabeca() { return this->cabeca; }

void FilaBanco::set_cabeca(ClienteBanco *c) {
    this->cabeca = c;
}

ClienteBanco* FilaBanco::get_cauda() {
    return this->cauda;
}

void FilaBanco::set_cauda(ClienteBanco *c) {
    this->cauda = c;
}

bool FilaBanco::cpf_existe(string cpf) { 
    ClienteBanco *aux = cabeca;
    while(aux != NULL) {
        if(aux->get_cpf() == cpf) {
            return true;
        }
        aux = aux->get_prox();
    }
    return false;
}