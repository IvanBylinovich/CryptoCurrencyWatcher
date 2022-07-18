package com.bylinovich.cryptocurrencywatcher.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class NoteResponseDto {
    private String id;
    private CurrencyResponseDto currency;
    private BigDecimal notedPrice;
}
