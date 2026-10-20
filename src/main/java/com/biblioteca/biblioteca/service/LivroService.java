
package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.Livro;
import com.biblioteca.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public Livro cadastrar(Livro livro) {
        if (livro.getId() != null) {
            throw new IllegalArgumentException("Não informe um ID no cadastro!");
        }

        livro.setTitulo(livro.getTitulo());
        livro.setAutor(livro.getAutor());
        livro.setAnoPublicacao(livro.getAnoPublicacao());

        return repository.save(livro);
    }

    public List<Livro> listar() {
        return repository.findAll();
    }

    public List<Livro> buscar(String titulo) {
        return repository.findByTituloContainingIgnoreCase(titulo);
    }

    public Livro buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("Livro não encontrado!"));
    }

    public String emprestar(Long id) {
        Livro livro = buscarPorId(id);
        String mensagem = livro.emprestar();
        repository.save(livro);
        return mensagem;
    }

    public String devolver(Long id) {
        Livro livro = buscarPorId(id);
        String mensagem = livro.devolver();
        repository.save(livro);
        return mensagem;
    }

    public void excluir(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
}
