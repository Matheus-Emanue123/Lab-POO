#include <fstream>
#include <iostream>
#include <string>

using namespace std;

int main() {

  string string;

  while (getline(cin, string)) {

    bool italico = false;
    bool negrito = false;

    for (char caracter : string) {
      if (caracter == '_') {
        cout << (italico ? "</i>" : "<i>");
        italico = !italico;
      } else if (caracter == '*') {
        cout << (negrito ? "</b>" : "<b>");
        negrito = !negrito;
      } else {
        cout << caracter;
      }
    }

    cout << endl;
  }
  
  return 0;
}
