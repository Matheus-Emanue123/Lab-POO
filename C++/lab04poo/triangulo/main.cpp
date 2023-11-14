#include <iostream>
#include "Triangulo.hpp"

int main() {
    
    double ladoA, ladoB, ladoC;

    cout << "Digite o comprimento dos lados do triângulo (a, b e c): ";
    cin >> ladoA >> ladoB >> ladoC;

    Triangulo triangulo(ladoA, ladoB, ladoC);

    string tipo = triangulo.tipoTriangulo();

    cout << "Este é um triângulo " << tipo << endl;

    int t_instancias = Triangulo::getContador_instancias();
    cout << "O total de instâncias criadas é: " << t_instancias << endl;

    return 0;
}
