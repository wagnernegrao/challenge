package com.challenge.utils.validPassword;

import io.vavr.control.Either;

public class ValidUniqueValues extends ApprovalAuthority{
    @Override
    protected Either<Boolean, String> handle(String password) {
        final String regex = "^(?!.*(.).*\\1)[A-Za-z0-9!@#$%^&*]{9,30}$";
        if (password.matches(regex)) {
            // Aqui colocaria uma métrica para contabilizar casos de erro.
            return Either.left(true);
        }
        // Aqui colocaria uma métrica para contabilizar casos de sucesso.
        return Either.right("A senha não pode repetir caracteres");
    }
}
