# backend-challenge


## Como executar o projeto

Para executar o projeto, siga os seguintes passos:
1. Certifique-se de ter uma IDE Java instalada.
2. Faça o download do projeto utilizando o comando: ```git clone https://github.com/wagnernegrao/challenge.git.```
3. Após o download, abra o projeto em sua IDE.
4. Troque para a branch ```feature/chain-of-responsability``` e navegue até a pasta **challenge-api**.
5. Dependendo da IDE, as dependências serão baixadas automaticamente; caso contrário, execute o comando ```mvn clean install```.
6. Após o download das dependências, localize o arquivo **ChallengeApplication.java** e execute-o para iniciar a aplicação.

Com a aplicação rodando, você poderá realizar uma chamada REST para a API utilizando o seguinte comando curl:

```
curl --location --request POST 'http://localhost:8080/v1/validate' \
--header 'password: r@xnerO9TYB'
```


## Solução

Foi criado um endpoint para receber requisições do tipo POST, onde o password será enviado no header e validado. Para a validação da senha, optou-se pelo padrão de projeto Chain of Responsibility, que permite o processamento sequencial de cada etapa de validação até que um erro seja detectado ou o fluxo seja concluído com sucesso.

O fluxo de validação do código segue as seguintes etapas:

1. **ValidSize**: Valida se o tamanho da string atende ao mínimo requerido.
2. **ValidField**: Verifica se a senha contém pelo menos 1 número, 1 letra maiúscula, 1 letra minúscula e não possui espaços em branco.
3. **ValidSpecialCharacter**: Verifica se os caracteres especiais utilizados são permitidos.
4. **ValidUniqueValues**: Garante que não há repetição de caracteres.

A utilização do padrão Chain of Responsibility trouxe flexibilidade para o processo, permitindo a adição ou remoção de etapas de validação com facilidade. Por exemplo, uma nova validação pode ser inserida para checar no banco de dados se a senha atual é idêntica à anteriormente cadastrada. Além disso, ele facilita a inserção de métricas e logs em cada etapa do fluxo.

Como resposta, será enviado um campo booleano indicando se a senha é válida, acompanhado de uma mensagem explicando em qual etapa a validação falhou, conforme o exemplo abaixo:

```
{
    "message": "Senha válida",
    "valid": true
}

```