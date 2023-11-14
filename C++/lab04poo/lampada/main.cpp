#include <iostream>
#include "Lampada.hpp"

int main() {

   string modelo;
   int tensao;
   char escolha;

   cout << "Digite o modelo da lâmpada: ";
   cin >> modelo;

   cout << "Digite a tensão da lâmpada: ";
   cin >> tensao;

   Lampada lampada(modelo, tensao);
   

   do { 

        cout << "Estado da lâmpada (" << lampada.getModelo() << "): " << lampada.qual_estado() << endl;
        cout << "---------- M E N U  D A  L A M P A D A ----------" << endl;
        cout << "1. Ligar a lâmpada" << endl;
        cout << "2. Desligar a lâmpada" << endl;
        cout << "3. Sair" << endl;
        cout << "--------------------------------------- ";
        cin >> escolha;

         switch (escolha) {
            case 1:
                lampada.acender();
                cout << "Lâmpada ligada." << endl;
                break;
            case 2:
                lampada.apagar();
                cout << "Lâmpada desligada." << endl;
                break;
            case 3:
                cout << "Saindo do programa." << endl;
                break;
            default:
                cout << "Opção inválida! Tente novamente." << endl;
                break;
        }

   } while (escolha != 3);

    int t_instancias = Lampada::getContador_instancias();
    cout << "O total de instâncias criadas é: " << t_instancias << endl;

    return 0;
}
