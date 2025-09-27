package unisinos.prova;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {


  public static void main(String[] args) {

    final var code = """
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
            
            

            """;

    final var lexer = new ProvaLexer(new ANTLRInputStream(code));
    final var tokens = new CommonTokenStream(lexer);
    final var parser = new ProvaParser(tokens);
    final var tree = parser.parse();

    final var interpreter = new Interpreter();
    interpreter.visit(tree);
  }
}
