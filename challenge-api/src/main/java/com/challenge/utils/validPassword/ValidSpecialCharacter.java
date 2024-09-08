package com.challenge.utils.validPassword;

import io.vavr.control.Either;

public class ValidSpecialCharacter extends ApprovalAuthority{
    @Override
    protected Either<Boolean, String> handle(String password) {
        final String regex = "^(?=.*[!@#$%^&*()\\-\\+]).+$";
        if (password.matches(regex)) {
            // Aqui colocaria uma métrica para contabilizar casos de erro.
            return Either.left(true);
        }
        // Aqui colocaria uma métrica para contabilizar casos de sucesso.
        return Either.right("A senha deve conter caracteres especiais como !@#$%^&*()-+");
    }
}
