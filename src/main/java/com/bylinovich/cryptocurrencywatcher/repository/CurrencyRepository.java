package com.bylinovich.cryptocurrencywatcher.repository;

import com.bylinovich.cryptocurrencywatcher.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, String> {

    Optional<Currency> findBySymbol(String symbol);
}
