package com.challenge.controller;

import com.challenge.service.HandlerValidate;
import com.challenge.service.HandlerValidateImpl;
import com.challenge.utils.response.ResponseHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@RequestMapping("/v1/validate")
public class ValidateController {
    private final HandlerValidate handlerValidate;

    public ValidateController() {
        this.handlerValidate = new HandlerValidateImpl();
    }

    @PostMapping
    public ResponseEntity<ResponseHandler> validatePassword(@RequestHeader("password") final String password) {
        final ResponseHandler response = handlerValidate.isValid(password);

        if (response.isValid()) {
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.badRequest().body(response);
    }

}
