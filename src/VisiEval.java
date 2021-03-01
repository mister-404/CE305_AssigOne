import AssigOneGrammar.AssigOneGrammarBaseVisitor;
import AssigOneGrammar.AssigOneGrammarParser;

import java.util.HashMap;
import java.util.Map;

public class VisiEval extends AssigOneGrammarBaseVisitor<Integer> {
    Map<String, Integer> mem = new HashMap<>(); //remembers assigned values

    @Override
    public Integer visitPrintExpr(AssigOneGrammarParser.PrintExprContext ctx) {
        Integer value = visit(ctx.expr());
        System.out.println(ctx.expr().getText() + " = " + value);
        return 0;
    }

    @Override
    public Integer visitAssign(AssigOneGrammarParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        int value = visit(ctx.expr());
        mem.put(id, value);
        return value;
    }

    @Override
    public Integer visitBlank(AssigOneGrammarParser.BlankContext ctx) {
        return super.visitBlank(ctx);
    }

    @Override
    public Integer visitAdd(AssigOneGrammarParser.AddContext ctx) {
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        if (ctx.op.getType() == AssigOneGrammarParser.ADD)
            return left + right;
        else
            return left - right;
    }

    @Override
    public Integer visitParens(AssigOneGrammarParser.ParensContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Integer visitMulti(AssigOneGrammarParser.MultiContext ctx) {
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        if (ctx.op.getType() == AssigOneGrammarParser.MUL)
            return left * right;
        else
            return left / right;
    }

    @Override
    public Integer visitId(AssigOneGrammarParser.IdContext ctx) {
        String id = ctx.ID().getText();
        return mem.getOrDefault(id, 0);
    }

    @Override
    public Integer visitInt(AssigOneGrammarParser.IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }
}
