package webshop.web;

import webshop.DTO.PaymentDTO;
import webshop.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payments/{paymentNumber}")
    public ResponseEntity<?> getPayment(@PathVariable long paymentNumber) {
        PaymentDTO paymentDTO = paymentService.getPayment(paymentNumber);
        return new ResponseEntity<PaymentDTO>(paymentDTO, HttpStatus.OK);
    }

    @PostMapping("/payments")
    public ResponseEntity<?> addPayment(@RequestBody PaymentDTO paymentDTO) {
        paymentService.addPayment(paymentDTO);
        return new ResponseEntity<PaymentDTO> (paymentDTO,HttpStatus.OK);
    }

    @DeleteMapping("/payments/{paymentNumber}")
    public ResponseEntity<?> deletePayment(@PathVariable long paymentNumber) {
         paymentService.deletePayment(paymentNumber);
         return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/payments/{paymentNumber}")
    public ResponseEntity<?> updatePayment(@PathVariable long paymentNumber, @RequestBody PaymentDTO paymentDTO) {
        paymentService.updatePayment(paymentNumber,paymentDTO);
        return new ResponseEntity<PaymentDTO> (paymentDTO, HttpStatus.OK);
    }


}
