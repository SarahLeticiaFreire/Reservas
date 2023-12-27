package com.example.demo.infra.exceptions;

public class LimiteReservasExcedidoException extends RuntimeException {

    public LimiteReservasExcedidoException(String message) {
        super(message);
    }
}
