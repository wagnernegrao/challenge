package com.challenge.utils.validPassword;

import io.vavr.control.Either;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public abstract class ApprovalAuthority {
    private ApprovalAuthority next;

    public void nextChain(final ApprovalAuthority nextChain) {
        if (Objects.isNull(next)) {
            next = nextChain;
        } else {
            next.nextChain(nextChain);
        }
    }

    public Either<Boolean, String> process(final String password) {
        final Either<Boolean, String> handled = handle(password);

        if (handled.isRight() || Objects.isNull(next)) {
            return handled;
        }

        return next.process(password);
    }

    protected abstract Either<Boolean, String> handle(final String password);
}
