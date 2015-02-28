import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

interface ListFilter<E> {
	boolean filterMethod(E element);
}

class IntegerFilter implements ListFilter<Integer> {
	public boolean filterMethod (Integer element){
		return (element > 2);
	}
}

public class CollectionUtilTest {
	@Test
	public void filter_returns_an_integer_List_of_elements_that_are_greater_than_2(){
		ListFilter listFilter = new IntegerFilter();
		List<Integer> numbers = new ArrayList<Integer>();
		List<Integer> expected = new ArrayList<Integer>();
		
		numbers.add(2);
		numbers.add(6);
		numbers.add(9);
		expected.add(6);
		expected.add(9);

		List<Integer> filteredList = CollectionUtil.<Integer>filter(numbers,listFilter);
		assertEquals(expected.get(0), filteredList.get(0));
		assertEquals(expected.get(1), filteredList.get(1));
	}
}