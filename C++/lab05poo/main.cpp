#include <iostream>
#include "Fila.hpp"

using namespace std;

int main()

{
    Fila_De_Impressao fila;

    int escolha;

    do
    {
        cout << "- - - - - - - - - - M E N U - - - - - - - - - - " << endl;
        cout << "\nEscolha uma opção: \n" << endl;
        cout << "1. Adicionar documento \n" << endl;
        cout << "2. Consultar documento por ID \n" << endl;
        cout << "3. Listar todos os documentos \n" << endl;
        cout << "4. Remover documento por ID \n" << endl;
        cout << "5. Alterar informações do documento\n" << endl;
        cout << "6. Sair \n" << endl;
        cout << "- - - - - - - - - - - - - - - - - - - - - - - - " << endl;
        cin >> escolha;

        switch (escolha)

        {

        case 1:

        {
            int id;
            string nome;
            int num_pag;
            int prioridade;

            cout << "Digite o ID do documento: ";
            cin >> id;
            cout << "Digite o nome do arquivo: ";
            cin >> nome;
            cout << "Digite o número de páginas: ";
            cin >> num_pag;
             cout << "Níveis de Prioridade: \n";
            cout << "1 - Alta\n";
            cout << "2 - Média\n";
            cout << "3 - Baixa\n";
            cout << "Digite nível de prioridade (número): ";
            cin >> prioridade;

            fila.adicionar_documento(id, nome, num_pag, prioridade);
            cout << "Documento adicionado com sucesso!" << endl;
            break;
        }

        case 2:

        {

            int id_consulta;

            cout << "Digite o ID do documento que deseja consultar: ";
            cin >> id_consulta;
            Documento* doc_consultado = fila.consultar_documento(id_consulta);
            if (doc_consultado != nullptr)

            {
                cout << "Documento encontrado:" << endl;
                cout << "ID: " << doc_consultado->get_id() << endl;
                cout << "Nome do Arquivo: " << doc_consultado->get_nome() << endl;
                cout << "Número de Páginas: " << doc_consultado->get_pag() << endl;
                cout << "Prioridade: " << doc_consultado->get_prioridade() << endl;
            }

            else

            {
                cout << "Documento com o ID " << id_consulta << " não encontrado na fila." << endl;
            }

            break;
        }

        case 3:

            cout << "Documentos na fila:" << endl;
            fila.listar_documentos();
            break;

        case 4:

        {
            int id_remover;
            cout << "Digite o ID do documento que deseja remover: ";
            cin >> id_remover;
            fila.remover_documento(id_remover);
            cout << "Documento removido com sucesso!" << endl;
            break;
        }

        case 5:

        {
            int id_alterar;
            string novo_nome;
            int novo_num_pag;
            int nova_prioridade;

            cout << "Digite o ID do documento que deseja alterar: ";
            cin >> id_alterar;
            cout << "Digite o novo nome do arquivo: ";
            cin >> novo_nome;
            cout << "Digite o novo número de páginas: ";
            cin >> novo_num_pag;
            cout << "Digite a nova prioridade: ";
            cin >> nova_prioridade;

            fila.alterar_documento(id_alterar, novo_nome, novo_num_pag, nova_prioridade);
            cout << "Documento alterado com sucesso!" << endl;
            break;
        }

        case 6:

            cout << "Saindo..." << endl;
            break;

        default:

            cout << "Opção inválida. Tente novamente." << endl;
            break;
        }

    } while (escolha != 6);

    return 0;
}
