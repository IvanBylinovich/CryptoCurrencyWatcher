package com.bylinovich.cryptocurrencywatcher.utils;

import com.bylinovich.cryptocurrencywatcher.entity.Note;
import com.bylinovich.cryptocurrencywatcher.entity.User;
import com.bylinovich.cryptocurrencywatcher.repository.NoteRepository;
import com.bylinovich.cryptocurrencywatcher.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@EnableScheduling
@RequiredArgsConstructor
@Component
public class PriceChangeListener {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(PriceChangeListener.class);


    @Scheduled(fixedRate = 1_000)
    public void reportCurrentTime() {

        List<Note> notes = noteRepository.findAll();

        for (Note note : notes) {
            BigDecimal price = note.getCurrency().getPrice();
            BigDecimal notedPrise = note.getNotedPrice();
            BigDecimal change = price.subtract(notedPrise);
            BigDecimal onePercentFromNotedPrise = notedPrise.divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
            BigDecimal percentageChange = change.divide(onePercentFromNotedPrise, 2, RoundingMode.HALF_UP);
            if (percentageChange.compareTo(BigDecimal.ONE) > 0 || percentageChange.compareTo(new BigDecimal(-1)) < 0) {
                User user = userRepository.findUserByNote(note);
                logger.warn(note.getCurrency().getSymbol() + ", "
                        + user.getUsername() + ", "
                        + percentageChange + "%");
            }
        }
    }
}
