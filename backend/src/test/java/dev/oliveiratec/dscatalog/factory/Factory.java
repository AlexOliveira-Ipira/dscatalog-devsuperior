package dev.oliveiratec.dscatalog.factory;

import dev.oliveiratec.dscatalog.dto.ProductDTO;
import dev.oliveiratec.dscatalog.entities.Category;
import dev.oliveiratec.dscatalog.entities.Product;

import java.time.Instant;

public class Factory {
    public static Product createProduct() {
        Product product = new Product(1L, "Phone", "Good Phonr", 800.0, "https://img.com/img.png", Instant.parse("2023-06-07T03:00:00z"));
        product.getCategories().add(new Category(2L, "Electronics"));
        return product;
    }

    public static ProductDTO creatProductDTO(){
        Product product = createProduct();
        return new ProductDTO(product, product.getCategories());
    }

    public static Category crateCategory(){
        return new Category(2L, "Electronics");
    }
}
