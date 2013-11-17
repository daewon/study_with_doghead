package set.duseok;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import set.duseok.JoinSet.Set;
import set.duseok.JoinSet;

public class JoinSetTest {

	JoinSet<Integer> joinSet;
	Set set1;
	Set set2;
	Set set3;
	Set set4;
	
	@Before
	public void 준비(){
		joinSet = new JoinSet<>();
		set1 = joinSet.makeSet(1);
		set2 = joinSet.makeSet(2);
		set3 = joinSet.makeSet(3);
		set4 = joinSet.makeSet(4);
	}
	
	@Test
	public void 비교1(){
		assertThat(joinSet.findSet(set1), is(not(joinSet.findSet(set2))));
	}
	
	@Test
	public void 비교2(){
		joinSet.unionSet(set1, set2);
		assertThat(joinSet.findSet(set1), is(joinSet.findSet(set2)));
	}
	
	@Test
	public void 비교3(){
		joinSet.unionSet(set1, set3);
		assertThat(joinSet.findSet(set1), is(joinSet.findSet(set3)));
	}
	@Test
	public void 비교4(){
		joinSet.unionSet(set3, set4);
		assertThat(joinSet.findSet(set3), is(joinSet.findSet(set4)));
	}
	
	
	
}
