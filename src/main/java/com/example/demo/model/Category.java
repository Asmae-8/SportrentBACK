package com.example.demo.model;

import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@CrossOrigin("*")
@NoArgsConstructor @AllArgsConstructor @ToString
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String photo ;
    private String name ;
    private String description ;
    @OneToMany(mappedBy = "category")

    private Collection<Product> products ;



	/*public Category() {
		super();
		// TODO Auto-generated constructor stub
	}*/

	public Category(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}
