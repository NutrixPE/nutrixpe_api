package com.nutrixpe.nutrixpe_api.controller;

import com.nutrixpe.nutrixpe_api.exception.OutofRangeException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
        @ExceptionHandler(value = { OutofRangeException.class })
        public ResponseEntity<Object> OutofRangeException(OutofRangeException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
