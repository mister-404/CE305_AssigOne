import AssigOneGrammar.AssigOneGrammarLexer;
import AssigOneGrammar.AssigOneGrammarParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class MainProg {
    public static void main(String[] args)   {
        CharStream input = CharStreams.fromString("a=2*(5+cat)/2\r\n    a  \r\n");
        AssigOneGrammarLexer lexer = new AssigOneGrammarLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AssigOneGrammarParser parser = new AssigOneGrammarParser(tokens);

        ParseTree tree = parser.program(); // parse; start at prog
        VisiEval eval = new VisiEval();

        eval.visit(tree);

        String pPrinter = new PrettyPrinter().visit(tree);
        System.out.println(pPrinter);
    }
}
