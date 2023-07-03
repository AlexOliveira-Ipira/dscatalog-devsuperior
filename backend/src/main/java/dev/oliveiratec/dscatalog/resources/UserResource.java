package dev.oliveiratec.dscatalog.resources;

import dev.oliveiratec.dscatalog.dto.ProductDTO;
import dev.oliveiratec.dscatalog.dto.UserDTO;
import dev.oliveiratec.dscatalog.dto.UserInsertDTO;
import dev.oliveiratec.dscatalog.services.ProductService;
import dev.oliveiratec.dscatalog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<Page<UserDTO>> findAll(Pageable pageable){
		Page<UserDTO> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);	
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> findbyId(@PathVariable Long id){
		UserDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);	
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> insert(@RequestBody UserInsertDTO dto){
		UserDTO newDTO = service.inster(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(newDTO);
	}
	
	
	@PutMapping(value= "/{id}")
	public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);	
	}
	
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();	
	}
	
	
}
