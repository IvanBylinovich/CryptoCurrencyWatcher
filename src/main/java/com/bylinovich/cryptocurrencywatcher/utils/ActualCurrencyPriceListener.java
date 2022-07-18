package com.bylinovich.cryptocurrencywatcher.utils;

import com.bylinovich.cryptocurrencywatcher.entity.Currency;
import com.bylinovich.cryptocurrencywatcher.repository.CurrencyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import static com.bylinovich.cryptocurrencywatcher.utils.Utils.URL_BTC_INFORMATION;
import static com.bylinovich.cryptocurrencywatcher.utils.Utils.URL_ETH_INFORMATION;
import static com.bylinovich.cryptocurrencywatcher.utils.Utils.URL_SOL_INFORMATION;

@RequiredArgsConstructor
@EnableScheduling
@Component
public class ActualCurrencyPriceListener {

    private final CurrencyRepository currencyRepository;
    private final Logger logger = LoggerFactory.getLogger(ActualCurrencyPriceListener.class);

    @Scheduled(fixedRate = 60_000)
    public void g() {
        ObjectMapper objectMapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        try {
            String BTC_JSON_INFO = restTemplate.getForObject(URL_BTC_INFORMATION, String.class);
            String ETH_JSON_INFO = restTemplate.getForObject(URL_ETH_INFORMATION, String.class);
            String SOL_JSON_INFO = restTemplate.getForObject(URL_SOL_INFORMATION, String.class);
            setActualPrice(BTC_JSON_INFO, objectMapper);
            setActualPrice(ETH_JSON_INFO, objectMapper);
            setActualPrice(SOL_JSON_INFO, objectMapper);
        } catch (JsonProcessingException e) {
            logger.warn(e.getMessage());
        } catch (HttpServerErrorException e) {
            logger.warn(e.getMessage());
        }
    }

    private void setActualPrice(String url, ObjectMapper objectMapper) throws JsonProcessingException {
        List<HashMap<String, String>> info = objectMapper.readValue(url, List.class);
        BigDecimal price = new BigDecimal(info.get(0).get("price_usd"));
        Currency currency = currencyRepository.findBySymbol(info.get(0).get("symbol")).get();
        currency.setPrice(price);
        currencyRepository.save(currency);
    }
}
