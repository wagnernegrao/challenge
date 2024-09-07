package com.challenge.service;

import com.challenge.utils.response.ResponseHandler;
import com.challenge.utils.validPassword.ApprovalAuthority;
import com.challenge.utils.validPassword.ValidField;
import com.challenge.utils.validPassword.ValidSize;
import com.challenge.utils.validPassword.ValidUniqueValues;
import com.challenge.utils.validPassword.ValidSpecialCharacter;
import io.vavr.control.Either;
import org.springframework.stereotype.Service;

@Service
public class HandlerValidate {


    /**
     * Considere uma senha sendo válida quando a mesma possuir as seguintes definições:
     *
     * Nove ou mais caracteres -- OK
     * Ao menos 1 dígito -- OK
     * Ao menos 1 letra minúscula -- OK
     * Ao menos 1 letra maiúscula -- OK
     * Ao menos 1 caractere especial --
     *  Considere como especial os seguintes caracteres: !@#$%^&*()-+
     * Não possuir caracteres repetidos dentro do conjunto
     * */

    private ApprovalAuthority processValidate() {
        final ApprovalAuthority chain = new ValidSize();
        chain.nextChain(new ValidField());
        chain.nextChain(new ValidSpecialCharacter());
        chain.nextChain(new ValidUniqueValues());
        return chain;
    }

    public ResponseHandler isValid(final String password) {
        final Either<Boolean, String> processed = processValidate().process(password);

        if (processed.isRight()) {
            return ResponseHandler.of(processed.isLeft(), processed.get());
        }

        return ResponseHandler.of(processed.isLeft());
    }
}
