package com.orbitelco.inventory.web.api;

import com.orbitelco.inventory.data.entity.Product;
import com.orbitelco.inventory.data.repository.ProductRepository;
import com.orbitelco.inventory.web.exception.BadRequestException;
import com.orbitelco.inventory.web.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductApiController {

  private final ProductRepository productRepository;

  public ProductApiController(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @GetMapping
  public List<Product> getAllProducts(){
    return this.productRepository.findAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Product addProduct(@RequestBody Product product){
    return this.productRepository.save(product);
  }

  @GetMapping("/{id}")
  public Product getProduct(@PathVariable("id")String id){
    Optional<Product> product = this.productRepository.findById(id);
    if (product.isEmpty()){
      throw new NotFoundException("product not found with id: " + id);
    }
    return product.get();
  }

  @PutMapping("/{id}")
  public Product updateProduct(@PathVariable("id")String id, @RequestBody Product product){
   if (id != product.getProductId()){
     throw new BadRequestException("id on path must match body");
   }
   return productRepository.save(product);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.RESET_CONTENT)
  public void deleteProduct(@PathVariable("id")String id){
    this.productRepository.deleteById(id);
  }
}
