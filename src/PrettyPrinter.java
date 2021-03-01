import AssigOneGrammar.AssigOneGrammarBaseVisitor;
import AssigOneGrammar.AssigOneGrammarParser;
import org.antlr.v4.runtime.tree.ParseTree;

public class PrettyPrinter extends AssigOneGrammarBaseVisitor<String> {
    @Override
    public String visitProgram(AssigOneGrammarParser.ProgramContext ctx) {
        StringBuilder buildUp = new StringBuilder();

        for (ParseTree pT : ctx.children)
            buildUp.append(this.visit(pT)).append('\n');

        return buildUp.toString();
    }

    @Override
    public String visitPrintExpr(AssigOneGrammarParser.PrintExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public String visitAssign(AssigOneGrammarParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        return id + " = " + this.visit(ctx.expr());
    }

    @Override
    public String visitAdd(AssigOneGrammarParser.AddContext ctx) {
        return visit(ctx.expr(0)) + " " + ctx.op.getText() + " " + visit(ctx.expr(1));
    }

    @Override
    public String visitParens(AssigOneGrammarParser.ParensContext ctx) {
        return "(" + visit(ctx.expr()) + ")";
    }

    @Override
    public String visitMulti(AssigOneGrammarParser.MultiContext ctx) {
        return visit(ctx.expr(0)) + " " + ctx.op.getText() + " " + visit(ctx.expr(1));
    }

    @Override
    public String visitId(AssigOneGrammarParser.IdContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitInt(AssigOneGrammarParser.IntContext ctx) {
        return ctx.getText();
    }
}
