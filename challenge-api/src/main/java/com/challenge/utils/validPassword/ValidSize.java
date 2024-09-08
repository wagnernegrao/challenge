package com.challenge.utils.validPassword;

import io.vavr.control.Either;
import org.springframework.stereotype.Component;

@Component
public class ValidSize extends ApprovalAuthority {
    public static final int MINIMUM_SIZE = 9;

    @Override
    public Either<Boolean, String> handle(final String password) {
        if (password.length() < MINIMUM_SIZE) {
            // Aqui colocaria uma métrica para contabilizar casos de erro.
            return Either.right("Não pode ser menor que 9 caracteres");
        }
        // Aqui colocaria uma métrica para contabilizar casos de sucesso.
        return Either.left(true);
    }
}
