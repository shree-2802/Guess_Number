package com.example.guess_number_backend.controller;

import com.example.guess_number_backend.constants.AppConstants;
import com.example.guess_number_backend.responseDTO.Response;
import com.example.guess_number_backend.services.AppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("guessnumber")
@CrossOrigin()
@RestController
public class AppController {
    private static int random;
    private static int count=0;
    private final AppService appService;

    public AppController(AppService appService){
        this.appService=appService;
        this.random=(int)(Math.random()*100);
    }

    @GetMapping("/guess/{guess}")
    public ResponseEntity<Response> guessNumber(@PathVariable int guess){
        System.out.println(guess+" guess");
        ResponseEntity<Response> res=appService.checkGuess(random,guess);
        count++;
        if(res.getBody().getCode().equals(AppConstants.WIN) || count>=5){
            if(count>=5 && !res.getBody().getCode().equals(AppConstants.WIN)){
                res.getBody().setMessage("Sorry love, You Lose!");
                res.getBody().setCode(AppConstants.LOST);
            }
            this.random=(int)(Math.random()*100);
            count=0;
        }
        return res;
    }
}
