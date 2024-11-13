package com.gerenciamento.Gerenciamento.Service;

import com.gerenciamento.Gerenciamento.Models.Categoria;
import com.gerenciamento.Gerenciamento.Models.Receita;
import com.gerenciamento.Gerenciamento.Models.Usuario;
import com.gerenciamento.Gerenciamento.Outputs.CategoriaOutput;
import com.gerenciamento.Gerenciamento.Outputs.ReceitaOutput;
import com.gerenciamento.Gerenciamento.Repository.CategoriaRepository;
import com.gerenciamento.Gerenciamento.Repository.ReceitaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public CategoriaOutput cadastrarCategoria(Categoria input) {
        return new CategoriaOutput(repository.save(input));
    }

    public List<CategoriaOutput> listarCategorias() {
        List<Categoria> categorias = repository.findAll();
        List<CategoriaOutput> lista = new ArrayList<>();
        for (Categoria categoria: categorias) {
            lista.add(new CategoriaOutput(categoria));
        }
        return lista;
    }

    public Categoria buscarCategoriaPorId(Long id) {
        return repository.findById(id).
                orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }
}
