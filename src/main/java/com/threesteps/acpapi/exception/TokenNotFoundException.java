package com.threesteps.acpapi.exception;

public class TokenNotFoundException extends RuntimeException {

    public TokenNotFoundException() {
        super("Token not found!");
    }

}
