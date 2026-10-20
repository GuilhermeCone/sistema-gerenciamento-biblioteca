
package com.biblioteca.biblioteca.model;

import jakarta.persistence.*;
import java.time.Year;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private int anoPublicacao;
    private boolean disponivel = true;

    public Livro() {
    }

    public Livro(String titulo, String autor, int anoPublicacao) {
        setTitulo(titulo);
        setAutor(autor);
        setAnoPublicacao(anoPublicacao);
        this.disponivel = true;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("O título não pode ser vazio!");
        }
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.isBlank()) {
            throw new IllegalArgumentException("O autor não pode ser vazio!");
        }
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        if (anoPublicacao <= 0 || anoPublicacao > Year.now().getValue()) {
            throw new IllegalArgumentException("Ano de publicação inválido!");
        }
        this.anoPublicacao = anoPublicacao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public String emprestar() {
        if (!disponivel) {
            return "Este livro já está emprestado!";
        }
        disponivel = false;
        return "Livro emprestado com sucesso!";
    }

    public String devolver() {
        if (disponivel) {
            return "Este livro já está disponível!";
        }
        disponivel = true;
        return "Livro devolvido com sucesso!";
    }
}
