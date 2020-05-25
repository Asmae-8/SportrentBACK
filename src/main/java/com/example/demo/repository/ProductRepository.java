package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
 @RestResource(path="/selectedProducts")
 public List<Product> findBySelectedTrue();
 @RestResource(path="/productsByKeyword")
 public List<Product> findByNameContains(@Param("mc") String mc);
 @RestResource(path="/promoProducts")
 public List<Product> findByPromotionIsTrue();
 @RestResource(path="/dispoProducts")
 public List<Product> findByAvailableIsTrue();

 //@Query("select p from Product p where p.name like :x")
 //public List<Product> chercher(@Param("x")String mc );
}
