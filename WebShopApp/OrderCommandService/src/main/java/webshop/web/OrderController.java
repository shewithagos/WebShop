package webshop.web;

import webshop.DTO.OrderDTO;
import webshop.domain.Payment;
import webshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

//    @GetMapping("/orders/{orderNumber}")
//    public ResponseEntity<?> getOrder(@PathVariable long orderNumber) {
//        OrderDTO orderDTO = orderService.getOrder(orderNumber);
//        return new ResponseEntity<OrderDTO>(orderDTO, HttpStatus.OK);
//    }

    @PostMapping("/orders")
    public ResponseEntity<?> placeOrder(@RequestBody OrderDTO orderDTO) {
        orderService.placeOrder(orderDTO);
        return new ResponseEntity<OrderDTO>(orderDTO,HttpStatus.OK);
    }

    @PostMapping("/orders/{orderNumber}")
    public ResponseEntity<?> addPayment(@PathVariable long orderNumber, @RequestBody Payment payment){
        OrderDTO orderDTO = orderService.getOrder(orderNumber);
          orderService.addPayment(orderNumber,payment);
          return new ResponseEntity<OrderDTO>(orderDTO,HttpStatus.OK);
    }
}
