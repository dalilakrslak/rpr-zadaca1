package ba.unsa.etf.rpr;
import java.util.Objects;

import static ba.unsa.etf.rpr.ExpressionEvaluator.*;
/**
 * Class App
 * Klasa koja vrsi validaciju ulaza s konzole
 * @author Dalila Kršlak
 * @version 1.0
 */
public class App 
{
    public static void main( String[] args ) {
        try{
            StringBuilder unos = new StringBuilder();
            for(String clan: args){
                unos.append(clan).append(" ");
            }
            double rezultat = evaluate(String.valueOf(unos));
            System.out.println("Rezultat je: " + rezultat);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
}
