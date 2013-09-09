package stack;

import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class TestDsCalculator {

	@Test
	public void testIsNumber() {
		DsCalculator calc = new DsCalculator();
		assertThat(true, is(true));
		assertThat(true, is(calc.isNumber('1')));
		assertThat(true, is(calc.isNumber('2')));
		assertThat(true, is(calc.isNumber('3')));
		assertThat(false, is(calc.isNumber('+')));
		assertThat(false, is(calc.isNumber('-')));
		assertThat(false, is(calc.isNumber('*')));
		assertThat(false, is(calc.isNumber('-')));
		
	}
	
	@Test 
	public void makePostFix(){
		DsCalculator calc = new DsCalculator();
		
		assertThat("100 200 300 * +" , is(calc.toPostFix("100+200*300")));
		assertThat(calc.toPostFix("(172.32+83)*49") , is("172.32 83 + 49 *"));
		assertThat(calc.toPostFix("172.32+83*49") , is("172.32 83 49 * +"));
		assertThat(calc.toPostFix("((12+13)*10)+20") , is("12 13 + 10 * 20 +"));
		assertThat(calc.toPostFix("(((12+13)*10)/20)") , is("12 13 + 10 * 20 /"));
		
		
	}
	
	@Test
	public void calculate(){
		DsCalculator calc = new DsCalculator();
		assertThat(new BigDecimal("60100"), is(calc.calculate("100 200 300 * +")));
		assertThat(new BigDecimal("12510.68"), is(calc.calculate("172.32 83 + 49 *")));
		assertThat(new BigDecimal("4239.32"), is(calc.calculate("172.32 83 49 * +")));
		assertThat(new BigDecimal("270"), is(calc.calculate("12 13 + 10 * 20 +")));
		assertThat(new BigDecimal("12.5"), is(calc.calculate("12 13 + 10 * 20 /")));
		
	}
}
