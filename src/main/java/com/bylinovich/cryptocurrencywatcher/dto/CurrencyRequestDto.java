package com.bylinovich.cryptocurrencywatcher.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CurrencyRequestDto {

    @NotBlank(message = "Name of the currency cannot be empty")
    private String symbol;
}
