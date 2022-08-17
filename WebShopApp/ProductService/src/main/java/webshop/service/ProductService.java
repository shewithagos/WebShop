package webshop.service;

import webshop.DTO.ProductDTO;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    public ProductDTO getProduct(long productNumber);
    public void addProduct(ProductDTO productDTO);
    public void deleteProduct(long productNumber);
    public void updateProduct(long productNumber, ProductDTO productDTO);
}
