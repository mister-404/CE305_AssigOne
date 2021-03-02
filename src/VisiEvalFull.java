import AssigOneGrammar.AssigOneGrammarBaseVisitor;
import AssigOneGrammar.AssigOneGrammarParser;
import GramException.NotInMemoryException;
import Values.FloatValue;
import Values.IntValue;
import Values.Value;

import java.util.HashMap;
import java.util.Map;

public class VisiEvalFull extends AssigOneGrammarBaseVisitor<Value> {
    private final Map<String, Value> mem = new HashMap<>(); //remembers assigned values

    @Override
    public Value visitId(AssigOneGrammarParser.IdContext ctx) {
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
    public Value visitMulti(AssigOneGrammarParser.MultiContext ctx) {
        Value leftValue = visit(ctx.left);
        Value rightValue = visit(ctx.right);

        if (leftValue instanceof FloatValue || rightValue instanceof FloatValue) {
            float left = Float.parseFloat( leftValue.toString() );
            float right = Float.parseFloat( rightValue.toString() );
            return new FloatValue(ctx.op.getType() == AssigOneGrammarParser.MUL ? left * right : left / right);
        } else if (leftValue instanceof IntValue && rightValue instanceof IntValue) {
            int left = ((IntValue) leftValue).getVal();
            int right = ((IntValue) leftValue).getVal();
            return new IntValue(ctx.op.getType() == AssigOneGrammarParser.MUL ? left * right : left / right);
        } else {
            return null;
        }
    }

    @Override
    public Value visitAdd(AssigOneGrammarParser.AddContext ctx) {
        Value leftValue = visit(ctx.left);
        Value rightValue = visit(ctx.right);

        if (leftValue instanceof FloatValue || rightValue instanceof FloatValue) {
            float left = Float.parseFloat( leftValue.toString() );
            float right = Float.parseFloat( rightValue.toString() );
            return new FloatValue(ctx.op.getType() == AssigOneGrammarParser.ADD ? left + right : left - right);
        } else if (leftValue instanceof IntValue && rightValue instanceof IntValue) {
            int left = ((IntValue) leftValue).getVal();
            int right = ((IntValue) leftValue).getVal();
            return new IntValue(ctx.op.getType() == AssigOneGrammarParser.ADD ? left + right : left - right);
        } else {
            return null;
        }
    }

    @Override
    public Value visitAssign(AssigOneGrammarParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        Value value = visit(ctx.expr());
        mem.put(id, value);
        return value;
    }

    @Override
    public Value visitPrintExpr(AssigOneGrammarParser.PrintExprContext ctx) {
        Value value = visit(ctx.expr());
        System.out.println(ctx.expr().getText() + " = " + value.toString());
        return null;
    }

    @Override
    public Value visitPower(AssigOneGrammarParser.PowerContext ctx) {
        Value leftValue = visit(ctx.left);
        Value rightValue = visit(ctx.right);

        if (leftValue instanceof FloatValue || rightValue instanceof FloatValue) {
            float left = ((FloatValue) leftValue).getVal();
            float right = ((FloatValue) rightValue).getVal();
            return new FloatValue((float) Math.pow( left , right ));
        } else if (leftValue instanceof IntValue && rightValue instanceof IntValue) {
            int left = ((IntValue) leftValue).getVal();
            int right = ((IntValue) leftValue).getVal();
            return new IntValue((int) Math.pow(left, right));
        } else {
            return null;
        }
    }

    @Override
    public Value visitFloat(AssigOneGrammarParser.FloatContext ctx) {
        return new FloatValue(Float.parseFloat(ctx.getText()));
    }

    @Override
    public Value visitInt(AssigOneGrammarParser.IntContext ctx) {
        return new IntValue(Integer.parseInt(ctx.getText()));
    }

    @Override
    public Value visitParens(AssigOneGrammarParser.ParensContext ctx) {
        return visit(ctx.expr());
    }
}
