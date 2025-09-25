package unisinos.prova;


import static unisinos.prova.ProvaParser.AssignmentContext;


public class Interpreter extends ProvaBaseVisitor<Void> {


  @Override
  public Void visitAssignment(AssignmentContext ctx) {
    System.out.printf("Atribuição encontrada. Identificador: %s, Valor: %s%n", ctx.IDENTIFIER().getText(), ctx.expression().getText());
    return super.visitAssignment(ctx);
  }

  @Override
  public Void visitEnclosedBlock(ProvaParser.EnclosedBlockContext ctx) {
    System.out.println("Bloco de código entre chaves encontrado");
    return super.visitEnclosedBlock(ctx);
  }

  @Override
  public Void visitConditionalBlock(ProvaParser.ConditionalBlockContext ctx) {
    System.out.printf("Bloco condicional encontrado. Condição: %s%n", ctx.enclosedExpression().getText());
    return super.visitConditionalBlock(ctx);
  }


  @Override
  public Void visitElseBlock(ProvaParser.ElseBlockContext ctx) {
    System.out.println("Bloco 'else' encontrado");
    return super.visitElseBlock(ctx);
  }

  @Override
  public Void visitSwitchStatement(ProvaParser.SwitchStatementContext ctx) {
    System.out.printf("Declaração 'switch' encontrada. Expressão: %s%n", ctx.enclosedExpression().getText());
    return super.visitSwitchStatement(ctx);
  }

  @Override
  public Void visitCaseBlock(ProvaParser.CaseBlockContext ctx) {
    System.out.printf("Bloco 'case' encontrado com valor %s%n", ctx.literal().getText());
    return super.visitCaseBlock(ctx);
  }

  @Override
  public Void visitDefaultBlock(ProvaParser.DefaultBlockContext ctx) {
    System.out.println("Bloco 'default' encontrado");
    return super.visitDefaultBlock(ctx);
  }

  @Override
  public Void visitPlusOrMinusOperator(ProvaParser.PlusOrMinusOperatorContext ctx) {
    System.out.printf("Operador %s encontrado. Valores %s %s%n", ctx.sign.getText(), ctx.expression(0).getText(), ctx.expression(1).getText());
    return super.visitPlusOrMinusOperator(ctx);
  }

  @Override
  public Void visitUnaryMinusOperator(ProvaParser.UnaryMinusOperatorContext ctx) {
    System.out.printf("Operador unário de subtração encontrado. Valor: %s%n", ctx.expression().getText());
    return super.visitUnaryMinusOperator(ctx);
  }

  @Override
  public Void visitNotOperator(ProvaParser.NotOperatorContext ctx) {
    System.out.printf("Operador lógico NOT encontrado. Valor: %s%n", ctx.expression().getText());
    return super.visitNotOperator(ctx);
  }

  @Override
  public Void visitEqualsOperator(ProvaParser.EqualsOperatorContext ctx) {
    System.out.printf("Operador de igualdade encontrado. Valores %s e %s%n", ctx.expression(0).getText(), ctx.expression(1).getText());
    return super.visitEqualsOperator(ctx);
  }

  @Override
  public Void visitDiffersOperator(ProvaParser.DiffersOperatorContext ctx) {
    System.out.printf("Operador de diferença encontrado. Valores %s e %s%n", ctx.expression(0).getText(), ctx.expression(1).getText());
    return super.visitDiffersOperator(ctx);
  }

  @Override
  public Void visitGreaterThanOperator(ProvaParser.GreaterThanOperatorContext ctx) {
    System.out.printf("Operador 'maior que' encontrado. Valores %s e %s%n", ctx.expression(0).getText(), ctx.expression(1).getText());
    return super.visitGreaterThanOperator(ctx);
  }

  @Override
  public Void visitGreaterOrEqualOperator(ProvaParser.GreaterOrEqualOperatorContext ctx) {
    System.out.printf("Operador 'maior ou igual a' encontrado. Valores %s e %s%n", ctx.expression(0).getText(), ctx.expression(1).getText());
    return super.visitGreaterOrEqualOperator(ctx);
  }

  @Override
  public Void visitLowerThanOperator(ProvaParser.LowerThanOperatorContext ctx) {
    System.out.printf("Operador 'menor que' encontrado. Valores %s e %s%n", ctx.expression(0).getText(), ctx.expression(1).getText());
    return super.visitLowerThanOperator(ctx);
  }

  @Override
  public Void visitLowerOrEqualOperator(ProvaParser.LowerOrEqualOperatorContext ctx) {
    System.out.printf("Operador 'menor ou igual a' encontrado. Valores %s e %s%n", ctx.expression(0).getText(), ctx.expression(1).getText());
    return super.visitLowerOrEqualOperator(ctx);
  }

  @Override
  public Void visitAndOperator(ProvaParser.AndOperatorContext ctx) {
    System.out.printf("Operador lógico AND encontrado. Valores %s e %s%n", ctx.expression(0).getText(), ctx.expression(1).getText());
    return super.visitAndOperator(ctx);
  }

  @Override
  public Void visitOrOperator(ProvaParser.OrOperatorContext ctx) {
    System.out.printf("Operador lógico OR encontrado. Valores %s e %s%n", ctx.expression(0).getText(), ctx.expression(1).getText());
    return super.visitOrOperator(ctx);
  }

  @Override
  public Void visitMultiplicationOrDivisionOperator(ProvaParser.MultiplicationOrDivisionOperatorContext ctx) {
    System.out.printf("Operador %s encontrado. Valores %s %s%n", ctx.sign.getText(), ctx.expression(0).getText(), ctx.expression(1).getText());
    return super.visitMultiplicationOrDivisionOperator(ctx);
  }

  @Override
  public Void visitLiteralExpression(ProvaParser.LiteralExpressionContext ctx) {
    System.out.printf("Literal encontrado: %s%n", ctx.literal().getText());
    return super.visitLiteralExpression(ctx);
  }

  @Override
  public Void visitIdentifierExpression(ProvaParser.IdentifierExpressionContext ctx) {
    System.out.printf("Identificador encontrado: %s%n", ctx.IDENTIFIER().getText());
    return super.visitIdentifierExpression(ctx);
  }
}