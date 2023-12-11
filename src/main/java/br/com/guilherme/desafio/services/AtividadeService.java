package br.com.guilherme.desafio.services;

import br.com.guilherme.desafio.dto.AtividadeCategoriaDTO;
import br.com.guilherme.desafio.dto.AtividadeDTO;
import br.com.guilherme.desafio.entities.Atividade;
import br.com.guilherme.desafio.entities.Categoria;
import br.com.guilherme.desafio.repositories.AtividadeRepository;
import br.com.guilherme.desafio.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    public AtividadeCategoriaDTO insert(@RequestBody AtividadeCategoriaDTO dto){
        Atividade entity = new Atividade();
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setPreco(dto.getPreco());

        Categoria categoria = categoriaRepository.getReferenceById(dto.getCategoria().getId());
        entity.setCategoria(categoria);
        entity = atividadeRepository.save(entity);
        return new AtividadeCategoriaDTO(entity);
    }

    public AtividadeDTO insert(@RequestBody AtividadeDTO dto){
        Atividade entity = new Atividade();
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setPreco(dto.getPreco());

        Categoria categoria = categoriaRepository.getReferenceById(dto.getCategoriaId());
        entity.setCategoria(categoria);
        entity = atividadeRepository.save(entity);
        return new AtividadeDTO(entity);
    }
}
