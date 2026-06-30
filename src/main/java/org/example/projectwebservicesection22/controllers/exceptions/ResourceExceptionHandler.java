package org.example.projectwebservicesection22.controllers.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.example.projectwebservicesection22.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException rnfe, HttpServletRequest req){
        String error = "Resource not found.";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, rnfe.getMessage(), req.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
