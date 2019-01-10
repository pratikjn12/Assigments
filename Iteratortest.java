package list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Iteratortest {

	public static void main(String[] args) {

		List<Object> lst = new LinkedList<>();
		lst.add(12);
		lst.add(13);
		lst.add("Test1");
		lst.add("Test12");
		lst.add("Test");

		Iterator<Object> itr = lst.iterator();
		while (itr.hasNext())

		{
			System.out.println("Print the Data" + itr.next());
			
			if (!(itr.hasNext()))
			
		{
			System.out.println("No Data To Add");
		}
		}

	}

}
