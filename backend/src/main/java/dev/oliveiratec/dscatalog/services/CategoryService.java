package dev.oliveiratec.dscatalog.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.oliveiratec.dscatalog.dto.CategoryDTO;
import dev.oliveiratec.dscatalog.entities.Category;
import dev.oliveiratec.dscatalog.repositories.CategoryRepository;
import dev.oliveiratec.dscatalog.services.exceptions.EntityNotFoundException;

@Service
public class CategoryService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll(){
		List<Category> list = repository.findAll();
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public CategoryDTO findByid(Long id) {
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.orElseThrow(() -> new EntityNotFoundException("Id não encontrado"));
 		return new CategoryDTO(entity);
	}

	@Transactional
	public CategoryDTO inster(CategoryDTO dto) {
		Category entity = new Category();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new CategoryDTO(entity);
	}
}
