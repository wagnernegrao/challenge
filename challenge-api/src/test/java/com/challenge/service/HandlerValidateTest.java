package com.challenge.service;

import com.challenge.utils.response.ResponseHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HandlerValidateTest {

    private HandlerValidate handlerValidate;

    @BeforeEach
    void setUp() {
        handlerValidate = new HandlerValidate();
    }

    @Test
    void testValidPassword() {
        String validPassword = "V@lid1paswor!";
        ResponseHandler response = handlerValidate.isValid(validPassword);
        assertTrue(response.isValid());
        assertEquals("Senha válida", response.getMessage());
    }

    @Test
    void testPasswordTooShort() {
        String shortPassword = "Short1!";
        ResponseHandler response = handlerValidate.isValid(shortPassword);
        assertFalse(response.isValid());
        assertEquals("Não pode ser menor que 9 caracteres", response.getMessage());
    }

    @Test
    void testPasswordMissingDigit() {
        String password = "NoDigitPassword!";
        ResponseHandler response = handlerValidate.isValid(password);
        assertFalse(response.isValid());
        assertEquals("A senha deve conter ao menos 1 digito, 1 letra maiúscula, 1 letra minúscula e não pode contar espaço em branco", response.getMessage());
    }

    @Test
    void testPasswordMissingUpperCase() {
        String password = "nouppercase1!";
        ResponseHandler response = handlerValidate.isValid(password);
        assertFalse(response.isValid());
        assertEquals("A senha deve conter ao menos 1 digito, 1 letra maiúscula, 1 letra minúscula e não pode contar espaço em branco", response.getMessage());
    }

    @Test
    void testPasswordMissingLowerCase() {
        String password = "NOLOWERCASE1!";
        ResponseHandler response = handlerValidate.isValid(password);
        assertFalse(response.isValid());
        assertEquals("A senha deve conter ao menos 1 digito, 1 letra maiúscula, 1 letra minúscula e não pode contar espaço em branco", response.getMessage());
    }

    @Test
    void testPasswordMissingSpecialCharacter() {
        String password = "NoSpecialChar1";
        ResponseHandler response = handlerValidate.isValid(password);
        assertFalse(response.isValid());
        assertEquals("A senha deve conter caracteres especiais como !@#$%^&*()-+", response.getMessage());
    }

    @Test
    void testPasswordWithRepeatedCharacters() {
        String password = "Repeat1Repeat!";
        ResponseHandler response = handlerValidate.isValid(password);
        assertFalse(response.isValid());
        assertEquals("A senha não pode repetir caracteres", response.getMessage());
    }
}
