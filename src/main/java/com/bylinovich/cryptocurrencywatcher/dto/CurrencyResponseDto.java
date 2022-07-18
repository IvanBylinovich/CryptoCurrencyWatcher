package com.bylinovich.cryptocurrencywatcher.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CurrencyResponseDto {
    private String id;
    private String symbol;
    private BigDecimal price;
}
