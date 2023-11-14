#include "Lampada.hpp"

int Lampada::contador_instancias = 0;

Lampada::Lampada(string modelo, int tensao) {
    this->modelo = modelo;
    this->tensao = tensao;
    this->estado = false;
    contador_instancias++; 
}

string Lampada::getModelo() const {
    return modelo;
}

void Lampada::setModelo(string modelo) {
    this->modelo = modelo;
}

int Lampada::getTensao() const {
    return tensao;
}

void Lampada::setTensao(int tensao) {
    this->tensao = tensao;
}

bool Lampada::getEstado() const {
    return estado;
}

void Lampada::acender() {
    estado = true;
}

void Lampada::apagar() {
    estado = false;
}

string Lampada::qual_estado() {
    return (estado) ? "Ligada" : "Desligada";
}

int Lampada::getContador_instancias() {
    return contador_instancias;
}


