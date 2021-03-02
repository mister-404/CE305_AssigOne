import AssigOneGrammar.AssigOneGrammarLexer;
import AssigOneGrammar.AssigOneGrammarParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.Scanner;

public class MainProg {
    private static final Scanner userInputGetter = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String fileName = promptForFileName();
        boolean contRunning = true;
        while (contRunning) {
            System.out.println("""
                    Would you like to:-
                        a) Get the pretty printed version for the file you just chose?
                        b) Get the evaluations for the file you just chose?
                        c) Choose a new file?
                        q) Quit?""");

            String choice = userInputGetter.nextLine().toLowerCase();

            switch (choice) {
                case "c" -> promptForFileName();
                case "q" -> contRunning = false;
                default -> {
                    CharStream srcCode = CharStreams.fromFileName(fileName);
                    AssigOneGrammarLexer lexer = new AssigOneGrammarLexer(srcCode);
                    CommonTokenStream tokens = new CommonTokenStream(lexer);
                    AssigOneGrammarParser parser = new AssigOneGrammarParser(tokens);
                    ParseTree tree = parser.program(); //start parsing at program beginning
                    switch (choice) {
                        case "a" -> System.out.println(new PrettyPrinter().visit(tree));
                        case "b" -> new VisiEvalFull().visit(tree);
                    }
                }
            }
        }
        userInputGetter.close();
    }

    private static String promptForFileName() {
        System.out.println("Please enter the file name:-");
        return userInputGetter.nextLine();
    }
}
