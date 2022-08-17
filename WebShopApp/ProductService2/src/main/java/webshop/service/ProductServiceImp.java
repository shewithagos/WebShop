package webshop.service;

import webshop.DTO.ProductAdapter;
import webshop.DTO.ProductDTO;
import webshop.domain.Product;
import webshop.kafka.Sender;
import webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService{

     @Autowired
    private ProductRepository productRepository;

     @Autowired
     Sender sender;

    @Override
    public ProductDTO getProduct(long productNumber) {
        Product product = productRepository.findById(productNumber);
        return ProductAdapter.getProductDTOFromProduct(product);
    }

    @Override
    public void addProduct(ProductDTO productDTO) {
        Product product = ProductAdapter.getProductFromProductDTO(productDTO);
        productRepository.save(product);

    }

    @Override
    public void deleteProduct(long productNumber) {
        Product product = productRepository.findById(productNumber);
        productRepository.delete(product);
    }

    @Override
    public void updateProduct(long productNumber, ProductDTO productDTO) {
        Product product = productRepository.findById(productNumber);
        product.setProductNumber(productDTO.getProductNumber());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setSupplier(productDTO.getSupplier());
        sender.send("product_topic",productDTO);

        productRepository.save(product);

    }
}
