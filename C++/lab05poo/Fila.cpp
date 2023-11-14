#include "Fila.hpp"

Fila_De_Impressao::Fila_De_Impressao()

    : head(nullptr), tail(nullptr)
{
}

Fila_De_Impressao::~Fila_De_Impressao()
{

    Documento* atual = head;
    while (atual != nullptr)
    {
        Documento* proximo = atual->get_prox();
        delete atual;
        atual = proximo;
    }
}

void Fila_De_Impressao::adicionar_documento(int id, string arq_nome, int num_pag, int prioridade_num)
{
    Documento* novo_documento = new Documento(id, arq_nome, num_pag, prioridade_num);

    if (head == nullptr)
    {
        head = novo_documento;
        tail = novo_documento;
    }
    else
    {
    
        Documento* atual = head;
        Documento* anterior = nullptr;
        while (atual != nullptr && novo_documento->get_prioridade() >= atual->get_prioridade())
        {
            anterior = atual;
            atual = atual->get_prox();
        }
        if (anterior == nullptr)
        {
        
            novo_documento->set_prox(head);
            head = novo_documento;
        }
        else
        {
           
            anterior->set_prox(novo_documento);
            novo_documento->set_prox(atual);
        }
    }
}

Documento* Fila_De_Impressao::consultar_documento(int id)

{
    Documento* atual = head;
    while (atual != nullptr)
    {
        if (atual->get_id() == id)
        {
            return atual;
        }
        atual = atual->get_prox();
    }
    return nullptr;
}

void Fila_De_Impressao::listar_documentos()
{
    Documento* atual = head;
    while (atual != nullptr)
    {
        cout << "ID: " << atual->get_id() << endl;
        cout << "Nome do Arquivo: " << atual->get_nome() << endl;
        cout << "Número de Páginas: " << atual->get_pag() << endl;
        cout << "Prioridade: " << atual->get_prioridade() << endl;
        cout << "------------------------" << endl;
        atual = atual->get_prox();
    }
}

void Fila_De_Impressao::remover_documento(int id)
{
    if (head == nullptr)
    {
        return; 
    }

    if (head->get_id() == id)
    {
        Documento* temp = head;
        head = head->get_prox();
        delete temp;
        return;
    }

    Documento* atual = head;
    while (atual->get_prox() != nullptr)
    {
        if (atual->get_prox()->get_id() == id)
        {
            Documento* temp = atual->get_prox();
            atual->set_prox(temp->get_prox());
            delete temp;
            return;
        }
        atual = atual->get_prox();
    }
}

void Fila_De_Impressao::alterar_documento(int id, string novo_nome, int novo_num_pag, int nova_prioridade)
{
    Documento* documento = consultar_documento(id);
    if (documento != nullptr)
    {
        documento->set_nome(novo_nome);
        documento->set_pag(novo_num_pag);
        documento->set_prioridade(nova_prioridade);
    }
}
