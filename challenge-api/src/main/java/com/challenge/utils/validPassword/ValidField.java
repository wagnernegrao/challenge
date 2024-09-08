package com.challenge.utils.validPassword;

import io.vavr.control.Either;

public class ValidField extends ApprovalAuthority {
    @Override
    public Either<Boolean, String> handle(final String password) {
        final String regex = "^(?!.*\\s)(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).+$";
        if (password.matches(regex)) {
            // Aqui colocaria uma métrica para contabilizar casos de erro.
            return Either.left(true);
        }
        // Aqui colocaria uma métrica para contabilizar casos de sucesso.
        return Either.right("A senha deve conter ao menos 1 digito, 1 letra maiúscula, 1 letra minúscula e não pode contar espaço em branco");
    }
}
