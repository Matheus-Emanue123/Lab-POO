public class Cliente {
    private String nome;
    private String endereco;
    private String numeroTelefone;

    public Cliente(String nome, String endereco, String numeroTelefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.numeroTelefone = numeroTelefone;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }
}
