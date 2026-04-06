package br.com.dsmeta.dsmeta.resource.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {



    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> resourceNotFound(Exception e) {

        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(404);
        err.setError("Resource not found");
        err.setMessage(e.getMessage());
        err.setPath("/movies");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
