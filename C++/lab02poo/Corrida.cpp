#include "Corrida.hpp"

Corrida::Corrida() {}

void Corrida::setModelo(string m) { modelo = m; }

string Corrida::getModelo() { return modelo; }
void Corrida::setMotorizacao(string mt) { motorizacao = mt; }

string Corrida::getMotorizacao() { return motorizacao; }

void Corrida::setFabricante(string f) { fabricante = f; }

string Corrida::getFabricante() { return fabricante; }
void Corrida::setNome(string n) { nome_motorista = n; }

string Corrida::getNome() { return nome_motorista; }

void Corrida::setKm_Inicio(double i) { km_inicio = i; }

double Corrida::getKm_Inicio() { return km_inicio; }

void Corrida::setKm_Fim(double f) { km_fim = f; }

double Corrida::getKm_Fim() { return km_fim; }

double Corrida::deslocamento() { return km_fim - km_inicio; }
double Corrida::total_valor() {
  double quilometragem = deslocamento();
  return quilometragem * 3.75;
}