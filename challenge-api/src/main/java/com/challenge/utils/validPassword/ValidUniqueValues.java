package com.challenge.utils.validPassword;

import io.vavr.control.Either;

public class ValidUniqueValues extends ApprovalAuthority{
    @Override
    protected Either<Boolean, String> handle(String password) {
        final String regex = "^(?!.*(.).*\\1)[A-Za-z0-9!@#$%^&*]{9,30}$";
        if (password.matches(regex)) {
            return Either.left(true);
        }
        return Either.right("A senha não pode repetir caracteres");
    }
}
