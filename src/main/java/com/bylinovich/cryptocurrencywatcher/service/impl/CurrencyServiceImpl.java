package com.bylinovich.cryptocurrencywatcher.service.impl;

import com.bylinovich.cryptocurrencywatcher.dto.CurrencyResponseDto;
import com.bylinovich.cryptocurrencywatcher.entity.Currency;
import com.bylinovich.cryptocurrencywatcher.exception.CurrencyNotFoundBySymbolException;
import com.bylinovich.cryptocurrencywatcher.mapper.CurrencyMapper;
import com.bylinovich.cryptocurrencywatcher.repository.CurrencyRepository;
import com.bylinovich.cryptocurrencywatcher.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final CurrencyMapper currencyMapper;

    @Override
    public List<CurrencyResponseDto> findAllCurrencies() {
        return currencyRepository.findAll().stream()
                .map(currencyMapper::toCurrencyResponseDto)
                .toList();
    }

    @Override
    public String getPriceBySymbol(String symbol) {
        Currency currency = currencyRepository.findBySymbol(symbol)
                .orElseThrow(() -> new CurrencyNotFoundBySymbolException(symbol));
        return currency.getPrice().toString();
    }
}
