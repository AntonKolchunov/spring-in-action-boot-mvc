package ru.anton.springinactionbootmvc.rest.withExceptionHandler.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.anton.springinactionbootmvc.rest.withExceptionHandler.exceptions.NotEnoughMoneyException;
import ru.anton.springinactionbootmvc.rest.withExceptionHandler.models.ErrorDetails;

@RestControllerAdvice
//Реализует аспект для перехвата и обработа исключений рест контроллера
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    //обработчик исключений, перехватывает все исключения типа NotEnoughMoneyException
    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Not enough money to make the payment");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}
