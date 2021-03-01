import AssigOneGrammar.AssigOneGrammarBaseVisitor;
import AssigOneGrammar.AssigOneGrammarParser;
import GramException.NotInMemoryException;

import java.util.HashMap;
import java.util.Map;

public class VisiEval extends AssigOneGrammarBaseVisitor<Number> {
    private final Map<String, Number> mem = new HashMap<>(); //remembers assigned values

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

        boolean needsDoublePrecis = false;

//        try {
//            for (int i = 0; i <= 1; i++)
//                Integer. visit(ctx.expr(0))
//        }
//        catch ()

        if(left instanceof Double || right instanceof Double)
            needsDoublePrecis = true;

        if (ctx.op.getType() == AssigOneGrammarParser.ADD)
            return needsDoublePrecis ? left.doubleValue() + right.doubleValue() : left.intValue() + right.intValue();
        else return needsDoublePrecis ? left.doubleValue() - right.doubleValue() : left.intValue() - right.intValue();
    }

    @Override
    public Number visitParens(AssigOneGrammarParser.ParensContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Number visitMulti(AssigOneGrammarParser.MultiContext ctx) {
        Number left = visit(ctx.expr(0));
        Number right = visit(ctx.expr(1));

        boolean needsDoublePrecis = false;

//        try {
//            for (int i = 0; i <= 1; i++)
//                Integer. visit(ctx.expr(0))
//        }
//        catch ()

        if(left instanceof Double || right instanceof Double)
            needsDoublePrecis = true;

        if (ctx.op.getType() == AssigOneGrammarParser.MUL)
            return needsDoublePrecis ? left.doubleValue() * right.doubleValue() : left.intValue() * right.intValue();
        else return needsDoublePrecis ? left.doubleValue() / right.doubleValue() : left.intValue() / right.intValue();
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

//    @Override
//    public Integer visitInt(AssigOneGrammarParser.IntContext ctx) {
//        return Integer.valueOf(ctx.INT().getText());
//    }


    @Override
    public Number visitNum(AssigOneGrammarParser.NumContext ctx) {
        try{
            return Integer.parseInt(ctx.NUM().getText());
        }
        catch (Exception e) {
            return Double.parseDouble(ctx.NUM().getText());
        }
        }
}
