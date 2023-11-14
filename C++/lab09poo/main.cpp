#include <iostream>
#include <string>
#include <cstdio>
#include <random>
#include "Cliente.hpp"
#include "FilaBanco.hpp"
#include "Prova.hpp"
#include "PilhaProvas.hpp"
#include "Aluno.hpp"

using namespace std;


void limpa_console(){

    system("cls||clear");

}

void menu_inicial(){

    cout << "= = = = = = = = = = M E N U = = = = = = = = = = " << endl << endl;
    cout << "1 - Fila do Banco" << endl;
    cout << "2 - Pilha de Provas" << endl;
    cout << "3 - Sair" << endl << endl;
    cout << "Digite o número correspondente ao que deseja gerenciar! ";

}

void menu_prova(){
    
    cout << "= = = = = = = = = = P I L H A  D E  P R O V A S = = = = = = = = = =  " << endl << endl;
    cout << "1 - Empilhar prova" << endl;
    cout << "2 - Desempilhar pilha" << endl;
    cout << "3 - Mostrar prova do topo" << endl;
    cout << "4 - Verificar se a pilha esta vazia" << endl;
    cout << "5 - Sair" << endl << endl;
    cout << "Digite o número correspondente ao que deseja gerenciar! ";
}

void menu_banco(){

    cout << "= = = = = = = = = = F I L A  D E  B A N C O = = = = = = = = = = " << endl << endl;
    cout << "1 - Inserir cliente" << endl;
    cout << "2 - Atender cliente" << endl;
    cout << "3 - Mostrar fila" << endl;
    cout << "4 - Verificar se a fila esta vazia" << endl;
    cout << "5 - Inserir cliente prioritario" << endl;
    cout << "6 - Sair" << endl << endl;
    cout << "Digite o número correspondente ao que deseja gerenciar! ";
}

ClienteBanco* enfileira(FilaBanco *filaBanco){

    string nome, cpf, agencia;

    cout << endl << "NOME DO CLIENTE: ";
    getline(cin, nome);
    cout << endl << "CPF DO CLIENTE: ";
    cin >> cpf;

    while(filaBanco->cpf_existe(cpf)){
        cout << endl << "CPF já cadastrado no sistema! Tente novamente com outro CPF: ";
        cin >> cpf;


    }

    cout << endl << "AGÊNCIA DO CLIENTE: ";
    cin >> agencia;


    return new ClienteBanco(false, nome, cpf, agencia);
}

int main() {

    Aluno alunos[11];

    alunos[0] = Aluno("POO", "A", "1");
    alunos[1] = Aluno("POO", "B", "2");
    alunos[2] = Aluno("POO", "C", "3");
    alunos[3] = Aluno("POO", "D", "4");
    alunos[4] = Aluno("POO", "E", "5");
    alunos[5] = Aluno("POO", "F", "6");
    alunos[6] = Aluno("POO", "G", "7");
    alunos[7] = Aluno("POO", "H", "8");
    alunos[8] = Aluno("POO", "I", "9");
    alunos[9] = Aluno("POO", "J", "10");
    alunos[10] = Aluno("POO", "K", "11");
    

    limpa_console();

    int escolha;
    FilaBanco *filaBanco = new FilaBanco();
    PilhaProvas *pilhaProvas = new PilhaProvas();

    do {

        menu_inicial();
        cin >> escolha;
        limpa_console();

        switch (escolha) {

            case 1: {

                int escolhaBanco;

                do {

                    menu_banco();
                    cin >> escolhaBanco;
                    limpa_console();
                    switch (escolhaBanco) {

                        case 1: {

                            string nome, cpf, agencia;
                            cout << endl << "---------------------ENFILEIRAMENTO DE CLIENTES---------------------" << endl;
                            
                            filaBanco->enfileira(enfileira(filaBanco));
                            break;
                        }

                        case 2: {

                            filaBanco->desenfileira();
                            break;

                        }

                        case 3: {

                            filaBanco->imprime();
                            break;
                        }

                        case 4: {

                            limpa_console();
                            if(filaBanco->esta_vazia()){
                                cout << "Fila vazia!" << endl << endl;
                            } else {
                                cout << "Fila nao esta vazia!" << endl << endl;
                            }
                            break;
                        }

                        case 5: {

                            string nome, cpf, agencia;
                            cout << endl << "---------------------ENFILEIRAMENTO DE CLIENTES PRIORITÁRIOS---------------------" << endl;
                            
                            filaBanco->enfileira_prioritario(enfileira(filaBanco));
                            break;
                        }

                        case 6: {

                            limpa_console();
                            break;
                        }

                        default: {

                            cout << "Opcao invalida!" << endl << endl;
                            break;
                        }
                    }

                } while (escolhaBanco != 6);

                break;
            }
            
            case 2: {

                int escolhaProva;

                do {
                    
                    menu_prova();
                    cin >> escolhaProva;
                    limpa_console();
                    switch (escolhaProva) {

                        case 1: {

                            string disciplina, cpf, nome, curso;
                            float nota;
                            cout << endl << "---------------------EMPILHAMENTO DE PROVAS---------------------" << endl;
                    

                            cout << endl << "DISCIPLINA: ";
                            getline(cin, disciplina);

                            cout << endl << "NOTA: ";
                            cin >> nota;
                            
                            random_device rd;
                            mt19937 rng(rd());
                            uniform_int_distribution<mt19937::result_type> dist(0, 11);
                            int random = dist(rng);
                            
                            Prova *novaProva = new Prova(disciplina, nota, alunos[random]);
                            pilhaProvas->empilha(novaProva);
                            break;
                        }

                        case 2: {

                            pilhaProvas->desempilha();
                            break;
                        }

                        case 3: {

                            pilhaProvas->get_topo();
                            break;
                        }

                        case 4: {

                            if(pilhaProvas->esta_vazia()){
                                cout << "Pilha vazia!" << endl << endl;
                            } else {
                                cout << "Pilha nao esta vazia!" << endl << endl;
                            }
                            break;
                        }

                        case 5: {

                            limpa_console();
                            break;
                        }

                        default: {

                            cout << "Opcao invalida!" << endl << endl;
                            break;

                        }
                    }
                } while (escolhaProva != 5);
                break;
            }

            case 3: {

                limpa_console();
                break;

            }

            default: {

                cout << "Opcao invalida!" << endl << endl;
                break;
            }
        }

    } while (escolha != 3);
}