package com.bylinovich.cryptocurrencywatcher.mapper;

import com.bylinovich.cryptocurrencywatcher.dto.UserRequestDto;
import com.bylinovich.cryptocurrencywatcher.dto.UserResponseDto;
import com.bylinovich.cryptocurrencywatcher.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper modelMapper;

    public UserResponseDto toUserResponseDto(User user) {
        return modelMapper.map(user, UserResponseDto.class);
    }

    public User toUser(UserRequestDto user) {
        return modelMapper.map(user, User.class);
    }
}
