package ba.unsa.etf.rpr;

import static ba.unsa.etf.rpr.ExpressionEvaluator.evaluate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Unit test for ExpressionEvaluator
 */
public class ExpressionEvaluatorTest
{

    @Test
    void evaluatePlus() {
        assertEquals(2.0, evaluate("( 1 + 1 )"));
    }

    @Test
    void evaluateMinus(){
        assertEquals(0.0, evaluate("( 1 - 1 )"));
    }

    @Test
    void evaluateMultiply(){
        assertEquals(2.0, evaluate("( 2 * 1 )"));
    }

    @Test
    void evaluateDivide(){
        assertEquals(3.0, evaluate("( 9 / 3 )"));
    }

    @Test
    void evaluateSqrt(){
        assertEquals(3.0, evaluate("( sqrt 9 )"));
    }

    @Test
    void evaluateError1(){
        assertThrows(RuntimeException.class, () -> evaluate("( ( 1 + 1 ) )"));
    }

    @Test
    void evaluateError2(){
        assertThrows(RuntimeException.class, () -> evaluate("( d + 23 )"));
    }
}
