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

interface ListMapper<E> {
	E mapMethod(E element);
}

class IntegerMapper implements ListMapper<Integer> {
	public Integer mapMethod (Integer element){
		return element + 1;
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

	@Test
	public void map_returns_an_integer_List_after_adding_1_to_each_element(){
		ListMapper listMapper = new IntegerMapper();
		List<Integer> numbers = new ArrayList<Integer>();
		List<Integer> expected = new ArrayList<Integer>();
		
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);

		expected.add(2);
		expected.add(3);
		expected.add(4);

		List<Integer> mappedList = CollectionUtil.<Integer>map(numbers,listMapper);
		assertEquals(expected.get(0),mappedList.get(0));
		assertEquals(expected.get(1),mappedList.get(1));
		assertEquals(expected.get(2),mappedList.get(2));
	}
}