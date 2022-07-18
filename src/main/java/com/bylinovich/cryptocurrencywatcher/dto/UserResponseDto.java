package com.bylinovich.cryptocurrencywatcher.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private String id;
    private String username;
    private NoteResponseDto note;
}
