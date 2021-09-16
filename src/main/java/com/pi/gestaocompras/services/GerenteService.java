package com.pi.gestaocompras.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.pi.gestaocompras.entities.Gerente;
import com.pi.gestaocompras.repositories.GerenteRepository;
import com.pi.gestaocompras.services.exceptions.DatabaseException;
import com.pi.gestaocompras.services.exceptions.ResourceNotFoundException;

@Service
public class GerenteService {
	@Autowired
	private GerenteRepository repository;

	public List<Gerente> findAll() {
		return repository.findAll();
	}

	public Gerente findById(Long id) {
		Optional<Gerente> op = repository.findById(id);
		return op.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Gerente saveGerente(Gerente gerente) {
		return repository.save(gerente);
	}

	public void deleteGerente(Long id) {
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
	public Gerente updateGerente(Long id, Gerente gerente) {
		try {
			Gerente obj = repository.getOne(id);
			updateData(obj, gerente);
			return repository.save(obj);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Gerente obj, Gerente gerente) {

		obj.setNome(gerente.getNome());
		obj.setEmail(gerente.getEmail());
		obj.setSenha(gerente.getSenha());
		obj.setTelefone(gerente.getTelefone());
		obj.setLogin(gerente.getLogin());
		obj.getCotacaocompraitem().addAll(gerente.getCotacaocompraitem().stream().collect(Collectors.toList()));
		obj.getFuncionarios().addAll(gerente.getFuncionarios().stream().collect(Collectors.toList()));
	}

}
