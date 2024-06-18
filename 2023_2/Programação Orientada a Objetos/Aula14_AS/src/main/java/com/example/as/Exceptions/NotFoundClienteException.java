package com.example.as.Exceptions;

public class NotFoundClienteException extends RuntimeException
{
    public NotFoundClienteException()
    {
        super("Não foi encontrado nenhum cliente.");
    }
}