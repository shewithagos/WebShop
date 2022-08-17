package webshop.DTO;

import webshop.domain.Product;

public class ProductAdapter {
    public static Product getProductFromProductDTO(ProductDTO productDTO) {
        Product product = new Product(productDTO.getProductNumber(), productDTO.getName(),
                productDTO.getPrice(),productDTO.getSupplier());
        return product;
    }

    public static ProductDTO getProductDTOFromProduct(Product product) {
        ProductDTO productDTO = new ProductDTO(product.getProductNumber(),product.getName(),
                product.getPrice(),product.getSupplier());
        return productDTO;
    }
}
