package webshop.web;

import webshop.DTO.OrderDTO;
import webshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderQueriesController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order/{orderNumber}")
    public ResponseEntity<?> getOrder(@PathVariable long orderNumber) {
        OrderDTO orderDTO = orderService.getOrder(orderNumber);
        return new ResponseEntity<OrderDTO>(orderDTO, HttpStatus.OK);
    }

}
