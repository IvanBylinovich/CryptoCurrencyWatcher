package com.bylinovich.cryptocurrencywatcher.controller;

import com.bylinovich.cryptocurrencywatcher.dto.UserRequestDto;
import com.bylinovich.cryptocurrencywatcher.dto.UserResponseDto;
import com.bylinovich.cryptocurrencywatcher.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/notify")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody @Valid UserRequestDto userRequestDto) {
        return ResponseEntity.ok().body(userService.createUser(userRequestDto));
    }
}
