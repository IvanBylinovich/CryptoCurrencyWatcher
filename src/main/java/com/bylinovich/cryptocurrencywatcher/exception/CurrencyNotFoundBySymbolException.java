package com.bylinovich.cryptocurrencywatcher.exception;

public class CurrencyNotFoundBySymbolException extends RuntimeException {
    public CurrencyNotFoundBySymbolException(String symbol) {
        super(String.format("Currency not found by symbol [%s]", symbol));
    }
}
