import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

interface ListFilter<E> {
	boolean filterMethod(E element);
}

interface ListMapper<E, K> {
	K mapMethod(E element);
}

interface ListReducer<E, K> {
	K reduceMethod(K previousValue,E currentValue);
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

class IntegerMapper implements ListMapper<Integer,Integer> {
	public Integer mapMethod (Integer element){
		return (element + 1);
	}
}

class StringMapper implements ListMapper<String,String> {
	public String mapMethod (String element){
		return element.toLowerCase();
	}
}

class IntegerReducer implements ListReducer<Integer,String> {
	public String reduceMethod(String previousValue,Integer currentValue){
		return previousValue + currentValue;
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
		int[] expected = {2,3,4};
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		
		List<Integer> mappedList = CollectionUtil.<Integer,Integer>map(numbers, listMapper);
		assertEquals(expected[0],(int)(mappedList.get(0)));
		assertEquals(expected[1],(int)(mappedList.get(1)));
		assertEquals(expected[2],(int)(mappedList.get(2)));
	}

	@Test
	public void map_returns_a_string_List_after_converting_each_element_of_list_to_lowerCase(){
		ListMapper listMapper = new StringMapper();
		List<String> colors = new ArrayList<String>();
		String[] expected = {"red","yellow","blue"};
		
		colors.add("RED");
		colors.add("Yellow");
		colors.add("BlUe");

		List<String> mappedList = CollectionUtil.<String,String>map(colors,listMapper);
		assertEquals(expected[0], mappedList.get(0));
		assertEquals(expected[1], mappedList.get(1));
		assertEquals(expected[2], mappedList.get(2));
	}

	@Test
	public void reduce_retuns_one_element(){
		ListReducer listReducer = new IntegerReducer();
		List<Integer> list = new  ArrayList<Integer>();
		String expected ="num 987654321";
		list.add(9);
		list.add(8);
		list.add(7);
		list.add(6);
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);

		String result = CollectionUtil.<Integer,String>reduce(list,listReducer,"num ");
		assertEquals(expected,result);
	}
}