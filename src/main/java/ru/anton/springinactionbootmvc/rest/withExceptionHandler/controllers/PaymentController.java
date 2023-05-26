package ru.anton.springinactionbootmvc.rest.withExceptionHandler.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.anton.springinactionbootmvc.rest.withExceptionHandler.exceptions.NotEnoughMoneyException;
import ru.anton.springinactionbootmvc.rest.withExceptionHandler.models.ErrorDetails;
import ru.anton.springinactionbootmvc.rest.withExceptionHandler.models.PaymentDetails;
import ru.anton.springinactionbootmvc.rest.withExceptionHandler.services.PaymentService;

@RestController
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment")
    public ResponseEntity<?> makePayment() {
        try {
            PaymentDetails paymentDetails = paymentService.processPayment();
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);
        }
        catch (NotEnoughMoneyException e) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("Not enough money to make the payment");
            return ResponseEntity
                    .badRequest()
                    .body(errorDetails);
        }
    }
}
