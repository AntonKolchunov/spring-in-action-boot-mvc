package ru.anton.springinactionbootmvc.rest.withExceptionHandler.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.anton.springinactionbootmvc.rest.withExceptionHandler.exceptions.NotEnoughMoneyException;
import ru.anton.springinactionbootmvc.rest.withExceptionHandler.models.ErrorDetails;
import ru.anton.springinactionbootmvc.rest.withExceptionHandler.models.PaymentDetails;
import ru.anton.springinactionbootmvc.rest.withExceptionHandler.services.PaymentService;

import java.util.logging.Logger;

@RestController
public class PaymentController {
    private static Logger logger =
        Logger.getLogger(PaymentController.class.getName());

    @PostMapping("/payment")
    //@RequestBody используем на параметре метода, для того
    // чтобы тело запроса конвертировалось в этот параметр.
    //Например из JSON конвертируется в  объект PaymentDetails
    public ResponseEntity<PaymentDetails> makePayment(
            @RequestBody PaymentDetails paymentDetails //Отправляем с Postman
    ) {
        logger.info("Received payment " + paymentDetails.getAmount());
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);
    }
}