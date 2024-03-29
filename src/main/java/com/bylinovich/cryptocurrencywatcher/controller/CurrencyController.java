package com.bylinovich.cryptocurrencywatcher.controller;

import com.bylinovich.cryptocurrencywatcher.dto.CurrencyResponseDto;
import com.bylinovich.cryptocurrencywatcher.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/currency")
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping("/allCurrencies")
    public ResponseEntity<List<CurrencyResponseDto>> getAllCurrencies() {
        return ResponseEntity.ok().body(currencyService.findAllCurrencies());
    }

    @GetMapping("price/{symbol}")
    public ResponseEntity<String> getCurrencyBySymbol(@PathVariable String symbol) {
        return ResponseEntity.ok().body(currencyService.getPriceBySymbol(symbol));
    }
}
