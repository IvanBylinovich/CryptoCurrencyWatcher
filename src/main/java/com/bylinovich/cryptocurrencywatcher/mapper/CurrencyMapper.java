package com.bylinovich.cryptocurrencywatcher.mapper;

import com.bylinovich.cryptocurrencywatcher.dto.CurrencyRequestDto;
import com.bylinovich.cryptocurrencywatcher.dto.CurrencyResponseDto;
import com.bylinovich.cryptocurrencywatcher.entity.Currency;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CurrencyMapper {

    private final ModelMapper modelMapper;

    public CurrencyResponseDto toCurrencyResponseDto(Currency currency) {
        return modelMapper.map(currency, CurrencyResponseDto.class);
    }
}
