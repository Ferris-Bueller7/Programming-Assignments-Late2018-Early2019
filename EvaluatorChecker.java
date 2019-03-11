import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.math.BigInteger;

public class EvaluatorChecker {

    private static Deque<String> toDeque(String s) {
        Scanner in = new Scanner(s);
        Deque<String> out = new ArrayDeque<>();
        while (in.hasNext())
            out.add(in.next());
        return out;
    }

    private static int testInfixToPostfix(String in, String out) {
        int correct=0;
        
        try {
            Deque<String> originalDeque = toDeque(in);
            Deque<String> passedDeque = toDeque(in);
            Deque<String> res = Evaluator.infixToPostfix(passedDeque);
            if (res.toString().equals(toDeque(out).toString()) && 
                originalDeque.toString().equals(passedDeque.toString()))
                correct++;
            else
                System.out.println("Error: expected '" + toDeque(out) +
                    "' but got '" + res + "'");
        }
        catch (Exception e) { System.out.println("Exception: " + toDeque(out));}
        
        return correct;
    } 

    private static int testEvalPostfix(String in, String out) {
        int correct=0;
        
        try {
            Deque<String> originalDeque = toDeque(in);
            Deque<String> passedDeque = toDeque(in);
            BigInteger res = Evaluator.evalPostfix(passedDeque);
            if (res.toString().equals(out) &&
                originalDeque.toString().equals(passedDeque.toString()))
                correct++;
            else
                System.out.println("Error: expected '" + out + "' but got '" +
                    res + "'");
        }
        catch (Exception e) { System.out.println("Exception: " + out);}
        
        return correct;
    } 

    public static void main(String[] args) {
        int correct = 0;
        
        correct += testInfixToPostfix("1 + 2 * 3", "1 2 3 * +");
      correct += testInfixToPostfix("1 * 2 + 3", "1 2 * 3 +");
        correct += testInfixToPostfix("1 + ( 2 + 3 * 4 ) * 5",
            "1 2 3 4 * + 5 * +");
        correct += testInfixToPostfix("100000000000000000000 - -1",
            "100000000000000000000 -1 -");

        correct += testEvalPostfix("1 2 3 * +", "7");
        correct += testEvalPostfix("1 2 * 3 +", "5");
        correct += testEvalPostfix("1 2 3 4 * + 5 * +", "71");
        correct += testEvalPostfix("100000000000000000000 -1 -",
            "100000000000000000001");

       try { Evaluator.evalPostfix(Evaluator.infixToPostfix(toDeque("1 ++ 2"))); }
        catch (IllegalArgumentException e) { correct += 1; }
        catch (Exception e) { }
        
        try { Evaluator.evalPostfix(Evaluator.infixToPostfix(toDeque("1 + + 2"))); }
        catch (IllegalArgumentException e) { correct += 1; }
        catch (Exception e) { }
        
        try { Evaluator.evalPostfix(Evaluator.infixToPostfix(toDeque("1 + ( 1 ) )"))); }
        catch (IllegalArgumentException e) { correct += 1; }
        catch (Exception e) { }
        
        try { Evaluator.evalPostfix(Evaluator.infixToPostfix(toDeque("( ( 1 )"))); }
        catch (IllegalArgumentException e) { correct += 1; }
        catch (Exception e) { }
        
        try { Evaluator.evalPostfix(Evaluator.infixToPostfix(toDeque("-hello + 10"))); }
        catch (IllegalArgumentException e) { correct += 1; }
        catch (Exception e) { }
        
        
        System.out.println("Correct: " + correct);
    }

}