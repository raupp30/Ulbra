package com.example.as.Exceptions;
import com.example.as.Erro.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.ArrayList;

@ControllerAdvice
public class HandleCustomException
{
    @ExceptionHandler(NotFoundClienteException.class)
    public ResponseEntity<ErrorResponseDTO> handleNotFoundClienteException(NotFoundClienteException exception)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDTO(exception.getMessage(), new ArrayList<>()));
    }
}