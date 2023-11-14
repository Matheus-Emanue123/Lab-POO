#ifndef LAMPADA_HPP
#define LAMPADA_HPP

#include <string>

using namespace std;

class Lampada {

private:

    string modelo;
    int tensao;
    bool estado; 
    static int contador_instancias; 

public:
    
    Lampada(string modelo, int tensao);

    string getModelo() const;
    void setModelo(string modelo);

    int getTensao() const;
    void setTensao(int tensao);

    bool getEstado() const;
    void acender();
    void apagar();

    string qual_estado();

    static int getContador_instancias();
};

#endif
