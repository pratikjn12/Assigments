package list;

import java.util.LinkedList;
import java.util.List;

public class Listwithforeach {

	public static void main(String[] args) {

		List<Integer> lst = new LinkedList<Integer>();
		lst.add(12);
		lst.add(13);
		lst.add(14);
		lst.add(15);
		lst.add(16);
		lst.add(17);

		System.out.println(" Added Data " + lst);
		System.out.println(" Size of the list " + lst.size());
		int size = lst.size();
		for (int i = 0; i < size; i++) {
			lst.remove(0);
			System.out.println(" Data has been removed ");
			System.out.println(" Data After Delete " + lst);
		}
	}
}
