package dev.oliveiratec.dscatalog.repositories;


import dev.oliveiratec.dscatalog.entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class ProductRepositoryTests {
   @Autowired
    private ProductRepository repository;

    @Test
    public void deleteShouldDeleteObjectWhenIdExists(){
        long existingID = 1L;
        repository.deleteById(existingID);

        Optional<Product> result = repository.findById(existingID);
        Assertions.assertFalse(result.isPresent());

    }
}
