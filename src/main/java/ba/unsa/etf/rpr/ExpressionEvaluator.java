package ba.unsa.etf.rpr;

import java.util.Stack;

import static java.lang.Double.parseDouble;

/**
 * Klasa koja računa aritmetički izraz omeđen zagradama koristeći Dijakstra algoritam
 * @author Dalila Kršlak
 */
public class ExpressionEvaluator {

    private static Stack<String> operators = new Stack<String>();
    private static Stack<Double> values = new Stack<Double>();
    /**
     * Greska koju program ispisuje ukoliko je neispravan unos
     */
    static final RuntimeException greska = new RuntimeException("Uneseni izraz nije aritmeticki validan!");

    /**
     * Metoda koja prima string, te racuna njegovu vrijednost koristeci
     * Dijkstra algoritam sa dva steka
     */
    public static double evaluate(String unos) {
        operators = new Stack<>();
        values = new Stack<>();
        String[] rastava = unos.split(" ");
        if(rastava.length<4){
            throw greska;
        }
        int desna = 0, lijeva = 0, znak = 0;
        for(String clan: rastava){
            if(clan.equals("+") || clan.equals("-") || clan.equals("*") || clan.equals("sqrt") || clan.equals("/")) znak++;
            if(clan.equals("(")) lijeva++;
            if(clan.equals(")")) desna++;
        }
        if(desna != lijeva || znak != desna){
            throw greska;
        }
        for (String clan: rastava){
            if(!isOperator(clan) && !isNumeric(clan)){
                throw greska;
            }
            switch (clan) {
                case "(":
                    break;
                case "+":
                    operators.push(clan);
                    break;
                case "-":
                    operators.push(clan);
                    break;
                case "*":
                    operators.push(clan);
                    break;
                case "/":
                    operators.push(clan);
                    break;
                case "sqrt":
                    operators.push(clan);
                    break;
                case ")":
                    if(operators.size()>values.size()){
                        throw greska;
                    }
                    String ops = operators.pop();
                    double vals = values.pop();
                    if(ops.equals("+")) {
                        vals = values.pop() + vals;
                    }
                    else if (ops.equals("-")) {
                        vals = values.pop() - vals;
                    }
                    else if (ops.equals("*")) {
                        vals = values.pop() * vals;
                    }
                    else if (ops.equals("/")) {
                        vals = values.pop() / vals;
                    }
                    else if (ops.equals("sqrt")) {
                        vals = Math.sqrt(vals);
                    }
                    values.push(vals);
                    break;
                default:
                    values.push(parseDouble(clan));
            }
        }
        return values.pop();
    }

    /**
     * Metoda koja provjerava da li je string jednak jednom od operatora
     */
    public static boolean isOperator(String clan){
        return clan.equals("+") || clan.equals("-") || clan.equals("/") || clan.equals("*") || clan.equals("sqrt") || clan.equals("(") || clan.equals(")");
    }

    /**
     * Metoda koja provjerava da li je string realan broj
     */

    public static boolean isNumeric(String clan){
        double vrijednost;
        try {
            vrijednost = Double.parseDouble(clan);
            return true;
        }
        catch (NumberFormatException error){
            return false;
        }
    }
}
