package sort.duseok.bubbleSort;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

import org.junit.Before;
import org.junit.Test;

public class BubbleSortTest {

	int 정렬할데이터[];
	
	@Before
	public void 준비(){
		정렬할데이터 = new int[]{6, 4, 2, 3, 1, 5};
	}
	
	@Test
	public void 정렬(){
		
		int 정렬예상결과[] = {1, 2, 3, 4, 5, 6};
		
		int 정렬결과[] = BubbleSort.sort(정렬할데이터);
		
		
		assertThat(정렬결과,is(정렬예상결과));
		
		System.out.print("정렬결과 :");
		for (int i : 정렬결과) {
			System.out.print(i +" ");
		}
		System.out.println();
		System.out.print("정렬예상결과 :");
		for (int i : 정렬예상결과) {
			System.out.print(i +" ");
		}
		
	}
}
