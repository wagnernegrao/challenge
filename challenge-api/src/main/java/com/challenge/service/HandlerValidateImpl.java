package com.challenge.service;

import com.challenge.utils.response.ResponseHandler;
import com.challenge.utils.validPassword.ApprovalAuthority;
import com.challenge.utils.validPassword.ValidField;
import com.challenge.utils.validPassword.ValidSize;
import com.challenge.utils.validPassword.ValidUniqueValues;
import com.challenge.utils.validPassword.ValidSpecialCharacter;
import io.vavr.control.Either;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HandlerValidateImpl implements HandlerValidate{
    private static final Logger LOGGER = LoggerFactory.getLogger(HandlerValidateImpl.class);

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
            // Aqui colocaria uma métrica para contabilizar casos de erro.
            LOGGER.error("Error validating password: {}", processed.get());
            return ResponseHandler.of(processed.isLeft(), processed.get());
        }
        // Aqui colocaria uma métrica para contabilizar casos de sucesso.
        return ResponseHandler.of(processed.isLeft());
    }
}
