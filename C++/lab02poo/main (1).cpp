#include "Corrida.hpp"
#include <iostream>

using namespace std;

int main() {
  Corrida corrida;

  cout << "Informe o modelo do carro: ";
  string modelo;
  getline(cin, modelo);
  corrida.setModelo(modelo);

  cout << "Informe a motorizacao do carro: ";
  string motorizacao;
  getline(cin, motorizacao);
  corrida.setMotorizacao(motorizacao);

  cout << "Informe o fabricante do veiculo: ";
  string fabricante;
  getline(cin, fabricante);
  corrida.setFabricante(fabricante);

  cout << "Informe o nome do motorista: ";
  string nomeMotorista;
  getline(cin, nomeMotorista);
  corrida.setNome(nomeMotorista);

  cout << "Informe a quilometragem inicial: ";
  double kmInicial;
  cin >> kmInicial;
  corrida.setKm_Inicio(kmInicial);

  cout << "Informe a quilometragem final: ";
  double kmFinal;
  cin >> kmFinal;
  corrida.setKm_Fim(kmFinal);

  cout << "\nDados da corrida:\n";
  cout << "Modelo do carro: " << corrida.getModelo() << "\n";
  cout << "Motorizacao do carro: " << corrida.getMotorizacao() << "\n";
  cout << "Fabricante do veiculo: " << corrida.getFabricante() << "\n";
  cout << "Nome do motorista: " << corrida.getNome() << "\n";
  cout << "Quilometragem inicial: " << corrida.getKm_Inicio() << " km\n";
  cout << "Quilometragem final: " << corrida.getKm_Fim() << " km\n";
  cout << "Deslocamento: " << corrida.deslocamento() << " km\n";
  cout << "Valor total: R$" << corrida.total_valor() << "\n";

  return 0;
}
