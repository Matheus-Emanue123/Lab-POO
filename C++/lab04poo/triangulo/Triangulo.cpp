#include "Triangulo.hpp"
#include <cmath>

int Triangulo::contador_instancias = 0;

Triangulo::Triangulo() {
    a = 1.0;
    b = 1.0;
    c = 1.0;
    contador_instancias++; 
}

Triangulo::Triangulo(double ladoA, double ladoB, double ladoC) {
    setLadoA(ladoA);
    setLadoB(ladoB);
    setLadoC(ladoC);
    contador_instancias++; 
}

double Triangulo::getLadoA() const {
    return a;
}

double Triangulo::getLadoB() const {
    return b;
}

double Triangulo::getLadoC() const {
    return c;
}

void Triangulo::setLadoA(double ladoA) {
    if (ladoA > 0) {
        a = ladoA;
    } else {
        a = 1.0; 
    }
}

void Triangulo::setLadoB(double ladoB) {
    if (ladoB > 0) {
        b = ladoB;
    } else {
        b = 1.0; 
    }
}

void Triangulo::setLadoC(double ladoC) {
    if (ladoC > 0) {
        c = ladoC;
    } else {
        c = 1.0; 
    }
}

std::string Triangulo::tipoTriangulo() {
    if (a >= b + c || b >= a + c || c >= a + b) {
        return "Não é um triângulo";
    } else if (a == b && b == c) {
        return "Equilátero";
    } else if (a == b || a == c || b == c) {
        return "Isósceles";
    } else {
        return "Escaleno";
    }
}

int Triangulo::getContador_instancias() {
    return contador_instancias;
}
