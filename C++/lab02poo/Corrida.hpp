#ifndef CORRIDA_HPP
#define CORRIDA_HPP

#include <string>

using namespace std;

class Corrida {

private:

string modelo, motorizacao, fabricante, nome_motorista;
double km_inicio, km_fim;

public:

Corrida();

void setModelo(string modelo);
string getModelo();

void setMotorizacao(string motorizacao);
string getMotorizacao();

void setFabricante(string fabricante);
string getFabricante();

void setNome(string nome_motorista);
string getNome();

void setKm_Inicio(double km_inicio);
double getKm_Inicio();

void setKm_Fim(double km_fim);
double getKm_Fim();

double deslocamento();
double total_valor();

};

#endif