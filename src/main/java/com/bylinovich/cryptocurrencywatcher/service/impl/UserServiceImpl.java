package com.bylinovich.cryptocurrencywatcher.service.impl;

import com.bylinovich.cryptocurrencywatcher.dto.UserRequestDto;
import com.bylinovich.cryptocurrencywatcher.dto.UserResponseDto;
import com.bylinovich.cryptocurrencywatcher.entity.Currency;
import com.bylinovich.cryptocurrencywatcher.entity.Note;
import com.bylinovich.cryptocurrencywatcher.entity.User;
import com.bylinovich.cryptocurrencywatcher.exception.CurrencyNotFoundBySymbolException;
import com.bylinovich.cryptocurrencywatcher.exception.UserAlreadyExistException;
import com.bylinovich.cryptocurrencywatcher.mapper.UserMapper;
import com.bylinovich.cryptocurrencywatcher.repository.CurrencyRepository;
import com.bylinovich.cryptocurrencywatcher.repository.NoteRepository;
import com.bylinovich.cryptocurrencywatcher.repository.UserRepository;
import com.bylinovich.cryptocurrencywatcher.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final NoteRepository noteRepository;
    private final CurrencyRepository currencyRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserResponseDto createUser(UserRequestDto userRequestDto) {

        if (userRepository.findUserByUsername(userRequestDto.getUsername()).isPresent()) {
            throw new UserAlreadyExistException(userRequestDto.getUsername());
        }
        User user = userMapper.toUser(userRequestDto);
        String symbol = userRequestDto.getCurrencyRequestDto().getSymbol();
        Currency currency = currencyRepository.findBySymbol(symbol)
                .orElseThrow(() -> new CurrencyNotFoundBySymbolException(symbol));
        Note note = new Note();
        note.setCurrency(currency);
        note.setNotedPrice(currency.getPrice());
        noteRepository.save(note);
        user.setNote(note);
        userRepository.save(user);
        return userMapper.toUserResponseDto(user);
    }
}
