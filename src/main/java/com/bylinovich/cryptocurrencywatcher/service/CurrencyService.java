package com.bylinovich.cryptocurrencywatcher.service;

import com.bylinovich.cryptocurrencywatcher.dto.CurrencyResponseDto;

import java.util.List;

public interface CurrencyService {

    List<CurrencyResponseDto> findAllCurrencies();

    String getPriceBySymbol(String symbol);
}
