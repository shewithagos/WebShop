package webshop.web;

import webshop.DTO.ProductDTO;
import webshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{productNumber}")
    public ResponseEntity<?> getProduct(@PathVariable long productNumber) {
        ProductDTO productDTO = productService.getProduct(productNumber);
        return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@RequestBody ProductDTO productDTO) {
        productService.addProduct(productDTO);
        return new ResponseEntity<ProductDTO> (productDTO, HttpStatus.OK);
    }

    @DeleteMapping("/products/{productNumber}")
    public ResponseEntity<?> deleteProduct(@PathVariable long productNumber) {
        productService.deleteProduct(productNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/products/{productNumber}")
    public ResponseEntity<?> updateProduct(@PathVariable long productNumber, @RequestBody ProductDTO productDTO) {
        productService.updateProduct(productNumber,productDTO);
        return new ResponseEntity<ProductDTO> (productDTO, HttpStatus.OK);
    }

}
