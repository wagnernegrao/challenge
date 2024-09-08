package com.challenge.controller;

import com.challenge.utils.response.ResponseHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidateControllerTest {

    private ValidateController validateController;

    @BeforeEach
    void setUp() {
        validateController = new ValidateController();
    }

    @Test
    void testValidatePasswordValid() {
        String password = "V@lid1Paswor!";
        ResponseHandler responseHandler = ResponseHandler.of(true);

        ResponseEntity<ResponseHandler> response = validateController.validatePassword(password);

        assertEquals(ResponseEntity.ok(responseHandler).getStatusCode(), response.getStatusCode());
        assertEquals(responseHandler.getMessage(), response.getBody().getMessage());
        assertTrue(response.getBody().isValid());
    }

    @Test
    void testValidatePasswordInvalid() {
        String password = "invalid";
        ResponseHandler responseHandler = ResponseHandler.of(false, "Não pode ser menor que 9 caracteres");

        ResponseEntity<ResponseHandler> response = validateController.validatePassword(password);

        assertEquals(ResponseEntity.badRequest().body(responseHandler).getStatusCode(), response.getStatusCode());
        assertEquals(responseHandler.getMessage(), response.getBody().getMessage());
        assertFalse(response.getBody().isValid());
    }
}