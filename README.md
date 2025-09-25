# Prova - Interpretador de Linguagem Simples

Universidade do Vale do Rio dos Sinos (UNISINOS)  
Curso de Ciência da Computação  
Trabalho desenvolvido para a disciplina de Tradutores  
Alunos: Benjamin Vichel, Leonardo Ramos e Lucas Kappes  
Professor: Vinicius Bischoff

Este projeto implementa um interpretador para uma linguagem de programação simples, utilizando ANTLR4 para geração do analisador léxico e sintático. O objetivo é demonstrar conceitos de análise sintática, interpretação de comandos e estruturas de controle como `if`, `else`, e `switch`.

## O que o projeto faz

O interpretador reconhece e processa comandos de atribuição, expressões aritméticas e lógicas, blocos condicionais (`if`/`else`), e estruturas de seleção múltipla (`switch/case/default`). Ele percorre a árvore sintática gerada pelo ANTLR e imprime informações sobre cada construção encontrada no código de entrada.

## Como rodar o projeto

1. **Pré-requisitos:**  
   - Java 17 ou superior  
   - Maven

2. **Compilar o projeto:**  
   No terminal, execute:
   ```
   mvn clean compile
   ```

3. **Executar o interpretador:**  
   Ainda no terminal, execute:
   ```
   mvn exec:java
   ```
   O interpretador irá processar o código de exemplo definido na classe `Main.java` e imprimir no console as estruturas reconhecidas.

## Sobre a implementação

- **ANTLR4:**  
  O arquivo `Prova.g4` define a gramática da linguagem, incluindo regras para expressões, comandos de atribuição, blocos condicionais e seleção múltipla.

- **Main.java:**  
  Responsável por inicializar o lexer, parser e executar o interpretador sobre um código de exemplo.

- **Interpreter.java:**  
  Implementa um visitor que percorre a árvore sintática e imprime informações sobre cada comando ou expressão encontrada.

- **pom.xml:**  
  Configura o uso do ANTLR4 e o plugin de execução do Maven.

## Exemplo de código interpretado

```plaintext
x = 10;
y = 20;

minhaVariavelGrande = x + y;

if (minhaVariavelGrande > 15) {
    resultado = minhaVariavelGrande - 5;
} else if (!resultado < 10 && x > 10) {
    resultado = minhaVariavelGrande * 2;
} else {
    resultado = minhaVariavelGrande + 5;
}

switch (resultado) {
    case 25 {
        mensagem = "Resultado é 25";
    }
    case 30 {
        mensagem = "Resultado é 30";
    }
    default {
        mensagem = "Resultado é outro valor";
    }
}
```

## Exemplo de saída (resultados)

```plaintext
Atribuição encontrada. Identificador: x, Valor: 10
Literal encontrado: 10
Atribuição encontrada. Identificador: y, Valor: 20
Literal encontrado: 20
Atribuição encontrada. Identificador: minhaVariavelGrande, Valor: x + y
Operador + encontrado. Valores x y
Identificador encontrado: x
Identificador encontrado: y
Bloco condicional encontrado. Condição: (minhaVariavelGrande > 15)
Operador 'maior que' encontrado. Valores minhaVariavelGrande 15
Identificador encontrado: minhaVariavelGrande
Literal encontrado: 15
Bloco de código entre chaves encontrado
Atribuição encontrada. Identificador: resultado, Valor: minhaVariavelGrande - 5
Operador - encontrado. Valores minhaVariavelGrande 5
Identificador encontrado: minhaVariavelGrande
Literal encontrado: 5
Bloco 'else' encontrado
Bloco condicional encontrado. Condição: (!resultado < 10 && x > 10)
Operador lógico AND encontrado. Valores !resultado < 10 x > 10
Operador 'maior que' encontrado. Valores x 10
Identificador encontrado: x
Literal encontrado: 10
Operador 'menor que' encontrado. Valores !resultado 10
Operador lógico NOT encontrado. Valor: resultado
Identificador encontrado: resultado
Literal encontrado: 10
Bloco de código entre chaves encontrado
Atribuição encontrada. Identificador: resultado, Valor: minhaVariavelGrande * 2
Operador * encontrado. Valores minhaVariavelGrande 2
Identificador encontrado: minhaVariavelGrande
Literal encontrado: 2
Bloco 'else' encontrado
Bloco de código entre chaves encontrado
Atribuição encontrada. Identificador: resultado, Valor: minhaVariavelGrande + 5
Operador + encontrado. Valores minhaVariavelGrande 5
Identificador encontrado: minhaVariavelGrande
Literal encontrado: 5
Declaração 'switch' encontrada. Expressão: (resultado)
Identificador encontrado: resultado
Bloco 'case' encontrado com valor 25
Literal encontrado: 25
Bloco de código entre chaves encontrado
Atribuição encontrada. Identificador: mensagem, Valor: "Resultado é 25"
Literal encontrado: "Resultado é 25"
Bloco 'case' encontrado com valor 30
Literal encontrado: 30
Bloco de código entre chaves encontrado
Atribuição encontrada. Identificador: mensagem, Valor: "Resultado é 30"
Literal encontrado: "Resultado é 30"
Bloco 'default' encontrado
Bloco de código entre chaves encontrado
Atribuição encontrada. Identificador: mensagem, Valor: "Resultado é outro valor"
Literal encontrado: "Resultado é outro valor"
```

---
Desenvolvido para fins didáticos e de estudo de compiladores.
