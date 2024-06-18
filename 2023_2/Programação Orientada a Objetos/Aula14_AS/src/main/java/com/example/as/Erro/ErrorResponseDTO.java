package com.example.as.Erro;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
public class ErrorResponseDTO
{
    private String message;
    private List<String> errors;
    private LocalTime data = LocalTime.now();

    public ErrorResponseDTO(String message, List<String> errors)
    {
        this.message = message;
        this.errors = errors;
    }
}