package com.example.guess_number_backend.services;

import com.example.guess_number_backend.constants.AppConstants;
import com.example.guess_number_backend.responseDTO.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AppService {
    public ResponseEntity<Response> checkGuess(int random,int guess){
        System.out.println(random+" "+guess);
        if(guess==random){
            return fetchOutput("You Won!",HttpStatus.OK.value(),AppConstants.WIN);
        }
        else if(guess<=random+5 && guess>=random-5){
            return fetchOutput("Close! Try Again",HttpStatus.OK.value(),AppConstants.AGAIN);
        }
        else if(guess<=random){
            return fetchOutput("Your guess is lesser than the number",HttpStatus.OK.value(),AppConstants.AGAIN);
        }
        return fetchOutput("Your guess is greater than the number",HttpStatus.OK.value(),AppConstants.AGAIN);
    }

    public ResponseEntity<Response> fetchOutput(String message, int status, AppConstants code){
        if(status==200){
           return ResponseEntity.ok(new Response(message,status,code));
        }
        else{
            return ResponseEntity.badRequest().body(new Response(message,status,code));
        }
    }
}
