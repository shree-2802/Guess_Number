package com.example.guess_number_backend.responseDTO;

import com.example.guess_number_backend.constants.AppConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response {
    private String message;
    private int status;
    private AppConstants code;
}
