package dev.oliveiratec.dscatalog.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.oliveiratec.dscatalog.entities.Category;
import dev.oliveiratec.dscatalog.repositories.CategoryRepository;

@Service
public class CategoryService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<Category> findAll(){
		return repository.findAll();
	}
}