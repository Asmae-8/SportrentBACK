package com.example.demo;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Random;
@CrossOrigin("*")

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired //pour l'injection des dependances
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;


	public DemoApplication(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Product.class, Category.class);
		categoryRepository.save(new Category("foot"));
		categoryRepository.save(new Category("Tennis"));
		categoryRepository.save(new Category("vollyball"));
		categoryRepository.save(new Category("surf"));

		Random rnd = new Random();

		categoryRepository.findAll().forEach(c -> {
			for (int i = 0; i < 10; i++) {
				Product p = new Product();
				User e = new User();
				p.setName(RandomString.make(10));
				p.setCurrentPrice(100 + rnd.nextInt(100));
				p.setAvailable(rnd.nextBoolean());
				p.setPromotion(rnd.nextBoolean());
				p.setSelected(rnd.nextBoolean());
				p.setCategory(c);
				p.setPeriod(RandomString.make(5));
				p.setPhoto("https://drive.google.com/file/d/1KFYyLmR0M9vbhRXBswaPmtANXjP_ACnB/view?usp=sharing");
				p.setPhotoName("sport.png");
				e.setAdresse("Agadir");
				e.setPassword("Asmae1998");
				e.setName("Asmae");
				e.setEmail("xxxxxx@gmail.com");

				//e.setPhoneNumber("00000000000");


				productRepository.save(p);
			}
		});
	}
}
