package com.challenge.utils.validPassword;

import io.vavr.control.Either;
import org.springframework.stereotype.Component;


/**
 * Explicação da Regex
 * ^ e $ são âncoras que garantem que a correspondência ocorra do início ao fim da string.
 * (?!.*\s) é um lookahead negativo que garante que a string não contenha nenhum espaço em branco. O \s corresponde a qualquer caractere de espaço em branco, e o lookahead negativo (?!.*\s) assegura que nenhum espaço em branco esteja presente.
 * (?=.*\d) é um lookahead positivo que garante que haja pelo menos um dígito na string (\d é um atalho para [0-9]).
 * (?=.*[a-z]) é um lookahead positivo que garante que haja pelo menos uma letra minúscula.
 * (?=.*[A-Z]) é um lookahead positivo que garante que haja pelo menos uma letra maiúscula.
 * .+ garante que a string tenha pelo menos um caractere após a validação dos lookaheads.
 * */


@Component
public class ValidField extends ApprovalAuthority {
    @Override
    public Either<Boolean, String> handle(final String password) {
        final String regex = "^(?!.*\\s)(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).+$";
        if (password.matches(regex)) {
            return Either.left(true);
        }
        return Either.right("A senha deve conter ao menos 1 digito, 1 letra maiúscula, 1 letra minúscula e não pode contar espaço em branco");
    }
}
