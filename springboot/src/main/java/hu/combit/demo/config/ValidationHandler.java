/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.combit.demo.config;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.validation.ConstraintViolation;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author krisztianfarkas
 */
@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler  {
    
    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
    public ResponseEntity<Object> handleValidationExceptions(ConstraintViolationException ex){
        Map ret = new HashMap<>();
        ex.getConstraintViolations().stream().forEach((error) -> {
            ret.put( error.getPropertyPath().toString(), error.getMessage());
        });
        return new ResponseEntity<>(ret, HttpStatus.BAD_REQUEST);
    }
    
}
