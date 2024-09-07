//package com.challenge.utils;
//
//import com.challenge.utils.validPassword.*;
//
//import io.vavr.control.Either;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ApprovalAuthorityTest {
//
//    private ApprovalAuthority validSize;
//    private ApprovalAuthority validField;
//    private ApprovalAuthority validSpecialCharacter;
//    private ApprovalAuthority validUniqueValues;
//
//    @BeforeEach
//    void setUp() {
//        validSize = new ValidSize();
//        validField = new ValidField();
//        validSpecialCharacter = new ValidSpecialCharacter();
//        validUniqueValues = new ValidUniqueValues();
//
//        validSize.nextChain(validField);
//        validField.nextChain(validSpecialCharacter);
//        validSpecialCharacter.nextChain(validUniqueValues);
//    }
//
//    @Test
//    void testValidPassword() {
//        String validPassword = "V@lid1paswor!";
//        Either<Boolean, String> result = validSize.process(validPassword);
//        assertTrue(result.isLeft());
//    }
//
//    @Test
//    void testPasswordTooShort() {
//        String shortPassword = "Short1!";
//        Either<Boolean, String> result = validSize.process(shortPassword);
//        assertTrue(result.isRight());
//        assertEquals("Não pode ser menor que 9 caracteres", result.get());
//    }
//
//    @Test
//    void testPasswordMissingDigit() {
//        String password = "NoDigitPassword!";
//        Either<Boolean, String> result = validSize.process(password);
//        assertTrue(result.isRight());
//        assertEquals("A senha deve conter ao menos 1 digito, 1 letra maiúscula, 1 letra minúscula e não pode contar espaço em branco", result.get());
//    }
//
//    @Test
//    void testPasswordMissingUpperCase() {
//        String password = "nouppercase1!";
//        Either<Boolean, String> result = validSize.process(password);
//        assertTrue(result.isRight());
//        assertEquals("A senha deve conter ao menos 1 digito, 1 letra maiúscula, 1 letra minúscula e não pode contar espaço em branco", result.get());
//    }
//
//    @Test
//    void testPasswordMissingLowerCase() {
//        String password = "NOLOWERCASE1!";
//        Either<Boolean, String> result = validSize.process(password);
//        assertTrue(result.isRight());
//        assertEquals("A senha deve conter ao menos 1 digito, 1 letra maiúscula, 1 letra minúscula e não pode contar espaço em branco", result.get());
//    }
//
//    @Test
//    void testPasswordMissingSpecialCharacter() {
//        String password = "NoSpecialChar1";
//        Either<Boolean, String> result = validSize.process(password);
//        assertTrue(result.isRight());
//        assertEquals("A senha deve conter caracteres especiais como !@#$%^&*()-+", result.get());
//    }
//
//    @Test
//    void testPasswordWithRepeatedCharacters() {
//        String password = "Repeat1Repeat!";
//        Either<Boolean, String> result = validSize.process(password);
//        assertTrue(result.isRight());
//        assertEquals("A senha não pode repetir caracteres", result.get());
//    }
//}
