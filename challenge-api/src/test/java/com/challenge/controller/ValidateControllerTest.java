package com.challenge.controller;

import com.challenge.service.HandlerValidate;
import com.challenge.utils.response.ResponseHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ValidateControllerTest {

    @Mock
    private HandlerValidate handlerValidate;

    @InjectMocks
    private ValidateController validateController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testValidatePasswordValid() {
        String password = "V@lid1Paswor!";
        ResponseHandler responseHandler = ResponseHandler.of(true);
        when(handlerValidate.isValid(password)).thenReturn(responseHandler);

        ResponseEntity<ResponseHandler> response = validateController.validatePassword(password);

        assertEquals(ResponseEntity.ok(responseHandler), response);
    }

    @Test
    void testValidatePasswordInvalid() {
        String password = "invalid";
        ResponseHandler responseHandler = ResponseHandler.of(false, "Invalid password");
        when(handlerValidate.isValid(password)).thenReturn(responseHandler);

        ResponseEntity<ResponseHandler> response = validateController.validatePassword(password);

        assertEquals(ResponseEntity.badRequest().body(responseHandler), response);
    }
}