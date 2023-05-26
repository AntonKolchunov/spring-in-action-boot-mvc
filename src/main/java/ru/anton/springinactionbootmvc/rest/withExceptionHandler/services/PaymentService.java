package ru.anton.springinactionbootmvc.rest.withExceptionHandler.services;

import org.springframework.stereotype.Service;
import ru.anton.springinactionbootmvc.rest.withExceptionHandler.exceptions.NotEnoughMoneyException;
import ru.anton.springinactionbootmvc.rest.withExceptionHandler.models.PaymentDetails;

@Service
public class PaymentService {

    public PaymentDetails processPayment() {
        //сразу выкидываем исключение
        throw new NotEnoughMoneyException();
    }
}
