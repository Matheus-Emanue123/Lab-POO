public class Autor{

    private String nome;
    private String dataNascimento;

    public Autor(){}
        public Autor(String nome, String dataNascimento){
            this.nome = nome;
            this.dataNascimento = dataNascimento;
        }

public void imprimir(){
    System.out.println("\n Nome do autor = " + nome);
    System.out.println("Data de nascimento do autor = " + dataNascimento);
}
public void setNome(String nome) {
    this.nome = nome;
}

public String getNome() {
    return nome;
}
public void setData(String dataNascimento) {
    this.dataNascimento = dataNascimento;
}

public String getData() {
    return dataNascimento;
}
    }
