package univ.lecture;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by tchi on 2017. 3. 19..
 */

/*
 * Practice Coding Team3
 * 201302387 김진혁
 * 201302491 최광호
 * 201302476 전성배
 * 201302467 이충완
 * 
 * */

public class CalculatorTest {
    @Test
    public void testCalculatorAdd () {
        Calculator calc = new Calculator();
        int output = calc.calculate("1+1");
        assertThat(output, is(2));
        output = calc.calculate("3+6+9");
        assertThat(output, is(18));
    }
    
    @Test
    public void testCalculatorSub () {
    	Calculator calc = new Calculator();
    	int output = calc.calculate("9-5");
    	assertThat(output, is(4));
    	output = calc.calculate("3-7");
    	assertThat(output, is(-4));
    	output = calc.calculate("10-8-6");
    	assertThat(output, is(-4));
    }
    
    @Test
    public void testCalculatorMul () {
        Calculator calc = new Calculator();
        int output = calc.calculate("4*5");
        assertThat(output, is(20));
        output = calc.calculate("5*6*7");
        assertThat(output, is(210));
    }
    
    @Test
    public void testCalculatorDiv () {
        Calculator calc = new Calculator();
        int output = calc.calculate("8/4");
        assertThat(output, is(2));
        output = calc.calculate("8/4/2");
        assertThat(output, is(2));
    }
    
    @Test
    public void testCalculatorAll () {
        Calculator calc = new Calculator();
        int output = calc.calculate("(10*3)+5*(3-7)");
        assertThat(output, is(10));
        output = calc.calculate("8+2*4*(9+(5-1))");
		assertThat(output, is(112));
		output = calc.calculate("3+5*((8-2)+7)*6");
		assertThat(output, is(393));
    }
    
    
    
    
    
}