package com.bylinovich.cryptocurrencywatcher.service;

import com.bylinovich.cryptocurrencywatcher.dto.UserRequestDto;
import com.bylinovich.cryptocurrencywatcher.dto.UserResponseDto;

public interface UserService {

    UserResponseDto createUser(UserRequestDto section);
}
