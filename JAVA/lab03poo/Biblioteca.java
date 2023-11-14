import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    
    private List <Livro> livros;

    public Biblioteca(){
    livros = new ArrayList<>();

    }

    public void addLivro(Livro livro){
        livros.add(livro);
        System.out.println("O livro foi adicionado à biblioteca com sucesso!");
    }

    public void buscarLivro(String titulo, Autor autor){
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo) && livro.getAutor().getNome().equals(autor.getNome())) {
                System.out.println("Livro encontrado:");
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor().getNome());
                return;
            }
        }
        System.out.println("Livro não encontrado na biblioteca.");
    }

    public void mostrarLivros(){
        System.out.println("Lista de livros na biblioteca:");
        for (Livro livro : livros) {
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("ISBN: "+ livro.getISBN());
            System.out.println("Autor: " + livro.getAutor().getNome());
            System.out.println("Data de Nascimento do Autor: " + livro.getAutor().getData());
            System.out.println("-----");
        }
    }
}
