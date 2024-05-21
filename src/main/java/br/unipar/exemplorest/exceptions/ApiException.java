package br.unipar.exemplorest.exceptions;

public class ApiException extends Exception{
    public ApiException(String message) {
        super(message);
    }
}
