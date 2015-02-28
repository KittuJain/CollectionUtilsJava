import java.util.List;
import java.util.ArrayList;

public class CollectionUtil {
	public static<E> List<E> filter(List<E> list, ListFilter listFilter) {
		List<E> filteredList = new ArrayList();
		for(E item : list) {
			if(listFilter.filterMethod(item)){
				filteredList.add(item);
			}
		}
		return filteredList;
	}

	public static<E,K> List<K> map(List<E> list, ListMapper listMapper) {
		List<K> mappedList = new ArrayList<K>();
		for(E item : list) {
			mappedList.add((K)listMapper.mapMethod(item));
		}
		return mappedList;
	}
}