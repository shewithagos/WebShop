package webshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {
	@Autowired
	private RestOperations restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String serverUrl = "http://localhost:8080/customers";

		// add customer
		Contact contact = new Contact("4546356354", "semir@gmail.com");
		Address address = new Address("altedorf str", "elmenhorst",23863);
		restTemplate.postForLocation(serverUrl, new CustomerDTO(1,"Harry",contact,address));

		// get customer
		CustomerDTO customer= restTemplate.getForObject(serverUrl+"/{productNumber}", CustomerDTO.class, "1");
		System.out.println("----------- get customer-----------------------");
		System.out.println(customer);

		String serverUrl1 = "http://localhost:8080/products";


		// add product 1
		Supplier supplier = new Supplier("Apple", "6213172763713");
		restTemplate.postForLocation(serverUrl1, new ProductDTO(10,"Iphone13", 800, supplier));

		// add product 2
		Supplier supplier1 = new Supplier("Samsung", "37988738783787");
		restTemplate.postForLocation(serverUrl1, new ProductDTO(11,"Samsung_S10", 700, supplier1));

		// get product 1
		ProductDTO product1= restTemplate.getForObject(serverUrl1+"/{productNumber}", ProductDTO.class, "10");
		ProductDTO product2= restTemplate.getForObject(serverUrl1+"/{productNumber}", ProductDTO.class, "11");
		System.out.println("----------- get products-----------------------");
		System.out.println(product1);
		System.out.println(product2);

		String serverUrl2 = "http://localhost:8080/orders";

		//add product
		  Product p1 = new Product(10,"Iphone13", 800, 2);
		  Product p2 = new Product(11,"Samsung_S10", 700, 3);
		  Customer cust = new Customer(1,"Semir");
		  List<Product> products = new ArrayList<>();
		  products.add(p1);
		  products.add(p2);

		restTemplate.postForLocation(serverUrl2, new OrderDTO(1, LocalDate.now(),products,cust));

		String serverUrl3 = "http://localhost:8080/orders/1";

		restTemplate.postForLocation(serverUrl3, new Payment(10, 3700));
//
		String serverUrl4 = "http://localhost:8080/order";

		// get order from query

		OrderDTO order= restTemplate.getForObject(serverUrl4+"/{orderNumber}", OrderDTO.class, "1");

		System.out.println("========== get Order ===================");
		System.out.println(order);

		// change Product name
		p1.setName("Iphone11");

		// change customer name
		cust.setName("Mire");

		// update payment
		//order.getPayment().setAmount(4000);

		//get the Order again

		OrderDTO order1= restTemplate.getForObject(serverUrl4+"/{orderNumber}", OrderDTO.class, "1");

		System.out.println("========== get updated Order ===================");
		System.out.println(order1);


	}


	@Bean
	RestOperations restTemplate() {
		return new RestTemplate();
	}
}
