package com.bylinovich.cryptocurrencywatcher.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserRequestDto {

    @NotBlank(message = "Username cannot be empty")
    private String username;

    @Valid
    @NotNull(message = "Currency cannot be empty")
    private CurrencyRequestDto currencyRequestDto;
}
