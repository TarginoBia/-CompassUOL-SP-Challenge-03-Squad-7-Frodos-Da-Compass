package br.com.compassuol.pb.challenge.products.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private List<Product> products = new ArrayList<>();

	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		products.add(product);
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
		try {
			Product product = products.stream()
					.filter(p -> p.getId() == id)
					.findFirst()
					.orElseThrow(NoSuchElementException::new);
			return new ResponseEntity<>(product, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			throw new NotFoundException("Produto não encontrado");
		}
	}

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable("id") long id) {
		try {
			Product product = products.stream()
					.filter(p -> p.getId() == id)
					.findFirst()
					.orElseThrow(NoSuchElementException::new);
			products.remove(product);
			return new ResponseEntity<>("Product removed successfully", HttpStatus.OK);
		} catch (NoSuchElementException e) {
			throw new NotFoundException("Product not found");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProductById(@PathVariable("id") long id, @RequestBody Product updatedProduct) {
		try {
			Product product = products.stream()
					.filter(p -> p.getId() == id)
					.findFirst()
					.orElseThrow(NoSuchElementException::new);
			product.setName(updatedProduct.getName());
			product.setDescription(updatedProduct.getDescription());
			product.setImgURL(updatedProduct.getImgURL());
			product.setPrice(updatedProduct.getPrice());
			product.setCategory(updatedProduct.getCategory());
			return new ResponseEntity<>(product, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			throw new NotFoundException("Product not found");
		}
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class NotFoundException extends RuntimeException {
		public NotFoundException(String message) {
			super(message);
		}
	}

}


