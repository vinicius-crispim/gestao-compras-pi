package com.pi.gestaocompras.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.pi.gestaocompras.entities.Produto;
import com.pi.gestaocompras.repositories.ProdutoRepository;
import com.pi.gestaocompras.services.exceptions.DatabaseException;
import com.pi.gestaocompras.services.exceptions.ResourceNotFoundException;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repository;

	public List<Produto> findAll() {
		return repository.findAll();
	}

	public Produto findById(Long id) {
		Optional<Produto> op = repository.findById(id);
		return op.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Produto saveProduto(Produto produto) {
		return repository.save(produto);
	}

	public void deleteProduto(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	// getOne apenas pega o objeto monitorado e depois mexe no banco, o findBy pega
	// no banco
	public Produto updateProduto(Long id, Produto produto) {
		try {
			Produto obj = repository.getOne(id);
			updateData(obj, produto);
			return repository.save(obj);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Produto obj, Produto produto) {

		obj.setNome(produto.getNome());
		obj.setDescrição(produto.getDescrição());
		obj.setEstoque(produto.getEstoque());
		obj.setQuantidademin(produto.getQuantidademin());
		obj.getCotacaocompraitens().addAll(produto.getCotacaocompraitens().stream().collect(Collectors.toList()));
		obj.getNotafiscalitem().addAll(produto.getNotafiscalitem().stream().collect(Collectors.toList()));
		obj.getOrdemcompraitem().addAll(produto.getOrdemcompraitem().stream().collect(Collectors.toList()));		
	}

}
