#ifndef FILA_HPP
#define FILA_HPP

#include "Documento.hpp"

using namespace std;

class Fila_De_Impressao

{

private:

    Documento* head;
    Documento* tail;

public:

    Fila_De_Impressao();

    ~Fila_De_Impressao();

    void adicionar_documento(int id, string arq_nome, int num_pag, int prioridade);
    
    Documento* consultar_documento(int id);
    
    void listar_documentos();
    
    void remover_documento(int id);
    
    void alterar_documento(int id, string novo_nome, int novo_num_pag, int nova_prioridade);

};

#endif
