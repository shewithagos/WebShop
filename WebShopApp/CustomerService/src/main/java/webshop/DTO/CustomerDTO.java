package webshop.DTO;

import webshop.domain.Address;
import webshop.domain.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private long customerNumber;
    private String name;
    private Contact contact;
    private Address address;
}
