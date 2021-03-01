// Generated from /Users/bkb/Documents/Uni/CE305_AssigOne/src/ANTLR_SRC/AssigOneGrammar.g4 by ANTLR 4.9.1
package AssigOneGrammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AssigOneGrammarParser}.
 */
public interface AssigOneGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AssigOneGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(AssigOneGrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssigOneGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(AssigOneGrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link AssigOneGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpr(AssigOneGrammarParser.PrintExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link AssigOneGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpr(AssigOneGrammarParser.PrintExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link AssigOneGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssign(AssigOneGrammarParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link AssigOneGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssign(AssigOneGrammarParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blank}
	 * labeled alternative in {@link AssigOneGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlank(AssigOneGrammarParser.BlankContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link AssigOneGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlank(AssigOneGrammarParser.BlankContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Add}
	 * labeled alternative in {@link AssigOneGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAdd(AssigOneGrammarParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link AssigOneGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAdd(AssigOneGrammarParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link AssigOneGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(AssigOneGrammarParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link AssigOneGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(AssigOneGrammarParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multi}
	 * labeled alternative in {@link AssigOneGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulti(AssigOneGrammarParser.MultiContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multi}
	 * labeled alternative in {@link AssigOneGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulti(AssigOneGrammarParser.MultiContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link AssigOneGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(AssigOneGrammarParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link AssigOneGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(AssigOneGrammarParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code power}
	 * labeled alternative in {@link AssigOneGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPower(AssigOneGrammarParser.PowerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code power}
	 * labeled alternative in {@link AssigOneGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPower(AssigOneGrammarParser.PowerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link AssigOneGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(AssigOneGrammarParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link AssigOneGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(AssigOneGrammarParser.IntContext ctx);
}