package list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Listwithiterator {

	public static void main(String[] args) {

		List<String> lst = new LinkedList<String>();
		lst.add("P");
		lst.add("Q");
		lst.add("R");
		lst.add("S");
		lst.add("T");
		lst.add("U");
		lst.add("V");
		lst.add("W");
		lst.add("X");
		lst.add("Y");
		lst.add("Z");
		lst.add("A");

		System.out.println("Added Data" +lst);
		
		Iterator<String> itr = lst.iterator();
		System.out.println(" Print Size of the List " + lst.size());

		while (itr.hasNext())

		{
			System.out.println(" Print Data " + itr.next());

			if (!(itr.hasNext())) {

				System.out.println(" Print null ");

			}
		}

		lst.remove("A");
		System.out.println(" After Removed Data " +lst);
	}
	
	
}
