package webshop;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private long productNumber;
    private String name;
    private double price;
    private Supplier supplier;
}
