#ifndef TRIANGULO_HPP
#define TRIANGULO_HPP

#include <string>

using namespace std;

class Triangulo {

private:

    double a, b, c;
    static int contador_instancias;

public:

    Triangulo();
    Triangulo(double ladoA, double ladoB, double ladoC);

    double getLadoA() const;
    void setLadoA(double ladoA);

    double getLadoB() const;
    void setLadoB(double ladoB);

    double getLadoC() const;
    void setLadoC(double ladoC);

   string tipoTriangulo();

    static int getContador_instancias();
};

#endif
