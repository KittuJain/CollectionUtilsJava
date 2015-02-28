import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

interface ListFilter<E> {
	boolean filterMethod(E element);
}

interface ListMapper<E> {
	E mapMethod(E element);
}

class IntegerFilter implements ListFilter<Integer> {
	public boolean filterMethod (Integer element){
		return (element > 2);
	}
}

class StringFilter implements ListFilter<String> {
	public boolean filterMethod (String element){
		return (element == "yellow");
	}
}

class IntegerMapper implements ListMapper<Integer> {
	public Integer mapMethod (Integer element){
		return element + 1;
	}
}

public class CollectionUtilTest {
	@Test
	public void filter_returns_an_integer_List_of_elements_that_are_greater_than_2(){
		ListFilter<Integer> listFilter = new IntegerFilter();
		List<Integer> numbers = new ArrayList<Integer>();
		List<Integer> expected = new ArrayList<Integer>();
		
		numbers.add(2);
		numbers.add(6);
		numbers.add(9);
		expected.add(6);
		expected.add(9);

		List<Integer> filteredList = CollectionUtil.<Integer>filter(numbers, listFilter);
		assertEquals(expected.get(0), filteredList.get(0));
		assertEquals(expected.get(1), filteredList.get(1));
	}

	@Test
	public void filter_returns_a_string_List_of_elements_that_are_yellow(){
		ListFilter<String> listFilter = new StringFilter();
		List<String> colors = new ArrayList<String>();
		List<String> expected = new ArrayList<String>();
		
		colors.add("red");
		colors.add("blue");
		colors.add("yellow");
		expected.add("yellow");

		List<String> filteredList = CollectionUtil.<String>filter(colors, listFilter);
		assertEquals(expected.get(0), filteredList.get(0));
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
		assertEquals(expected.get(0), mappedList.get(0));
		assertEquals(expected.get(1), mappedList.get(1));
		assertEquals(expected.get(2), mappedList.get(2));
	}
}