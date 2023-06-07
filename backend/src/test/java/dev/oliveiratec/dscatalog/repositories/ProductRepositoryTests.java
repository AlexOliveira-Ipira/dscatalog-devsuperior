package dev.oliveiratec.dscatalog.repositories;


import dev.oliveiratec.dscatalog.entities.Product;
import dev.oliveiratec.dscatalog.factory.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@DataJpaTest
public class ProductRepositoryTests {
   @Autowired
    private ProductRepository repository;

   private long existingID;
   private long nonExistingId;
   private long countTotalProducts;

   @BeforeEach
   void setup() {
       existingID = 1L;
       nonExistingId = 1000L;
       countTotalProducts = 25L;
   }

   @Test
   public void saveShouldPersistWithAutoincrementWhenIdIsNull(){

       Product product = Factory.createProduct();
       product.setId(null);

       product = repository.save(product);

       Assertions.assertNotNull(product.getId());
       Assertions.assertEquals(countTotalProducts + 1 , product.getId());

   }
    @Test
    public void deleteShouldDeleteObjectWhenIdExists(){
        repository.deleteById(existingID);

        Optional<Product> result = repository.findById(existingID);
        Assertions.assertFalse(result.isPresent());

    }

    @Test
    public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist(){
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(nonExistingId);
        });
    }
}
