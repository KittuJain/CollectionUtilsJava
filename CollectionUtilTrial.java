import java.util.List;
import java.util.ArrayList;

class ListFilter{
	public int filterMethod (int element){
		return (element > 2) ? 1 : 0;
	}
}

public class CollectionUtilTrial {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(5);
		list.add(9);
		ListFilter filter = new ListFilter();
		List<Integer> filteredList = filter(list,filter);
		System.out.println("list ------> "+list);
		System.out.println("filteredlist ------> "+filteredList);
	}

	public static List<Integer> filter (List<Integer> list, ListFilter filter){
		List<Integer> filteredList = new ArrayList<Integer>();
		for (Integer item : list) {
			if(filter.filterMethod(item)==1)
				filteredList.add(item);
		}
		return filteredList;
	}
}
