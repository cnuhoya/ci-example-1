package univ.lecture;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by tchi on 2017. 3. 19..
 */
public class CalculatorTest {
    @Test
    public void testCalculatorAdd () {
        Calculator calc = new Calculator();
        int output = calc.calculate("1+1");
        assertThat(output, is(2));
    }
    
    @Test
    public void testCalculatorMul () {
        Calculator calc = new Calculator();
        int output = calc.calculate("4*5");
        assertThat(output, is(20));
    }
    
    @Test
    public void testCalculatorDiv () {
        Calculator calc = new Calculator();
        int output = calc.calculate("8/4");
        assertThat(output, is(2));
    }
    
    @Test
    public void testCalculatorSub () {
        Calculator calc = new Calculator();
        int output = calc.calculate("9-5");
        assertThat(output, is(4));
    }
    
    
}