package stack;

import static org.junit.Assert.assertThat;
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
		
		assertThat("100 200 300*+" , is(calc.toPostFix("100+200*300")));
		assertThat(" 172.32 83 + 49*" , is(calc.toPostFix("(172.32+83)*49")));
		assertThat("172.32 83 49*+" , is(calc.toPostFix("172.32+83*49")));
		assertThat(calc.toPostFix("((12+13)*10)+20") , is("  12 13 + 10 * 20+"));
		assertThat(calc.toPostFix("(((12+13)*10)/20)") , is("12 13 + 10 * 20 /"));
		
		
	}
}
