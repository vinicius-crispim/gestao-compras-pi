package com.pi.gestaocompras.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pi.gestaocompras.entities.Gerente;
import com.pi.gestaocompras.services.GerenteService;

@RestController
@RequestMapping(value = "/gerentes")
public class GerenteResource {
	@Autowired
	private GerenteService service;

	@GetMapping
	public ResponseEntity<List<Gerente>> findAll(){

		List<Gerente> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//caso inserir uma barra e um id, ele faz esta busca
	@GetMapping(value="/{id}")
	public ResponseEntity<Gerente> findById(@PathVariable Long id){
		Gerente u = service.findById(id);
		return ResponseEntity.ok().body(u);
	}
	
	//Post para inserir no banco
	//RequestBody para informar que o objeto vai chegar no modo Json
	@PostMapping
	public ResponseEntity<Gerente> saveGerente(@RequestBody Gerente gerente){
		gerente = service.saveGerente(gerente);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(gerente.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(gerente);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteGerente(@PathVariable Long id){
		service.deleteGerente(id);		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Gerente> updateGerente(@PathVariable Long id, @RequestBody Gerente gerente){
		gerente = service.updateGerente(id, gerente);
		return ResponseEntity.ok().body(gerente);
	}
	

}
