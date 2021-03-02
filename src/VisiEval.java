import AssigOneGrammar.AssigOneGrammarBaseVisitor;
import AssigOneGrammar.AssigOneGrammarParser;
import GramException.NotInMemoryException;

import java.util.HashMap;
import java.util.Map;

public class VisiEval extends AssigOneGrammarBaseVisitor<Number> {
    private final Map<String, Number> mem = new HashMap<>(); //remembers assigned values

    @Override
    public Number visitPower(AssigOneGrammarParser.PowerContext ctx) {
        if (
                ctx.expr(0).start.getType() == (AssigOneGrammarParser.FLOAT) ||
                        ctx.expr(1).start.getType() == AssigOneGrammarParser.FLOAT)
            return Math.pow(visit(ctx.expr(0)).floatValue(), visit(ctx.expr(1)).floatValue());
        else
            return (int) Math.pow(visit(ctx.expr(0)).intValue(), visit(ctx.expr(1)).intValue());
    }

    @Override
    public Number visitPrintExpr(AssigOneGrammarParser.PrintExprContext ctx) {
        Number value = visit(ctx.expr());
        System.out.println(ctx.expr().getText() + " = " + value);
        return 0;
    }

    @Override
    public Number visitAssign(AssigOneGrammarParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        Number value = visit(ctx.expr());
        mem.put(id, value);
        return value;
    }

    @Override
    public Number visitBlank(AssigOneGrammarParser.BlankContext ctx) {
        return super.visitBlank(ctx);
    }

    @Override
    public Number visitAdd(AssigOneGrammarParser.AddContext ctx) {
        Number left = visit(ctx.expr(0));
        Number right = visit(ctx.expr(1));

        if (ctx.op.getType() == AssigOneGrammarParser.ADD)
            if (
                    (ctx.expr(0).start.getType() == AssigOneGrammarParser.FLOAT ||
                            ctx.expr(1).start.getType() == AssigOneGrammarParser.FLOAT))
                return left.floatValue() + right.floatValue();
            else return left.intValue() + right.intValue();
        else if (
                (ctx.expr(0).start.getType() == AssigOneGrammarParser.FLOAT ||
                        ctx.expr(1).start.getType() == AssigOneGrammarParser.FLOAT))
            return left.floatValue() - right.floatValue();
        else return left.intValue() - right.intValue();
    }

    @Override
    public Number visitParens(AssigOneGrammarParser.ParensContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Number visitMulti(AssigOneGrammarParser.MultiContext ctx) {
        Number left = visit(ctx.expr(0));
        Number right = visit(ctx.expr(1));

        if (ctx.op.getType() == AssigOneGrammarParser.MUL)
            if (
                    (ctx.expr(0).start.getType() == AssigOneGrammarParser.FLOAT ||
                            ctx.expr(1).start.getType() == AssigOneGrammarParser.FLOAT))
                return left.floatValue() * right.floatValue();
            else return left.intValue() * right.intValue();
        else if (
                (ctx.expr(0).start.getType() == AssigOneGrammarParser.FLOAT ||
                        ctx.expr(1).start.getType() == AssigOneGrammarParser.FLOAT))
            return left.floatValue() / right.floatValue();
        else return left.intValue() / right.intValue();
    }

    @Override
    public Number visitId(AssigOneGrammarParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if (mem.containsKey(id))
            return mem.get(id);
        else try {
            throw new NotInMemoryException(id);
        } catch (NotInMemoryException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Integer visitInt(AssigOneGrammarParser.IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }

    @Override
    public Float visitFloat(AssigOneGrammarParser.FloatContext ctx) {
        return Float.valueOf(ctx.FLOAT().getText());
    }
}
