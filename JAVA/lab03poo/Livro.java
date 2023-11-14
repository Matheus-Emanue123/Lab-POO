public class Livro {

        private String titulo;
        private String ISBN;
        private Autor autor;
    
        public Livro(){}
            public Livro(String titulo, String ISBN, Autor autor){
                this.titulo = titulo;
                this.ISBN = ISBN;
                this.autor = autor;
            }
    
    public void imprimir(){
        System.out.println("\n Titulo= " + titulo);
        System.out.println("ISBN = " + ISBN);
        System.out.println("Autor: " + autor);
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getTitulo() {
        return titulo;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
    public String getISBN() {
        return ISBN;
    }
        

         public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    public Autor getAutor() {
        return autor;
    }
        }
    
    
