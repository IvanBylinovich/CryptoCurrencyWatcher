package com.bylinovich.cryptocurrencywatcher.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

import static com.bylinovich.cryptocurrencywatcher.utils.Utils.DATE_TIME_EXCEPTION_PATTERN;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomErrorResponseForMethodArgumentNotValidException {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_EXCEPTION_PATTERN)
    private ZonedDateTime timestamp;
    private int status;
    private List<String> errors;
}
